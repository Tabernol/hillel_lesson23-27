package com.example.hw23.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class MyStudyAuthenticationConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public MyStudyAuthenticationConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("Max")
                .password("{noop}1111")
                .authorities("ROLE_ADMIN")
                .and()
                .withUser("Smith")
                .password("{noop}hammer")
                .authorities("ROLE_USER");
    }
}
