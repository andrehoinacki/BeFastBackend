package com.befast.springboot.befastprojeto.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	@Column(name="id")	
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	@Column(name="nome")
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name = "role_id", foreignKey = @ForeignKey(name="FK_USUARIO_ROLE"), insertable = true, updatable = true)
	private Role role;

	public Usuario() {
		
	}
	
	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}
