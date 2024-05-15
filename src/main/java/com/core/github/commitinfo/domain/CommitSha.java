package com.core.github.commitinfo.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "commit_sha")
public class CommitSha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String sha1;

    @Column(name = "commit_date")
    public LocalDateTime commitDate;

    @Column(name = "commit_url")
    public String commitUrl;

    @ManyToOne
    @JoinColumn(name = "commit_author_id")
    public CommitInfo commitInfo;
}
