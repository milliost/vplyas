package com.example.vplyas.config.security;

import java.util.stream.Stream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
    http.oauth2Login(Customizer.withDefaults());

    return http.authorizeHttpRequests(c -> c.requestMatchers("/error").permitAll()
            .requestMatchers("/").permitAll()
            .requestMatchers("/img/**").permitAll()
            .requestMatchers("/css/**").permitAll()
            .requestMatchers("/js/**").permitAll()
            .requestMatchers(HttpMethod.POST).hasAuthority("ROLE_ADMIN")
            .requestMatchers(HttpMethod.PUT).hasAuthority("ROLE_ADMIN")
            .requestMatchers(HttpMethod.PATCH).hasAuthority("ROLE_ADMIN")
            .requestMatchers(HttpMethod.DELETE).hasAuthority("ROLE_ADMIN")
            .requestMatchers("/upload").hasAuthority("ROLE_ADMIN")
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
      var roles = jwt.getClaimAsStringList("spring_sec_roles");

      return Stream.concat(authorities.stream(),
              roles.stream()
                  .filter(role -> role.startsWith("ROLE_"))
                  .map(SimpleGrantedAuthority::new)
                  .map(GrantedAuthority.class::cast))
          .toList();
    });
    return coverter;
  }

  @Bean
  public OAuth2UserService<OidcUserRequest, OidcUser> oAuth2UserService() {
    var oidcUserService = new OidcUserService();
    return userRequest -> {
      var oidcUser = oidcUserService.loadUser(userRequest);
      var roles = oidcUser.getClaimAsStringList("spring_sec_roles");
      var authorities = Stream.concat(oidcUser.getAuthorities().stream(),
              roles.stream()
                  .filter(role -> role.startsWith("ROLE_"))
                  .map(SimpleGrantedAuthority::new)
                  .map(GrantedAuthority.class::cast))
          .toList();

      return new DefaultOidcUser(authorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
    };
  }
}
