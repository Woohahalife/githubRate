package com.core.github.commitinfo.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CommitSha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String sha1;

    @Column(name = "commit_date")
    public LocalDateTime commitDate;

    public String commitUrl;

    @ManyToOne
    @JoinColumn(name = "commit_author_id")
    public CommitInfo commitInfo;
}
