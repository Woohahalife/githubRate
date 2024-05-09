package com.core.github.commitinfo.infrastructure;

import com.core.github.commitinfo.domain.CommitInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@DataJpaTest
class CommitInfoRepositoryTest {

    @Autowired
    private CommitInfoRepository commitInfoRepository;

    @Test
    @DisplayName("커밋의 작성자인 committer의 정보를 저장할 수 있다.")
    void test() {
        // given
        CommitInfo commitInfo1 = createCommitInfo("Woohahalife");
        CommitInfo commitInfo2 = createCommitInfo("asd144570");
        CommitInfo commitInfo3 = createCommitInfo("fc-soohyun");

        commitInfoRepository.saveAll(List.of(commitInfo1, commitInfo2, commitInfo3));

        // when
        List<CommitInfo> commitInfoList = commitInfoRepository.findAll();

        // then
        assertThat(commitInfoList).hasSize(3)
                .extracting("id", "committer")
                .containsExactlyInAnyOrder(
                        tuple(1L, "Woohahalife"),
                        tuple(2L, "asd144570"),
                        tuple(3L, "fc-soohyun")
                );
    }

    private CommitInfo createCommitInfo(String committer) {
        return CommitInfo.builder()
                .committer(committer)
                .build();
    }
}