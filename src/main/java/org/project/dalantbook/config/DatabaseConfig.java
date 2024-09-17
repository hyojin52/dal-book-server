package org.project.dalantbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class DatabaseConfig {

    /**
     * Spring Security 적용 후에 수정 필요
     * - AS-IS : return test
     * - TO-BE : return 로그인 한 사용자의 ID
     * */
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("test-user"); // UUID.randomUUID().toString()
    }

}
