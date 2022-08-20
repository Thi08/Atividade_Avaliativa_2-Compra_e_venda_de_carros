package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.Store;

@Controller
@RequestMapping("/lojas")
public class StoreController {

    @GetMapping("/cadastrar")
    public String cadastrar(Store store) {
        return "Store/cadastro";
    }
}
