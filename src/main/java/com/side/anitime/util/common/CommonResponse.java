package com.side.anitime.util.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CommonResponse<T> {
    private int statusCode;
    private String responseMessage;
    private T data;

    public CommonResponse(final int statusCode, final String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
    }

    public static<T> CommonResponse<T> res(final int statusCode, final String responseMessage) {
        return res(statusCode, responseMessage);
    }

    public static<T> CommonResponse<T> res(final int statusCode, final String responseMessage, final T t) {
        return CommonResponse.<T>builder()
                .data(t)
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }
}
