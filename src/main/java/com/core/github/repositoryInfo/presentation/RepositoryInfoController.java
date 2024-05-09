package com.core.github.repositoryInfo.presentation;

import com.core.github.repositoryInfo.application.RepositoryInfoService;
import com.core.github.repositoryInfo.presentation.dto.RepositoryInfoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GitHub;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("/github")
@RestController
@Slf4j
public class RepositoryInfoController {

    private GitHub gitHub;
    private RepositoryInfoService repositoryInfoService;

    @GetMapping("")
    public ResponseEntity<Void> registerRepositoryInfo(@RequestBody RepositoryInfoRequest request) throws IOException {

        repositoryInfoService.registerRepositoryInfo(request.toServiceRequest());

        return ResponseEntity.ok().build();
    }

}
