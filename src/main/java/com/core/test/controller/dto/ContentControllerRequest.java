package com.core.test.controller.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class ContentControllerRequest {

    private String name;

    private String content;

    @Builder
    private ContentControllerRequest(String name, String content) {
        this.name = name;
        this.content = content;
    }

}
