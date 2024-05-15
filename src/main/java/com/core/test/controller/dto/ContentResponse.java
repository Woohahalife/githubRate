package com.core.test.controller.dto;

import com.core.test.domain.constant.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ContentResponse {

    private String name;

    private String content;

    private Status status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Builder
    public ContentResponse(String name, String content, Status status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.content = content;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
