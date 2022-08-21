package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IStoreDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IUserDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.Store;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private IStoreDAO storeDAO;

    @GetMapping("/")
    public String adminHome(Model model) {
        model.addAttribute("users", userDAO.findAll());
        model.addAttribute("stores", storeDAO.findAll());
        return "admin/home";
    }

    // Métodos para usuários.

    @GetMapping("/user")
    public String formUser(User user) {
        return "admin/formUser";
    }

    @PostMapping("/user")
    public String cadastraUser(@Valid User usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Verifique o dados inseridos");
            return "admin/formUser";
        } else {
            try {
                this.userDAO.save(usuario);
            } catch (Exception e) {
                model.addAttribute("error", "Já existe um usuário com essa combinação de dados");
                return "admin/formUser";
            }
            return "redirect:/admin/";
        }
    }

    @GetMapping("/user/{id}")
    public ModelAndView formEdicaoUser(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("admin/formEdicaoUser");
        User user = this.userDAO.getReferenceById(id);
        mv.addObject("user", user);
        return mv;
    }

    @PostMapping("/user/{id}")
    public String atualizaUser(@Valid User usuario, BindingResult result, @PathVariable Long id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Verifique o dados inseridos");
            return "admin/formEdicaoUser";
        } else {
            try {
                User userBanco = this.userDAO.getReferenceById(id);
                userBanco.toUser(usuario);
                this.userDAO.save(userBanco);
            } catch (Exception e) {
                model.addAttribute("error", "Já existe um usuário com essa combinação de dados");
                return "admin/formEdicaoUser";
            }
            return "redirect:/admin/";
        }
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userDAO.deleteById(id);
        return "redirect:/admin/";
    }

    // Métodos para lojas.

    @GetMapping("/loja")
    public String formLoja(Store loja) {
        return "admin/formLoja";
    }

    @PostMapping("/loja")
    public String cadastraLoja(@Valid Store loja, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Verifique o dados inseridos");
            return "admin/formLoja";
        } else {
            try {
                this.storeDAO.save(loja);
            } catch (Exception e) {
                model.addAttribute("error", "Já existe uma loja com essa combinação de dados");
                return "admin/formLoja";
            }
            return "redirect:/admin/";
        }
    }

    @GetMapping("/loja/{id}")
    public String formEdicaoLoja(Model model, @PathVariable("id") long id) {
        Store loja = this.storeDAO.getReferenceById(id);
        model.addAttribute("loja", loja);
        return "admin/formEdicaoLoja";
    }

    @PostMapping("/loja/{id}")
    public String atualizaLOja(@Valid Store loja, BindingResult result, @PathVariable Long id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Verifique o dados inseridos");
            return "admin/formEdicaoLoja";
        } else {
            try {
                Store lojaBanco = this.storeDAO.getReferenceById(id);
                lojaBanco.toStore(loja);
                this.storeDAO.save(lojaBanco);
            } catch (Exception e) {
                model.addAttribute("error", "Já existe um usuário com essa combinação de dados");
                return "admin/formEdicaoUser";
            }
            return "redirect:/admin/";
        }
    }

    @GetMapping("/loja/delete/{id}")
    public String deleteLoja(@PathVariable("id") long id) {
        this.storeDAO.deleteById(id);
        return "redirect:/admin/";
    }

}
