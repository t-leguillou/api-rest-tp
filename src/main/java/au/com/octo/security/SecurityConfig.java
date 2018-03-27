package au.com.octo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    ApiOriginFilter corsFilter() {
        return new ApiOriginFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().requestMatchers(CorsUtils::isCorsRequest).permitAll()
                .antMatchers(HttpMethod.GET, "/", "/auth-callback", "/auth-callback**", "/monitoring", "/monitoring/**", "/actuator",
                        "actuator/**", "/v2/api-docs", "/swagger-ui/dist/*", "/swagger-resources/**",
                        "/configuration/**", "/assets/**", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css",
                        "/**/*.js")
                .permitAll().antMatchers(HttpMethod.GET, "/configuration/**")
                .permitAll().antMatchers("/api/applications/**").permitAll().anyRequest().authenticated().and();
        //.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*", "/**", "/auth-callback", "/auth-callback**", "/admin", "/v2/api-docs",
                "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html",
                "/webjars/**");
    }

}
