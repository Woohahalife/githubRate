package com.core.github.commitinfo.infrastructure;

import com.core.github.commitinfo.domain.CommitInfo;
import com.core.github.commitinfo.domain.CommitSha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitShaRepository extends JpaRepository<CommitSha, Long>  {
}
