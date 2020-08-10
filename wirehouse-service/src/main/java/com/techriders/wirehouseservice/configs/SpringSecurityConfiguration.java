package com.techriders.wirehouseservice.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableSwagger2
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    AuthSuccessHandler successHandler;


    @Bean
    SimpleUrlAuthenticationFailureHandler authFailureHandler(){
        return new SimpleUrlAuthenticationFailureHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication()
//                .withUser("username").password("password").roles("SELLER")
//                .and()
//                .withUser("username").password("password").roles("BUYER")
//                .and()
//                .withUser("username").password("password").roles("ADMIN");

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select user_name, password,admin_verification from user where user_name = ?")
                .authoritiesByUsernameQuery("select user_name, authority from authority where user_name = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/administration","/administration/*","/administration/**").hasRole("ADMIN")
                .antMatchers("/seller","/seller/*","/seller/**").hasRole("SELLER")
                .antMatchers("/buyer","/buyer/*","/buyer/**").hasRole("BUYER")
                .antMatchers("/","/database/**").permitAll()
                .and().formLogin().loginPage("/signin")
                .successHandler(successHandler)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/signin")
                .and().exceptionHandling().accessDeniedPage("/forbidden");

        //Those two settings below is to enable access h2 database via browser
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }


    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
//        return NoOpPasswordEncoder.getInstance();
    }
}
