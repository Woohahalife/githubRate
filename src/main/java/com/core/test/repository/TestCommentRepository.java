package com.core.test.repository;

import com.core.test.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCommentRepository extends JpaRepository<Comment, Long> {
}
