package com.core.test.domain;

import com.core.test.common.BaseEntity;
import com.core.test.domain.constant.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Content(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.status = Status.ACTIVE;
    }

}
