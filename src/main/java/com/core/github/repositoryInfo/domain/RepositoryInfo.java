package com.core.github.repositoryInfo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class RepositoryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "repo_name")
    private String repoName;

    @Builder
    public RepositoryInfo(String ownerName, String repoName) {
        this.ownerName = ownerName;
        this.repoName = repoName;
    }
}
