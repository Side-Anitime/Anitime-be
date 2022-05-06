package com.side.anitime.dto;

import com.side.anitime.codeconst.YesNo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ResponseAlarmDto {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Detail {
        private Long alarmId;
        private String title;
        private LocalDate time;
        private YesNo alarmYn;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetAlarmList {
        private List<Detail> alarmList = new ArrayList<>();
    }
}
