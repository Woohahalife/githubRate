package com.core.github.repositoryInfo.application.dto;

import com.core.github.repositoryInfo.domain.RepositoryInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RepositoryInfoServiceRequest {

    private String ownerName;
    private String repo;

    @Builder
    public RepositoryInfoServiceRequest(String ownerName, String repo) {
        this.ownerName = ownerName;
        this.repo = repo;
    }

    public RepositoryInfo toEntity() {
        return RepositoryInfo.builder()
                .ownerName(ownerName)
                .repoName(repo)
                .build();
    }
}
