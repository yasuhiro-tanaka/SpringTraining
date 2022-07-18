package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.service.AccountUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AccountUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// ログイン不要
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
		// ログイン処理
		http.formLogin().loginProcessingUrl("/login").failureUrl("/login") // ログイン失敗時の遷移先
				.defaultSuccessUrl("/inquiry", true) // ログイン成功後の遷移先
				.usernameParameter("username")// ログインフォームで使用するユーザー名
				.passwordParameter("password")// ログインフォームで使用するパスワード
				;
		//ログアウト処理
		http.logout().logoutUrl("/logout") // ログアウトのURL
				.logoutSuccessUrl("/").invalidateHttpSession(true).permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 認証するユーザー情報をデータベースからロードする
		// その際、パスワードはBCryptで暗号化した値を利用する
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@SuppressWarnings("deprecation")
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
