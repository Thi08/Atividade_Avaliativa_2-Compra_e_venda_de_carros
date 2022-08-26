package br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IVeiculoDAO;
import br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.Veiculo;

@Controller
@RequestMapping("/veiculos")
public class StoreController {

    @Autowired
    private IVeiculoDAO iVeiculoDAO;

    // Lista os veiculos cadastrados
    @GetMapping("")
    public ModelAndView listar() {
        List<Veiculo> veiculos = this.iVeiculoDAO.findAll();
        ModelAndView mv = new ModelAndView("store/index");
        mv.addObject("veiculos", veiculos);

        return mv;
    }

    // Cadastra novo veículo
    @GetMapping("/cadastrar")
    public String cadastrar(Veiculo veiculo) {
        return "store/cadastrar";
    }

    // Salva os veiculo cadastrado caso não haja erro
    @PostMapping("")
    public String cadastrado(@Valid Veiculo veiculo, BindingResult bindingResult, RedirectAttributes attr) {

        if (bindingResult.hasErrors()) {
            return "store/cadastro";
        } else {
            this.iVeiculoDAO.save(veiculo);
            attr.addFlashAttribute("sucess", "Cadastro de veículos feito com sucesso");
            return "redirect:veiculos";
        }
    }

    // Exibi os detalhes do carro e as propostas
    @GetMapping("/{id}")
    public ModelAndView propostas(@PathVariable Long id) {
        Optional<Veiculo> optional = this.iVeiculoDAO.findById(id);

        if (optional.isPresent()) {
            Veiculo veiculo = optional.get();
            ModelAndView mv = new ModelAndView("store/propostas");
            mv.addObject("veiculo", veiculo);

            return mv;
        }
        // Caso não encontre um registo na tabela
        else {
            return new ModelAndView("redirect:/veiculos");
        }
    }

    // Editar veiculo
    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id, Veiculo veiculo) {
        Optional<Veiculo> optional = this.iVeiculoDAO.findById(id);

        if (optional.isPresent()) {
            veiculo = optional.get();
            ModelAndView mv = new ModelAndView("store/editar");
            mv.addObject("veiculo", veiculo);

            return mv;
        }
        // Caso não encontre um registo na tabela
        else {
            return new ModelAndView("redirect:/veiculos");
        }
    }

    // Salva o Veiculo editado caso não haja erro
    @PostMapping("/{id}")
    public ModelAndView editado(@PathVariable Long id, @Valid Veiculo veiculo, BindingResult bindingResult,
            RedirectAttributes attr) {

        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("store/editar");
            return mv;

        } else {
            Optional<Veiculo> optional = this.iVeiculoDAO.findById(id);
            attr.addFlashAttribute("sucess", "Criação de veículo feita com sucesso.");

            if (optional.isPresent()) {
                veiculo = veiculo.toVeiculo(optional.get());
                this.iVeiculoDAO.save(veiculo);

                return new ModelAndView("redirect:/veiculos/" + veiculo.getId());

            } else {
                return new ModelAndView("redirect:/veiculos");
            }
        }

    }

    // Excluir Veiculos
    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:/veiculos");

        try {
            this.iVeiculoDAO.deleteById(id);
            mv.addObject("mensagem", "Veiculo " + id + " excluido com sucesso!");
            mv.addObject("erro", false);

        } catch (EmptyResultDataAccessException e) {
            mv.addObject("mensagem", "Veiculo " + id + " não foi encontrado!");
            mv.addObject("erro", true);
        }

        return mv;
    }
}
