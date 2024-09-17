package com.grupo5.findmindsetbackend.Config;
package upao.Transa.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import upao.Transa.Security.JWTConfigurer;
import upao.Transa.Security.TokenProvider;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

    private final TokenProvider tokenProvider;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz)->authz
                        .requestMatchers("/auth/sign-up","/auth/sign-in","/auth/send-email-link","/auth/verify-email","/auth/forgot-password","/auth/reset-password","/usuarios/eliminar/{correo}","/usuarios/{id}","/user/send-email","/notifications/send-registration","/notifications/send-profile-deletion","/notifications/send-goal-notification","/notifications/send-purchase-notification").permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .sessionManagement(h -> h.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .with(new JWTConfigurer(tokenProvider), Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
