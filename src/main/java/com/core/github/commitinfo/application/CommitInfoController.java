package com.core.github.commitinfo.application;

import com.core.github.commitinfo.domain.dto.CommitInfoResponse;
import com.core.github.commitinfo.domain.dto.CommitInfomation;
import com.core.github.commitinfo.domain.dto.CommitResponse;
import com.core.github.commitinfo.presentation.CommitInfoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/github")
@RestController
@Slf4j
@Getter
public class CommitInfoController {

    private final GitHub github;
    private final CommitInfoService commitInfoService;

    @GetMapping("/commit/contributors/{owner}/{repo}") // repo의 팀원들을 DB에 저장
    public ResponseEntity<List<CommitInfoResponse>> saveContributors(

            @PathVariable(name = "owner") String owner,
            @PathVariable(name = "repo") String repo

    ) throws IOException {
        List<CommitInfoResponse> response = commitInfoService.saveContributors(getRepository(owner + "/" + repo));

        return ResponseEntity.created(URI.create("/commit/contributors")).body(response); // 201 응답
    }

    @GetMapping("/commit/save/{owner}/{repo}") // 커밋 내역을 save
    public void saveCommitInfo(

            @PathVariable(name = "owner") String owner,
            @PathVariable(name = "repo") String repo

    ) throws IOException {

        CommitResponse response = commitInfoService.saveCommitInfo(getRepository(owner + "/" + repo));

    }

    private GHRepository getRepository(String fullName) throws IOException {
        return github.getRepository(fullName);
    }

    private Date getEndOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DATE, 6);
        return calendar.getTime();
    }

    private Date getStartOfWeek() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

}
