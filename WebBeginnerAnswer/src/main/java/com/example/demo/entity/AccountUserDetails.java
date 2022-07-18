package com.example.demo.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private final User user;
	private final Collection<GrantedAuthority> authorities;

	public AccountUserDetails(User user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getName();
	}
	
	public String getRole() {
		return user.getRole();
	}

	public boolean isEnabled() {
		return true;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public User getUser() {
		return user;
	}
}
