package com.side.anitime.dto.response;

import com.side.anitime.codeconst.YesNo;
import com.side.anitime.domain.category.PlanCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class ResponsePlanDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Detail {
        private Long planId;
        private String title;
        private String contents;
    }

}
