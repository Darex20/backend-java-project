package croz.partsUnlimited.Unicorn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/warehouse/**").hasRole("WAREHOUSE").and()
                .formLogin().and().authorizeRequests()
                .antMatchers("/sales/**").hasRole("SALES").
                anyRequest().authenticated().and().httpBasic().and().logout().and().csrf().disable();
        //http.authorizeRequests().antMatchers("/sales/article").hasRole("CUSTOMER").
        //        and().formLogin();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("sales").password("prodaja").roles("SALES").password("{noop}prodaja");
        auth.inMemoryAuthentication().withUser("warehouse").password("skladište").roles("WAREHOUSE").password("{noop}skladište");
        auth.inMemoryAuthentication().withUser("customer").password("kupac").roles("CUSTOMER").password("{noop}kupac");
    }


}
