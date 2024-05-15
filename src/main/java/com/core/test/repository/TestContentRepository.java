package com.core.test.repository;

import com.core.test.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestContentRepository extends JpaRepository<Content, Long> {
}
