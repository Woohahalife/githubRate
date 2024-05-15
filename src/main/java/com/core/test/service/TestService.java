package com.core.test.service;

import com.core.test.controller.dto.ContentMapper;
import com.core.test.controller.dto.ContentResponse;
import com.core.test.domain.Content;
import com.core.test.repository.TestContentRepository;
import com.core.test.service.dto.ContentServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final ContentMapper contentMapper;
    private final TestContentRepository contentRepository;

    public ContentResponse saveContent(ContentServiceRequest serviceRequest) {

        System.out.println(serviceRequest.getName());
        System.out.println(serviceRequest.getContent());

        Content content = contentMapper.toEntity(serviceRequest);

        Content saveContent = contentRepository.save(content);

        return contentMapper.toResponse(content);
    }
}
