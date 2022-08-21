package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "LOJA")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 14, min = 14)
    @Column(unique = true, nullable = false, length = 14)
    private String cnpj;

    @Column(length = 255)
    private String descricao;

    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String email;

    @NotBlank
    @NotNull
    @Column(nullable = false, unique = true)
    private String nome;

    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String senha;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    // @OneToMany(mappedBy = "loja")
    // private List<Veiculos> veiculos;

    // public List<Veiculo> getVeiculos() {
    // return veiculos;
    // }

    // public void setVeiculos(List<Veiculo> veiculos) {
    // this.veiculos = veiculos;
    // }

    public void toStore(Store loja) {
        this.cnpj = loja.cnpj;
        this.descricao = loja.descricao;
        this.email = loja.email;
        this.nome = loja.nome;
        this.senha = loja.senha;
    }
}