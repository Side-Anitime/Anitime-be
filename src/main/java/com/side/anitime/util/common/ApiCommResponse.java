package com.side.anitime.util.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiCommResponse<T> {
    // api 통신 시간
    private LocalDateTime transactionTime;

    // api 응답 코드
    private String resultCode;

    // api 부가 설명
    private String description;

    private T data;

    // OK , No Data (200)
    public static <T> ApiCommResponse<T> OK() {
        return (ApiCommResponse<T>)ApiCommResponse.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode(ResultCode.OK.getCode())
                .description(ResultCode.OK.getMessage())
                .build();
    }

    // OK , No Data (200)
    public static <T> ApiCommResponse<T> OK(ResultCode resultCode) {
        return (ApiCommResponse<T>)ApiCommResponse.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode(resultCode.getCode())
                .description(resultCode.getMessage())
                .build();
    }

    // OK , Data (200)
    public static <T> ApiCommResponse<T> OK(T data) {
        return (ApiCommResponse<T>)ApiCommResponse.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode(ResultCode.OK.getCode())
                .description(ResultCode.OK.getMessage())
                .data(data)
                .build();
    }

    // OK , Data (200)
    public static <T> ApiCommResponse<T> OK(ResultCode resultCode, T data) {
        return (ApiCommResponse<T>)ApiCommResponse.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode(resultCode.getCode())
                .description(resultCode.getMessage())
                .data(data)
                .build();
    }

    // ERROR
    public static <T> ApiCommResponse<T> Error(ResultCode resultCode) {
        return (ApiCommResponse<T>)ApiCommResponse.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode(resultCode.getCode())
                .description(resultCode.getMessage())
                .build();
    }
}
