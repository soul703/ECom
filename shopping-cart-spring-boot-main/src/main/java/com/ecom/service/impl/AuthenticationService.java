package com.ecom.service.impl;

import com.ecom.model.UserDtls;
import com.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenprovider jwtTokenProvider;

    public String authenticateUser(String username, String password) {
        // Tìm người dùng trong cơ sở dữ liệu
        UserDtls user = userRepository.findByName(username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        // Nếu thông tin đăng nhập hợp lệ, tạo JWT
        return jwtTokenProvider.generateToken(username);
    }
}
