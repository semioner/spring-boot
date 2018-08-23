package com.semion.example.sample.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage<T> {

    private Integer code;

    private String message;

    private T data;

}
