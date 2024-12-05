package com.ecom.config;

import com.ecom.service.impl.JwtTokenprovider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenprovider jwtTokenProvider;

    public JwtAuthenticationFilter(JwtTokenprovider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Lấy token từ header
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);  // Lấy phần token sau "Bearer "
            if (jwtTokenProvider.validateToken(token)) {
                // Lấy thông tin người dùng từ token và thiết lập vào SecurityContext
                String username = jwtTokenProvider.getUsernameFromToken(token);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}

