package com.core.test.service.dto;

import com.core.test.domain.constant.Status;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContentServiceRequest {

    private String name;

    private String content;

    private Status status;

    @Builder
    private ContentServiceRequest(String name, String content, Status status) {
        this.name = name;
        this.content = content;
        this.status = status;
    }
}
