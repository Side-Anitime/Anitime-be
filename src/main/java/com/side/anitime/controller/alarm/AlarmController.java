package com.side.anitime.controller.alarm;

import com.side.anitime.domain.alarm.Alarm;
import com.side.anitime.dto.alarm.ResponseAlarmDto;
import com.side.anitime.repository.alarm.AlarmRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/alarm")
@RequiredArgsConstructor
@Api(value = "알람 API", tags = "알람 API")
public class AlarmController {

    private final AlarmRepository alarmRepository;

    @ApiOperation(value = "알람 목록 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get alarm list", response = ResponseAlarmDto.class
            )
    })
    @GetMapping("{alarmId}")
    public ResponseEntity<?> getAlarmList(@PathVariable Long alarmId) {
        Alarm alarm = alarmRepository.findById(alarmId).orElseThrow(() -> new IllegalStateException("NotFoundException 클래스 생성 필요"));

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
