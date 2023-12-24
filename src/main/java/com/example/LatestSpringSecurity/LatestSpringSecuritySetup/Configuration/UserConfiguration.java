package com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Configuration;

import com.example.LatestSpringSecurity.LatestSpringSecuritySetup.Service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class UserConfiguration {
    @Value("${user.authority.developer}")
    private String DEVELOPER_AUTHORITY;
    @Value("${user.authority.devops}")
    private String DEVOPS_AUTHORITY;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authConfig -> {
                   authConfig.requestMatchers(HttpMethod.POST,"/signup").permitAll();
                   authConfig.requestMatchers(HttpMethod.GET,"/developer").hasAuthority(DEVELOPER_AUTHORITY);
                    authConfig.requestMatchers(HttpMethod.GET,"/devops").hasAuthority(DEVOPS_AUTHORITY);
                    authConfig.requestMatchers(HttpMethod.GET,"/both").hasAnyAuthority(DEVELOPER_AUTHORITY,DEVOPS_AUTHORITY);
                    authConfig.anyRequest().permitAll();
                })

                        .csrf(csrf -> csrf.disable())

                        .formLogin(withDefaults())
                        .httpBasic(withDefaults());
        return http.build();

    }
    @Bean
    UserDetailsService userDetailsService(){
        return new UserService();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
