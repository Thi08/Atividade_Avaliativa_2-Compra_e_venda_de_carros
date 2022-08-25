package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.ICostumerDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IStoreDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IUserDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.Costumer;

@SpringBootApplication
public class AtividadeAvaliativa2CompraEVendaDeCarrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtividadeAvaliativa2CompraEVendaDeCarrosApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUserDAO userDAO, IStoreDAO storeDAO, ICostumerDAO costumerDAO,
			BCryptPasswordEncoder encoder) {
		return (args) -> {
			Costumer user = new Costumer();
			user.setCpf("20193834932");
			user.setDataNasc(Date.valueOf("2000-03-24"));
			user.setEmail("admin@admin.com");
			user.setNome("Ademira");
			user.setSenha(encoder.encode("admin"));
			user.setSexo('F');
			user.setTelefone("11970707070");
			user.setTipo("ROLE_ADMIN");
			costumerDAO.save(user);
		};

	}
}
