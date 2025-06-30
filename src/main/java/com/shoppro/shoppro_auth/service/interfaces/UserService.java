package com.shoppro.shoppro_auth.service.interfaces;


import com.shoppro.shoppro_auth.dto.request.RegisterRequest;

public interface UserService {
    void register(RegisterRequest request);
}