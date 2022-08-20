package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	private String nome;

	@Column(nullable = false)
	private String senha;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserTipo tipo;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UserTipo getTipo() {
		return tipo;
	}

	public void setTipo(UserTipo tipo) {
		this.tipo = tipo;
	}

}