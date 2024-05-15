package com.core.github.common.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class FlywayConfig {

    @Bean
    @Profile("dev")
    public Flyway flywayBeanMySQL() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://127.0.0.1:3306/githubrate?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul", "root", "alrtm1324!")
                .baselineOnMigrate(true).load();
        flyway.repair();
        flyway.migrate();
        return flyway;
    }

    @Bean
    @Profile("local")
    public Flyway flywayBeanH2() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:mem:testdb;MODE=MySQL", "sa", "")
                .baselineOnMigrate(true).load();
        flyway.repair();
        flyway.migrate();
        return flyway;
    }
}
