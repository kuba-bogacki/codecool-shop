package com.codecool.shop.security;

import com.codecool.shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private CustomerRepository customerRepository;

    @Autowired
    public WebSecurityConfiguration(DataSource dataSource, CustomerRepository customerRepository) {
        this.dataSource = dataSource;
        this.customerRepository = customerRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomCustomerDetailsService(customerRepository);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/show-basket", "/customers").hasAnyAuthority("ROLE_USER")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .rememberMe();
    }
}
