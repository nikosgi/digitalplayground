package com.dp; 

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import static java.lang.System.out;
import com.dp.digip.service.UserDetailsServiceImpl;
import org.springframework.core.annotation.Order;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.security.web.savedrequest.NullRequestCache; 



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
	  	.antMatchers("/").permitAll()
	  	//.antMatchers("/login").permitAll()
	  	.antMatchers("/registration").permitAll()
          	.antMatchers("/login*","/","/css/**","/img/**","/js/**").permitAll()
	  	.antMatchers("/user/**").permitAll()//hasAuthority("ADMIN")
          	.antMatchers("/event/**").hasAuthority("ADMIN")
          	.anyRequest().authenticated()
	  	.and().csrf().disable() 
          .formLogin()
          	.loginPage("/login")
		.permitAll()          	
			.defaultSuccessUrl("/")
          		.failureUrl("/errorError")
	        .and()
          .logout()
		//.logoutUrl("/logout")
		.logoutSuccessUrl("/login")//?logout      
			//.logoutSuccessHandler(logoutSuccessHandler)
			.invalidateHttpSession(true)              
			//.addLogoutHandler(logoutHandler)               
			//.deleteCookies("SESSION")             	 
	       .and()
          .requestCache()
          .requestCache(new NullRequestCache())
          .and()
          .httpBasic(); 
	//.and().csrf().disable()
		
		          
    } 
    

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication()
        //  .withUser("user1").password("user1Pass").roles("ADMIN");
	auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder());
    }
/* 
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }
*/
/*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());  
    }
   */ 


}
