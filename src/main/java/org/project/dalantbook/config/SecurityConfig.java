package org.project.dalantbook.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .formLogin(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(request -> request
//                    .requestMatchers("/api/user/login", "/api/user/register").permitAll()  // 로그인 및 회원가입 API 허용
//                    .anyRequest().authenticated() // 나머지 모든 요청은 인증 필요
//                )
//                .sessionManagement(session -> session
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                ;
//
//        return http.build();
//    }
}
