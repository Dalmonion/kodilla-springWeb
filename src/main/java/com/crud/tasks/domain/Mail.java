package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
//@AllArgsConstructor
//@RequiredArgsConstructor
@Builder
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private final String toCc;
}
