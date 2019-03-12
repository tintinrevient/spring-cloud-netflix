package io.github.tintinrevient.oauthserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";

//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        resources.resourceId(RESOURCE_ID).stateless(false);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.
//                anonymous().disable()
//                .authorizeRequests()
//                .antMatchers("/user/**").access("hasRole('ADMIN')")
//                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
//    }

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");
    }

}