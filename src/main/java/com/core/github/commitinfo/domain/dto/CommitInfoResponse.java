package com.core.github.commitinfo.domain.dto;

import com.core.github.commitinfo.domain.CommitInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommitInfoResponse {

    private final Long id;
    private final String committer;

    @Builder
    private CommitInfoResponse(Long id, String committer) {
        this.id = id;
        this.committer = committer;
    }

    public static CommitInfoResponse toClient(CommitInfo commitInfo) {
        return CommitInfoResponse.builder()
                .id(commitInfo.getId())
                .committer(commitInfo.getCommitter())
                .build();
    }
}
