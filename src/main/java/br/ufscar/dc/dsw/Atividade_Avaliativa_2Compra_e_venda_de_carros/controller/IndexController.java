package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IUserDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IVeiculoDAO;

@Controller
public class IndexController {

    @Autowired
    private IVeiculoDAO iVeiculoDAO;

    @Autowired
    private IUserDAO iUserDAO;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/index");
        mv.addObject("listaVeiculos", iVeiculoDAO.findAll());
        return mv;
    }
}
