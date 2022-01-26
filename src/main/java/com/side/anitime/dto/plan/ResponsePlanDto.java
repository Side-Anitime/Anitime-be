package com.side.anitime.dto.plan;

import com.side.anitime.domain.category.PlanCategory;
import com.side.anitime.dto.alarm.ResponseAlarmDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsePlanDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Detail {
        private Long planId;
        private String title;
        private String contents;
        private PlanCategory planCategory;
        // TODO 단건 조회할 때 일정에 등록된 하나의 알람정보는 어떻게 들고오지..?
    }
}
