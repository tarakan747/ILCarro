package com.example.ilcarroappl.dto;

public class ErrorDto {
    int code;
    String message;

    @Override
    public String toString() {
        return "ErrorDto{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ErrorDto() {
    }

    public ErrorDto(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
