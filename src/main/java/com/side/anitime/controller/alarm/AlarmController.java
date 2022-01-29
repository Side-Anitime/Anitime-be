package com.side.anitime.controller.alarm;

import com.side.anitime.domain.alarm.Alarm;
import com.side.anitime.dto.alarm.ResponseAlarmDto;
import com.side.anitime.repository.alarm.AlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alarm")
@RequiredArgsConstructor
public class AlarmController {

    private final AlarmRepository alarmRepository;

    @GetMapping("{alarmId}")
    public ResponseEntity<?> getAlarmList(@PathVariable Long alarmId) {
        Alarm alarm = alarmRepository.findById(alarmId).orElseThrow(() -> new IllegalStateException("Error~"));

        return ResponseEntity.ok(
                ResponseAlarmDto.Detail.builder()
                        .alarmId(alarm.getAlarmId())
                        .title(alarm.getTitle())
                        .time(alarm.getTime())
                        .alarmYn(alarm.getAlarmYn())
                        .build()
        );
    }

    @GetMapping("/lists")
    public ResponseEntity<?> allAlarmList(){
        return ResponseEntity.ok(
          ResponseAlarmDto.GetAlarmList.builder()
                .build()
        );
    }

    @PutMapping("{alarmId}")
    public ResponseEntity<?> updateAlarmList(@PathVariable Long alarmId){
        return (ResponseEntity<?>) ResponseEntity.ok();
    }
}
