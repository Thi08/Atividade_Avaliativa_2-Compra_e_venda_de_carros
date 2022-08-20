// package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao;

// import java.util.List;

// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;

// import
// br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.User;

// public interface IUserDAO extends CrudRepository<User, Long> {
// User findById(long id);

// List<User> findAll();

// void deleteById(long id);

// @Query("SELECT u FROM USUARIO u WHERE u.email = :email")
// public User getUserByEmail(@Param("email") String email);
// }
