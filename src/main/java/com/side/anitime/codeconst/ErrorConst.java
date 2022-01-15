package com.side.anitime.codeconst;

import lombok.Getter;

@Getter
public enum ErrorConst {
    NOT_FOUND_TEST("E001", "없습니다.");

    private final String code;
    private final String message;

    ErrorConst(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
