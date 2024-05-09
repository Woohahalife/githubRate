package com.core.github.repositoryInfo.application;

import com.core.github.repositoryInfo.application.dto.RepositoryInfoServiceRequest;
import com.core.github.repositoryInfo.domain.RepositoryInfo;
import com.core.github.repositoryInfo.infrastructure.RepositoryInfoRepository;
import com.core.github.repositoryInfo.presentation.dto.RepositoryInfoResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;

@SpringBootTest
@ActiveProfiles("local")
class RepositoryInfoServiceTest {

    @Autowired
    private RepositoryInfoService repositoryInfoService;

    @Autowired
    private RepositoryInfoRepository repositoryInfoRepository;

    @MockBean
    private GitHub gitHub;

    @AfterEach
    void tearDown() {
        repositoryInfoRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("repository 정보를 저장할 수 있다.")
    void registerRepositoryInfo() throws IOException {

        // given
        GHRepository repository = Mockito.mock(GHRepository.class);
        given(gitHub.getRepository(anyString())).willReturn(repository);

        given(repository.getOwnerName()).willReturn("Woohahalife");
        given(repository.getName()).willReturn("repo");

        RepositoryInfoServiceRequest request = RepositoryInfoServiceRequest.builder()
                .ownerName("Woohahalife")
                .repo("repo")
                .build();

        // when
        RepositoryInfoResponse repositoryInfoResponse = repositoryInfoService.registerRepositoryInfo(request);

        // then
        assertThat(repositoryInfoResponse)
                .extracting("ownerName", "repo")
                .contains("Woohahalife", "repo");

    }
}