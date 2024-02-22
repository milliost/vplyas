package com.example.vplyas.config.security;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
    return http.authorizeHttpRequests(c -> c.requestMatchers("/error").permitAll()
            .requestMatchers(HttpMethod.POST).hasAuthority("ROLE_ADMIN")
            .requestMatchers(HttpMethod.PUT).hasAuthority("ROLE_ADMIN")
            .requestMatchers(HttpMethod.PATCH).hasAuthority("ROLE_ADMIN")
            .requestMatchers(HttpMethod.DELETE).hasAuthority("ROLE_ADMIN")
            .anyRequest().authenticated())
        .build();
  }

  @Bean
  public JwtAuthenticationConverter jwtAuthenticationConverter() {
    var coverter = new JwtAuthenticationConverter();
    var jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
    coverter.setPrincipalClaimName("preferred_username");
    coverter.setJwtGrantedAuthoritiesConverter(jwt -> {

      var authorities = jwtGrantedAuthoritiesConverter.convert(jwt);
      var roles = (List<String>) jwt.getClaimAsMap("realm_access").get("roles");

      return Stream.concat(authorities.stream(),
          roles.stream()
              .filter(role -> role.startsWith("ROLE_"))
              .map(SimpleGrantedAuthority::new)
              .map(GrantedAuthority.class::cast))
          .toList();
    });
    return coverter;
  }
}
