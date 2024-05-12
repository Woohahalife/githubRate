package com.core.github.repositoryInfo.presentation;

import com.core.github.repositoryInfo.application.RepositoryInfoService;
import com.core.github.repositoryInfo.presentation.dto.RepositoryInfoRequest;
import com.core.github.repositoryInfo.presentation.dto.RepositoryInfoResponse;
import com.core.github.repositoryInfo.presentation.dto.RepositoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/github")
@RestController
@Slf4j
public class RepositoryInfoController {

    private final RepositoryInfoService repositoryInfoService;

    @PostMapping("/repository/create")
    public ResponseEntity<RepositoryInfoResponse> registerRepositoryInfo(@RequestBody RepositoryInfoRequest request) throws IOException {

        RepositoryInfoResponse response = repositoryInfoService.registerRepositoryInfo(request.toServiceRequest());

        return ResponseEntity.created(URI.create("/repository" + response.getId() + "/read")).body(response);
    }

    @GetMapping("/repository/allread")
    public ResponseEntity<List<RepositoryResponse>> allRepositoryRead() {

//        List<RepositoryResponse> responses = repositoryInfoService.allRepositoryRead();

        return null;
    }

}
