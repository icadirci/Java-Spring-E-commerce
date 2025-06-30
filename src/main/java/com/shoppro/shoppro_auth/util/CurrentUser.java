package com.shoppro.shoppro_auth.util;

import com.shoppro.shoppro_auth.entity.User;
import com.shoppro.shoppro_auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrentUser {
    private final UserRepository userRepository;
    
    public String getUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public Long getId() {
        return get().getId();
    }

    public User get() {
        String username = getUsername();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Giriş yapan kullanıcı bulunamadı"));
    }
}
