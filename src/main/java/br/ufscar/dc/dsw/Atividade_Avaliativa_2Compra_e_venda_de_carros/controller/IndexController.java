package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IStoreDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IUserDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.User;

@Controller
public class IndexController {

    @Autowired
    IStoreDAO storeDAO;

    @Autowired
    IUserDAO userDAO;

    @GetMapping("/")
    public String index(Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss - dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        model.addAttribute("date", dateFormat.format(cal.getTime()));
        return "index";
    }

    // @GetMapping("/login")
    // public String formLogin(User usuario) {
    // return "login";
    // }

    // @PostMapping("/login")
    // public String login(User usuario, Model model, HttpSession session) {
    // try {
    // User novoUsuario = this.userDAO.findByEmail(usuario.getEmail());
    // System.out.println(novoUsuario.getTipo());
    // session.setAttribute("user", novoUsuario);
    // switch (novoUsuario.getTipo()) {
    // case "ROLE_ADMIN":
    // return "redirect:/admin/";
    // case "ROLE_USER":
    // return "redirect:/user/";
    // case "ROLE_STORE":
    // return "redirect:/store/";
    // }
    // } catch (Exception e) {
    // return "login";
    // }
    // return "index";
    // }

    // @GetMapping("/logout")
    // public String logout(HttpSession session) {
    // session.setAttribute("user", null);
    // return "redirect:/";
    // }
}
