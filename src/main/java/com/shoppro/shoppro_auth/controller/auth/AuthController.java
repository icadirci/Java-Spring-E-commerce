package com.shoppro.shoppro_auth.controller.auth;

import com.shoppro.shoppro_auth.dto.common.ApiResponse;
import com.shoppro.shoppro_auth.dto.request.RegisterRequest;
import com.shoppro.shoppro_auth.service.interfaces.UserService;
import com.shoppro.shoppro_auth.util.ResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication", description = "Authentication endpoints")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@RequestBody RegisterRequest request) {
        try {
            userService.register(request);
            return ResponseUtil.success("Kullanıcı başarıyla oluşturuldu.", request.getUsername());
        } catch (Exception e) {
            return ResponseUtil.fail("Kullanıcı oluşturulamadı: " + e.getMessage());
        }
    }

    @GetMapping("/login")
    public ResponseEntity<ApiResponse<String>> login() {
        return ResponseUtil.success("Giriş başarılı.", null );
    }
}
