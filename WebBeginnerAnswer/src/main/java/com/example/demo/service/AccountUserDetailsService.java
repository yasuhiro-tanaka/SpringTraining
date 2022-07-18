package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.AccountUserDetails;
import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;

@Service
public class AccountUserDetailsService implements UserDetailsService {
	@Autowired
	UserDao userDao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = Optional.ofNullable(userDao.findByName(username))
				.orElseThrow(() -> new UsernameNotFoundException("user not found."));
		return new AccountUserDetails(user, getAuthorities(user));
	}

	private Collection<GrantedAuthority> getAuthorities(User user) {
		if (isAdmin(user)) {
			return AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}
	
	private boolean isAdmin(User user) {
		return "ADMIN".equals(user.getRole());
	}
}
