// package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao;

// import java.util.List;

// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;

// import
// br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.Store;

// public interface IStoreDAO extends CrudRepository<Store, Long> {

// Store findById(long id);

// List<Store> findAll();

// void deleteById(long id);

// @Query("SELECT u FROM LOJA u WHERE u.email = :email")
// public Store getLojaByEmail(@Param("email") String email);
// }