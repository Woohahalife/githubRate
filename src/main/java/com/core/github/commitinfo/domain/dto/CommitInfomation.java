package com.core.github.commitinfo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommitInfomation {

    private String committer;
    private Date commitDate;
    private String commitSha;
    private URL commitUrl;
}
