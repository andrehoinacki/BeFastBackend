package com.befast.springboot.befastprojeto.jwt;

import java.util.Collection;

import com.befast.springboot.befastprojeto.admin.saldo.Saldo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {

	private static final long serialVersionUID = 5155720064139820502L;

	private final Long id;
	private final String username;
	private final String password;
	private final String role;
	private String token = null;
	private Collection <Saldo> saldo;
	// private final Collection<? extends GrantedAuthority> authorities;

	public JwtUserDetails(Long id, String username, String password, String role, Collection<Saldo> saldos) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.saldo = saldos;
		// List<SimpleGrantedAuthority> authorities = new
		// ArrayList<SimpleGrantedAuthority>();
		// authorities.add(new SimpleGrantedAuthority(roles));

		// this.authorities = authorities;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	//	return authorities;
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the saldo
	 */
	public Collection<Saldo> getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Collection<Saldo> saldo) {
		this.saldo = saldo;
	}

}
