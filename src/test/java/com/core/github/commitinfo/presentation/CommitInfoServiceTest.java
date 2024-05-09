package com.core.github.commitinfo.presentation;

import com.core.github.commitinfo.domain.CommitInfo;
import com.core.github.commitinfo.domain.dto.CommitInfoResponse;
import com.core.github.commitinfo.domain.dto.CommitResponse;
import com.core.github.commitinfo.infrastructure.CommitInfoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHPerson;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.PagedIterable;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@SpringBootTest
@ActiveProfiles("local")
class CommitInfoServiceTest {

    @Autowired
    private CommitInfoService commitInfoService;

    @Autowired
    private CommitInfoRepository commitInfoRepository;

    @MockBean
    private GHRepository ghRepository;


    @Test
    @DisplayName("repository에 소속된 contributor 데이터를 저장할 수 있다.")
    void saveContributors() throws IOException {
        // given
        Set<String> uniqueAuthors = new HashSet<>(Arrays.asList("Woohahalife", "asd144570", "fc-soohyun"));

        GHRepository repository = Mockito.mock(GHRepository.class);

        PagedIterable<GHRepository.Contributor> contributors = Mockito.mock(PagedIterable.class);
        given(repository.listContributors()).willReturn(contributors);

        List<GHRepository.Contributor> mockContributors = uniqueAuthors.stream()
                .map(author -> {
                    GHRepository.Contributor contributor = Mockito.mock(GHRepository.Contributor.class);
                    given(contributor.getLogin()).willReturn(author);
                    return contributor;
                })
                .collect(Collectors.toList());

        given(contributors.toList()).willReturn(mockContributors);

        // when
        List<CommitInfoResponse> commitInfoResponses = commitInfoService.saveContributors(repository);

        // then
        assertThat(commitInfoResponses).hasSize(3);

    }

    private CommitInfo createCommitInfo(String committer) {
        return CommitInfo.builder()
                .committer(committer)
                .build();
    }

}