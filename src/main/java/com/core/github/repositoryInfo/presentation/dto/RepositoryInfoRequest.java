package com.core.github.repositoryInfo.presentation.dto;

import com.core.github.repositoryInfo.application.dto.RepositoryInfoServiceRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RepositoryInfoRequest {

    private String ownerName;
    private String repo;

    @Builder
    private RepositoryInfoRequest(String ownerName, String repo) {
        this.ownerName = ownerName;
        this.repo = repo;
    }

    public RepositoryInfoServiceRequest toServiceRequest() {
        return RepositoryInfoServiceRequest.builder()
                .ownerName(ownerName)
                .repo(repo)
                .build();
    }
}
