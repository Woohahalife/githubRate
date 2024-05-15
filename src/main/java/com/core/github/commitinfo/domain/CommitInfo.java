package com.core.github.commitinfo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commit_info")
public class CommitInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String committer;

    @Column(name = "new_column")
    private String newColumn;

    @OneToMany(mappedBy = "commitInfo")
    public List<CommitSha> commitSha = new ArrayList<>();

}
