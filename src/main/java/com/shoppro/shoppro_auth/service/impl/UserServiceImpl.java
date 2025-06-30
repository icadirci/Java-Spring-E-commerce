package com.shoppro.shoppro_auth.service.impl;

import com.shoppro.shoppro_auth.dto.request.RegisterRequest;
import com.shoppro.shoppro_auth.entity.User;
import com.shoppro.shoppro_auth.enums.RabbitMqQueueType;
import com.shoppro.shoppro_auth.messaging.producer.RabbitMqProducer;
import com.shoppro.shoppro_auth.repository.UserRepository;
import com.shoppro.shoppro_auth.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RabbitMqProducer producer;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("ROLE_USER")
                .build();
        producer.sendMessage(RabbitMqQueueType.USER_REGISTERED_NOTIFICATION, "Kayıt olduğunuz için teşekkürler.");
        userRepository.save(user);
    }
}
