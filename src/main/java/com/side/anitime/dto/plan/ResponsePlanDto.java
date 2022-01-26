package com.side.anitime.dto.plan;

import com.side.anitime.codeconst.YesNo;
import com.side.anitime.domain.category.PlanCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

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
        private PlanCategory planCategory; //TODO: 이녀석도 아래와 같이 마찬가지입니다
        private List<Alarm> alarms; //TODO: Dto 통신 시 다이렉트로 domain을 받아선 안됩니다~ Dto는 단순 데이터에서 조회온 값을 필요한 것 또는 가공을 위한 것이므로 Alarm에 대한 Dto를 생성해서 받아야 함
        // TODO 단건 조회할 때 일정에 등록된 하나의 알람정보는 어떻게 들고오지..?
    }

    public static class Alarm {
        private Long alarmId;
        private String title;
        private YesNo alarmYn;
        //..등등 있지만 예시로 3개만 작성 하였음
    }
}
