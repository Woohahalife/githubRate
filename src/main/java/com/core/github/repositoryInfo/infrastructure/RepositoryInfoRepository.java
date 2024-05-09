package com.core.github.repositoryInfo.infrastructure;

import com.core.github.repositoryInfo.domain.RepositoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInfoRepository extends JpaRepository<RepositoryInfo, Long> {
}
