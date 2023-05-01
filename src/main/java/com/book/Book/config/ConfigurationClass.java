package com.book.Book.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAsync
@ConditionalOnProperty(value = "price.enableSchedule", matchIfMissing = true, havingValue = "true")
@EnableJpaAuditing(auditorAwareRef = "createGetAuditorBean")
@EnableAspectJAutoProxy()
@EnableCaching
public class ConfigurationClass {
    @Bean
    public getAuditor createGetAuditorBean (){
        return new getAuditor();
    }
}
