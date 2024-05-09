package com.core.github.commitinfo.application;

import com.core.github.commitinfo.domain.CommitInfo;
import com.core.github.commitinfo.domain.dto.CommitInfoResponse;
import com.core.github.commitinfo.domain.dto.CommitInfomation;
import com.core.github.commitinfo.domain.dto.CommitResponse;
import com.core.github.commitinfo.infrastructure.CommitInfoRepository;
import com.core.github.commitinfo.infrastructure.CommitShaRepository;
import lombok.RequiredArgsConstructor;
import org.kohsuke.github.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommitInfoService {

    private final CommitInfoRepository commitInfoRepository;
    private final CommitShaRepository commitShaRepository;

    public List<CommitInfoResponse> saveContributors(GHRepository repository) throws IOException {

        Set<String> uniqueAuthors = repository.listContributors().toList()
                .stream()
                .map(GHPerson::getLogin) // 작성자 이름 추출
                .collect(Collectors.toSet()); // 중복제거

        List<CommitInfo> commitInfoList = commitInfoRepository.saveAll
                (
                        uniqueAuthors
                                .stream()
                                .map(author -> CommitInfo.builder().committer(author).build())
                                .collect(Collectors.toList())
                );

        return commitInfoList.stream()
                .map(CommitInfoResponse::toClient)
                .collect(Collectors.toList());

    }

    public CommitResponse saveCommitInfo(GHRepository ghRepository) throws IOException {

        PagedIterable<GHCommit> commits = ghRepository.queryCommits().list();

        List<CommitInfomation> authors = commits.toList().stream()
                .parallel() // 병렬 처리 : 취합속도 최적화
                .map(commit -> {
                    try {
                        return new CommitInfomation(commit.getCommitter().getLogin(), commit.getCommitDate(), commit.getSHA1(), commit.getHtmlUrl());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .filter(commitInfomation -> !commitInfomation.getCommitter().equals("web-flow")) // pr한 커밋은 필터링(구분 불가능)
                .sorted(Comparator.comparing(CommitInfomation::getCommitDate).reversed()) // 날짜순 정렬
                .collect(Collectors.toList());

        authors.forEach(authorName -> System.out.println("authorUrl = " + authorName.getCommitter()));

        return null;

    }

}
