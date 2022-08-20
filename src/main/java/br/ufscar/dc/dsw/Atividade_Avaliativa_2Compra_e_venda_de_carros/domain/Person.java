package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "PESSOA")
public class Person extends User {

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 11)
    private String telefone;

    @Column
    private char sexo;

    @Column(nullable = false)
    private Date dataNasc;

    public Person() {
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

}
