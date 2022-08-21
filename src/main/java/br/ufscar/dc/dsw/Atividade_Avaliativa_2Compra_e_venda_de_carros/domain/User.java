package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "PESSOA")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(min = 11, max = 11)
    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @NotBlank
    @NotNull
    @Size(min = 11, max = 11)
    @Column(nullable = false, length = 11)
    private String telefone;

    @NotNull
    @Column
    private char sexo;

    @NotNull
    @Column(nullable = false)
    private Date dataNasc;

    @NotBlank
    @NotNull
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String senha;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private UserType tipo;

    public UserType getTipo() {
        return tipo;
    }

    public void setTipo(UserType tipo) {
        this.tipo = tipo;
    }

    public User() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void toUser(User usuario) {
        this.dataNasc = usuario.dataNasc;
        this.nome = usuario.nome;
        this.senha = usuario.senha;
        this.sexo = usuario.sexo;
        this.telefone = usuario.telefone;
        this.tipo = usuario.tipo;
        this.cpf = usuario.cpf;
        this.email = usuario.email;
    }

}