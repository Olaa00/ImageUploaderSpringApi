package com.olaapp.imageuploader;

import com.olaapp.imageuploader.model.User;
import com.olaapp.imageuploader.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsServiceImpl userDetailsService; //wstrzyknieta instancja tej klasy
    private UserRepo userRepo;

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, UserRepo userRepo) {
        this.userDetailsService = userDetailsService;
        this.userRepo = userRepo;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //       auth.inMemoryAuthentication().withUser(
//                new User("Ola",
//                        passwordEncoder().encode("pass123"),
//                        Collections.singleton(new SimpleGrantedAuthority("user"))));
        auth.userDetailsService(userDetailsService); //klasa odpowiedzialna za laczenie sie z klasa to userdetailsservice
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test1").hasRole("USER")
                .antMatchers("/test2").hasRole("ADMIN")
                .and()
                .formLogin().permitAll();
    }
    @Bean
    public PasswordEncoder passwordEncoder (){

        return new BCryptPasswordEncoder(); //haslo zahashowane z bcryptem jest takie samo jak hash z DB, login jest taki sam z DB, username unikalny dla kazdego usera
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
       User useruser = new User ("UserOla", passwordEncoder().encode("UserOla"), "ROLE_USER");
       User userAdmin = new User ("AdminOla", passwordEncoder().encode("AdminOla"), "ROLE_ADMIN");
        userRepo.save(useruser);
        userRepo.save(userAdmin);
    }


}
