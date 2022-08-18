package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }
}
