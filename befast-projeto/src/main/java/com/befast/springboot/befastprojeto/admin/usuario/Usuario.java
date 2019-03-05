package com.befast.springboot.befastprojeto.admin.usuario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.befast.springboot.befastprojeto.admin.restricao.Restricao;
import com.befast.springboot.befastprojeto.admin.role.Role;
import com.befast.springboot.befastprojeto.admin.saldo.Saldo;

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
	
	@ManyToMany(fetch = FetchType.EAGER)	
	@JoinColumn(name = "restricao_id", foreignKey = @ForeignKey(name="FK_USUARIO_RESTRICAO"), insertable = true, updatable = true)
	private List<Restricao> restricoes;
	
	@Column(name="valor_calorico", columnDefinition="int default 0")
	private Long ValorCalorico; 
	
	@Column(name="matricula")
	private String matricula;

	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)	
	@JoinColumn(name = "saldo_id", foreignKey = @ForeignKey(name="FK_USUARIO_SALDO"), insertable = true, updatable = true)
	private List<Saldo> saldo;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
//	@JoinColumn(name = "usuario_id", foreignKey = @ForeignKey(name="FK_USUARIO_USUARIO"), insertable = true, updatable = true)
	@JoinColumn(name = "vinculo_id", referencedColumnName = "id", updatable = false, insertable = false)
	private List<Usuario> usuarios;

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
	
	/**
	 * @return the restricoes
	 */
	public List<Restricao> getRestricoes() {
		return restricoes;
	}

	/**
	 * @param restricoes the restricoes to set
	 */
	public void setRestricoes(List<Restricao> restricoes) {
		this.restricoes = restricoes;
	}

	public Long getValorCalorico() {
		return ValorCalorico;
	}

	public void setValorCalorico(Long valorCalorico) {
		ValorCalorico = valorCalorico;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the saldo
	 */
	public List<Saldo> getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(List<Saldo> saldo) {
		this.saldo = saldo;
	}
	
	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
