package moch.ridwan.sentosa.blog.app.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

        UserDetails it = User.builder()
                .username("system")
                .password("{noop}Test123!!")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(it);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(cofigurer ->
                cofigurer
                        .requestMatchers(HttpMethod.GET, "/api/v1/posts").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/posts/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/v1/posts").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/posts/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/posts/**").hasRole("ADMIN"));

        httpSecurity.httpBasic();

        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }
}
