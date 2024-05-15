package com.core.test.service.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContentServiceRequest {

    private String name;

    private String content;

    @Builder
    private ContentServiceRequest(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
