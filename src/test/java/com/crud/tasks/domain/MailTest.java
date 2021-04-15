package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailTest {

    @Test
    public void builderMailCreation() {
        //Given & When
        Mail mail = Mail.builder()
                .mailTo("test1@test.com")
                .subject("TestSubject2")
                .message("Test Message 3")
                .toCc("testSecondary@test.com")
                .build();
        //Then
        assertEquals("test1@test.com", mail.getMailTo());
        assertEquals("testSecondary@test.com", mail.getToCc());
    }
}