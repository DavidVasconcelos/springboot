package br.com.alura.listavip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.listavip.models.Convidado;
import br.com.alura.listavip.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService service;

	@RequestMapping("/")
	private String index() {
		return "index";
	}

	@RequestMapping("listavip")
	private String listaConvidados(Model model) {
		Iterable<Convidado> convidados = service.obterTodos();
		model.addAttribute("convidados", convidados);

		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {

		Convidado novoConvidado = new Convidado(nome, email, telefone);
		service.salvar(novoConvidado);
		
		//new EmailService().enviar(nome, email);
		
		Iterable<Convidado> convidados = service.obterTodos();
	    model.addAttribute("convidados", convidados);

		return "listaconvidados";
	}
	
	@RequestMapping("pesquisar")
	private String pesquisar(@RequestParam("nome") String nome, Model model) {
		Iterable<Convidado> convidados = service.obterPorNome(nome);
		model.addAttribute("convidados", convidados);

		return "listaconvidados";
	}

}
