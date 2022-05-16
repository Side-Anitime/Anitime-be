package com.side.anitime.dto;

import com.side.anitime.codeconst.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ResponsePetDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Detail {
        private Long id;
        private String name;
        private Gender gender;
    }

}
