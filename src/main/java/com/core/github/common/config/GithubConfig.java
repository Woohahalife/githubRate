package com.core.github.common.config;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GithubConfig {

    @Bean
    public GitHub githubInit() throws IOException {

        return new GitHubBuilder().withOAuthToken("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").build();

    }

}

