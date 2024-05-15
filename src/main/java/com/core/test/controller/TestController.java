package com.core.test.controller;

import com.core.test.controller.dto.ContentControllerRequest;
import com.core.test.controller.dto.ContentMapper;
import com.core.test.controller.dto.ContentResponse;
import com.core.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class TestController {

    private final ContentMapper contentMapper;
    private final TestService testService;

    @PostMapping("/content/getAll")
    public ResponseEntity<ContentResponse> saveContent(@RequestBody ContentControllerRequest contentRequest) {

        System.out.println("contentRequest.getName() = " + contentRequest.getName());
        System.out.println("contentRequest.getContent() = " + contentRequest.getContent());

        ContentResponse response = testService.saveContent(contentMapper.toService(contentRequest));

        return ResponseEntity.ok(response);
    }
}
