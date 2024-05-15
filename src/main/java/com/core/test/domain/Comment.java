package com.core.test.domain;

import com.core.test.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne // 단방향
    @JoinColumn(name = "content_id")
    private Content content;

    @Builder
    private Comment(Long id, String comment, Content content) {
        this.id = id;
        this.comment = comment;
        this.content = content;
    }
}
