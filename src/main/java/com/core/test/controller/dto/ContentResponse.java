package com.core.test.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ContentResponse {

    public String name;

    public String content;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;

}
