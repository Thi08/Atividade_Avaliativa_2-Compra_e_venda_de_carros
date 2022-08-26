package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.User;

public interface IUserDAO extends JpaRepository<User, Long> {

    public User findByEmail(String email);

}
