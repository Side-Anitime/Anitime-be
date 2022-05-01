package com.side.anitime.controller.alarm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/alarm")
@RequiredArgsConstructor
@Api(value = "알람 API", tags = "알람 API")
public class AlarmController {

    //TODO: API 설계 확인하여 swagger 껍데기 만들기

//    private final AlarmRepository alarmRepository;

//    @ApiOperation(value = "알람 목록 조회")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully get alarm list", response = ResponseAlarmDto.class
//            )
//    })
//    @GetMapping("{alarmId}")
//    public ResponseEntity<?> getAlarmList(@PathVariable Long alarmId) {
//        Alarm alarm = alarmRepository.findById(alarmId).orElseThrow(() -> new IllegalStateException("NotFoundException 클래스 생성 필요"));
//
//        return ResponseEntity.ok(
//                ResponseAlarmDto.Detail.builder()
//                        .alarmId(alarm.getAlarmId())
//                        .build()
//        );
//    }

//    @GetMapping("/lists")
//    public ResponseEntity<?> allAlarmList(){
//        return ResponseEntity.ok(
//          ResponseAlarmDto.GetAlarmList.builder()
//                .build()
//        );
//    }
//
//    @PutMapping("{alarmId}")
//    public ResponseEntity<?> updateAlarmList(@PathVariable Long alarmId){
//        return (ResponseEntity<?>) ResponseEntity.ok();
//    }
}
