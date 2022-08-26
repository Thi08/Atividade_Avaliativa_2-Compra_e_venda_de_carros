package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IUserDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.User;

@Controller
public class IndexController {

    @Autowired
    IUserDAO userDAO;

    @GetMapping("/")
    public String index(Model model, Authentication auth) {
        if (auth != null) {
            User user = userDAO.findByEmail(auth.getName());
            model.addAttribute("typeUser", user.getTipo());
            System.out.println(model.getAttribute("typeUser"));
        }
        return "index";
    }

    @GetMapping("/redirect")
    public String redirect(Model model, Authentication auth) {
        if (auth != null) {
            User user = userDAO.findByEmail(auth.getName());
            switch (user.getTipo()) {
                case "ROLE_ADMIN":
                    return "redirect:/admin";
                case "ROLE_STORE":
                    return "redirect:/loja";
                case "ROLE_USER":
                    return "redirect:/usuario";
            }
        }
        model.addAttribute("error", "Você não está autenticado");
        return "index";
    }
}
