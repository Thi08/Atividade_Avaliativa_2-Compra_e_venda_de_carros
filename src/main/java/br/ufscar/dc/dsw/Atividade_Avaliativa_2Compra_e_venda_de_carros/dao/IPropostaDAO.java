package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.Proposta;

public interface IPropostaDAO extends JpaRepository<Proposta, Long> {
}
