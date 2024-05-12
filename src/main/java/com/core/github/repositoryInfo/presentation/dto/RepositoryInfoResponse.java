package com.core.github.repositoryInfo.presentation.dto;

import com.core.github.repositoryInfo.domain.RepositoryInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RepositoryInfoResponse {

    private Long id;
    private String ownerName;
    private String repo;

    @Builder
    private RepositoryInfoResponse(Long id, String ownerName, String repo) {
        this.id = id;
        this.ownerName = ownerName;
        this.repo = repo;
    }

    public static RepositoryInfoResponse of(RepositoryInfo repositoryInfo) {
        return RepositoryInfoResponse.builder()
                .id(repositoryInfo.getId())
                .ownerName(repositoryInfo.getOwnerName())
                .repo(repositoryInfo.getRepoName())
                .build();
    }
}
