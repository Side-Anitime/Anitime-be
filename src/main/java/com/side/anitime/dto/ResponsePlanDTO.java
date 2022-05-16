package com.side.anitime.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ResponsePlanDTO {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Detail {
        private Long planId;
        private String title;
        private String contents;
    }

}
