package com.ecom.config;

import com.ecom.service.impl.JwtTokenprovider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Configuration
public class SecurityConfig {

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	@Lazy
	private AuthFailureHandlerImpl authenticationFailureHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, JwtTokenprovider jwtTokenprovider) throws Exception
	{
		http.csrf(csrf->csrf.disable()).cors(cors->cors.disable())
				.authorizeHttpRequests(req->req.requestMatchers("/user/**").hasRole("USER")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/**").permitAll())
				.formLogin(form->form.loginPage("/signin")
						.loginProcessingUrl("/login")
//						.defaultSuccessUrl("/")
						.failureHandler(authenticationFailureHandler)
						.successHandler(authenticationSuccessHandler))
				.addFilterBefore(new JwtAuthenticationFilter(jwtTokenprovider), UsernamePasswordAuthenticationFilter.class)
				.logout(logout->logout.permitAll())
				.sessionManagement(session->session.maximumSessions(1)
						.expiredUrl("/signin?expired=true").maxSessionsPreventsLogin(false))
				;

		
		return http.build();
	}
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

}


