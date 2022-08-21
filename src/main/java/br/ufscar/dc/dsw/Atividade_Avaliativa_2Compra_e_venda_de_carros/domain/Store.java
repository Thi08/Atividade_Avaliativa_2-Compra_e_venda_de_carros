package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain;

import javax.persistence.*;

@Entity
@Table(name = "LOJA")
public class Store extends User {

    @Column(unique = true, nullable = false, length = 14)
    private String cnpj;

    @Column(length = 255)
    private String descricao;

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

    // @OneToMany(mappedBy = "loja")
    // private List<Veiculos> veiculos;

    // public List<Veiculo> getVeiculos() {
    // return veiculos;
    // }

    // public void setVeiculos(List<Veiculo> veiculos) {
    // this.veiculos = veiculos;
    // }
}