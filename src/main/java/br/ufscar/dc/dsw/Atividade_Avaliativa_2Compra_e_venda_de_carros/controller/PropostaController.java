// package
// br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.controller;

// import java.text.SimpleDateFormat;
// import java.util.Calendar;
// import java.util.Date;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;

// import
// br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.dao.IPropostaDAO;
// import
// br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.Proposta;
// import
// br.ufscar.dc.dsw.Atividade_Avaliativa_2Compra_e_venda_de_carros.domain.User;

// @Controller
// @RequestMapping("/propostas")
// public class PropostaController {

// @Autowired
// private IPropostaDAO iPropostaDAO;

// // Pega o usuário que está conectado
// // private User getUsuario() {
// // UsuarioDetails usuarioDetails = (UsuarioDetails)
// // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
// // return usuarioDetails.getUsuario();
// // }

// // Lista as propostas cadastradas
// @GetMapping("")
// public ModelAndView listar() {
// // Tenho que listar apenas as propostas da daquele carro e da loja
// List<Proposta> propostas = this.iPropostaDAO.findAll();
// ModelAndView mv = new ModelAndView("proposta/index");
// mv.addObject("propostas", propostas);

// return mv;
// }

// @GetMapping("/cadastrar")
// public String cadastrar(Proposta proposta) {
// String data = new SimpleDateFormat("dd/MM/yyyy
// HH:mm:ss").format(Calendar.getInstance().getTime());
// proposta.setUsuario(this.getUsuario());
// proposta.setData(data);
// return "compra/cadastro";
// }
// }
