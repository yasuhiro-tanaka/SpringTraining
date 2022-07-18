package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//ログイン不要
		http.authorizeRequests()
			.antMatchers("/", "/login").permitAll()
			.anyRequest().authenticated();
		//ログイン処理
		http.formLogin()
			.loginProcessingUrl("/login")
			.loginPage("/index")
			.failureUrl("/login") //ログイン失敗時の遷移先
			.defaultSuccessUrl("/inquiry", true); //ログイン成功後の遷移先
		
		http.logout()
			.logoutUrl("/logout") //ログアウトのURL
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true); 
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("user").roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
