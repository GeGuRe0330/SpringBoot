package com.kh.image_shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("security config ...");
        // csrf 토큰 비활성화
        http.csrf().disable();
        // CustomLoginSuccessHandler를 로그인 성공 처리자로 지정한다.
        http.formLogin()
                .loginPage("/auth/login")
                .loginProcessingUrl("/login")
                .successHandler(createAuthenticationSuccessHandler());
        // CustomLoginSuccessHandler를 접근 거부자로 지정한다.
        http.exceptionHandling()
                .accessDeniedHandler(createAccessDeniedHandler());
        // 데이터 소스를 지정하고 테이블을 이용해서 기존 로그인 정보를 기록
        // 쿠키의 유효시간(24시간)을 지정한다.
        http.rememberMe()
                .key("zeus")
                .tokenRepository(createJDBCRepository())
                .tokenValiditySeconds(60 * 60 * 24);
        return http.build();
    }

    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
