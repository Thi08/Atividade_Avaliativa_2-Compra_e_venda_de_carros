package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "VEICULO")
public class Veiculo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotBlank
  @Column(nullable = false, length = 8, unique = true)
  private String placa;

  @NotNull
  @NotBlank
  @Column(nullable = false)
  private String modelo;

  @NotNull
  @NotBlank
  @Column(nullable = false, unique = true)
  private String chassi;

  @NotNull
  @Column(nullable = false, length = 4)
  private int ano;

  @NotNull
  @Column(nullable = false)
  private float quilometragem;

  @Column(nullable = false)
  private String descricao;

  @NotNull
  @Column(nullable = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
  private float valor;

  private String fotos;

  @ManyToOne
  @JoinColumn(name = "cnpj")
  private Store lojaCNPJ;

  public Store getLojaCNPJ() {
    return lojaCNPJ;
  }

  public void setLojaCNPJ(Store lojaCNPJ) {
    this.lojaCNPJ = lojaCNPJ;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getChassi() {
    return chassi;
  }

  public void setChassi(String chassi) {
    this.chassi = chassi;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public float getQuilometragem() {
    return quilometragem;
  }

  public void setQuilometragem(float quilometragem) {
    this.quilometragem = quilometragem;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public float getValor() {
    return valor;
  }

  public void setValor(float valor) {
    this.valor = valor;
  }

  public String getFotos() {
    return fotos;
  }

  public void setFotos(String fotos) {
    this.fotos = fotos;
  }

  public Veiculo toVeiculo(Veiculo veiculo) {
    veiculo.setPlaca(this.placa);
    veiculo.setModelo(this.modelo);
    veiculo.setChassi(this.chassi);
    veiculo.setAno(this.ano);
    veiculo.setQuilometragem(this.quilometragem);
    veiculo.setDescricao(this.descricao);
    veiculo.setValor(this.valor);
    veiculo.setFotos(this.fotos);

    return veiculo;
  }
}
