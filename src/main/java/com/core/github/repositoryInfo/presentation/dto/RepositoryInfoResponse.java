package com.core.github.repositoryInfo.presentation.dto;

import com.core.github.repositoryInfo.domain.RepositoryInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RepositoryInfoResponse {

    private String ownerName;
    private String repo;

    @Builder
    private RepositoryInfoResponse(String ownerName, String repo) {
        this.ownerName = ownerName;
        this.repo = repo;
    }

    public static RepositoryInfoResponse of(RepositoryInfo repositoryInfo) {
        return RepositoryInfoResponse.builder()
                .ownerName(repositoryInfo.getOwnerName())
                .repo(repositoryInfo.getRepoName())
                .build();
    }
}
