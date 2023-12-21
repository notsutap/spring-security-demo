package com.spring.security.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String password;
	
	private boolean active;
	
	private List<SimpleGrantedAuthority> authorities;
	
	private boolean accountNonExpired;
	
	private boolean accountNonLocked;
	
	private boolean credentialsNonExpired;
	
	public MyUserDetails(User user) {
		super();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.accountNonExpired = user.isAccountNonExpired();
		this.accountNonLocked = user.isAccountNonLocked();
		this.credentialsNonExpired = user.isCredentialsNonExpired();
		this.authorities = Arrays.stream(user.getRoles().split(","))
						.map(SimpleGrantedAuthority::new)
						.toList();
				
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

	
	

	
	
}
