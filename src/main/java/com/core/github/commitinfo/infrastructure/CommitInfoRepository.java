package com.core.github.commitinfo.infrastructure;

import com.core.github.commitinfo.domain.CommitInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitInfoRepository extends JpaRepository<CommitInfo, Long> {
}
