package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.controller;

import java.util.List;

import javax.persistence.metamodel.Metamodel;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IPropostaDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IUserDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IVeiculoDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.Proposta;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.User;

@Controller
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private IVeiculoDAO iVeiculoDAO;

    @Autowired
    IPropostaDAO propostaDAO;

    @Autowired
    IUserDAO userDAO;

    @GetMapping("")
    public ModelAndView homePage(Authentication auth) {
        ModelAndView mv = new ModelAndView("user/home");
        User user = userDAO.findByEmail(auth.getName());
        List<Proposta> propostasFeitas = propostaDAO.findAllByUsuario(user);
        mv.addObject("propostas", propostasFeitas);
        mv.addObject("listaVeiculos", iVeiculoDAO.findAll());
        return mv;
    }

    @PostMapping("/proposta/{id}")
    public String fazerProposta(Metamodel model, @PathParam("id") Long id) {
        return "redirect:/usuario";
    }
}
