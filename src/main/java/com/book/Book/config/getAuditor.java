package com.book.Book.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class getAuditor implements AuditorAware <String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Tester");
    }
}
