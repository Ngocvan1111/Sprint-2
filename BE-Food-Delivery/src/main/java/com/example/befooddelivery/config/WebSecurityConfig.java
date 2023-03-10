package com.example.befooddelivery.config;

import com.example.befooddelivery.jwt.jwt.JwtEntryPoint;
import com.example.befooddelivery.jwt.jwt.JwtTokenFilter;
import com.example.befooddelivery.jwt.userprincal.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountDetailService accountDetailService;

    @Autowired
    private JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("api/admin/**", "api/category/**", "api/product/**").access("hasRole('ADMIN')");
        httpSecurity.authorizeRequests().antMatchers("api/change-avatar", "api/product/**").access("hasAnyRole('ADMIN','USER')");
        httpSecurity.cors().and().csrf().disable()// hu??? CrossOrigin
                .authorizeRequests()
                .antMatchers("/**") // cho t???t c??? c??c role v??o
                .permitAll()
                .anyRequest()
                .authenticated()// khi c?? account ????ng nh???p
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtEntryPoint) // l???p g??c c???ng
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
