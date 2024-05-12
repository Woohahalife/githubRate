package com.core.github.repositoryInfo.application;

import com.core.github.repositoryInfo.application.dto.RepositoryInfoServiceRequest;
import com.core.github.repositoryInfo.domain.RepositoryInfo;
import com.core.github.repositoryInfo.infrastructure.RepositoryInfoRepository;
import com.core.github.repositoryInfo.presentation.dto.RepositoryInfoResponse;
import com.core.github.repositoryInfo.presentation.dto.RepositoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class RepositoryInfoService {

    private final GitHub gitHub;
    private final RepositoryInfoRepository repositoryInfoRepository;

    public RepositoryInfoResponse registerRepositoryInfo(RepositoryInfoServiceRequest request) throws IOException {

        GHRepository repository = gitHub.getRepository(
                request.getOwnerName() +
                "/" +
                request.getRepo()
        );

        String ownerName = repository.getOwnerName();
        String repoName = repository.getName();

        if(!request.getOwnerName().equals(ownerName) || !request.getRepo().equals(repoName)) {
            throw new IOException("입력 & 반환 데이터가 다름");
        }

        RepositoryInfo repositoryInfo = request.toEntity();

        return RepositoryInfoResponse.of(repositoryInfoRepository.save(repositoryInfo));
    }

//    public List<RepositoryResponse> allRepositoryRead() {
//
//
//    }
}
