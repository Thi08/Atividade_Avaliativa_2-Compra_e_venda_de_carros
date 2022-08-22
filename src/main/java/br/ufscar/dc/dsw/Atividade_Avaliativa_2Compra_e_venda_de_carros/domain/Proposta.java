package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PROPOSTA")
public class Proposta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(nullable = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
  private float valor;

  private String data;

  private String status;

  @ManyToOne
  @JoinColumn(name = "cpf")
  private User userCPF;

  @ManyToOne
  @JoinColumn(name = "placa")
  private Veiculo veicPlaca;

  @ManyToOne
  @JoinColumn(name = "cnpj")
  private Store lojaCNPJ;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public float getValor() {
    return valor;
  }

  public void setValor(float valor) {
    this.valor = valor;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public User getUserCPF() {
    return userCPF;
  }

  public void setUserCPF(User userCPF) {
    this.userCPF = userCPF;
  }

  public Veiculo getVeicPlaca() {
    return veicPlaca;
  }

  public void setVeicPlaca(Veiculo veicPlaca) {
    this.veicPlaca = veicPlaca;
  }

  public Store getLojaCNPJ() {
    return lojaCNPJ;
  }

  public void setLojaCNPJ(Store lojaCNPJ) {
    this.lojaCNPJ = lojaCNPJ;
  }

}
