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

