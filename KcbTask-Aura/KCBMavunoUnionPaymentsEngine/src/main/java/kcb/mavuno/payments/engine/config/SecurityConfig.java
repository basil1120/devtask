package kcb.mavuno.payments.engine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(HttpSecurity http) throws Exception 
    {
		http.csrf().disable().headers().frameOptions().sameOrigin().and().
		   authorizeRequests().anyRequest().anonymous().and().httpBasic().disable();
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception 
    {
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password("{noop}admin")
            .roles("USER");
    }

}
