package com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.model.StatusOrder;
import com.alura.mvc.mudi.repository.PedidoRepository;
import com.alura.mvc.mudi.service.CrudPedidoService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
//	@Autowired
//	private CrudPedidoService service;
	
	@GetMapping("pedido")
	public String home(Model model, Principal principal) {//Principal e uma interface que ajuda a buscar nesse caso o nome do usuario(injetando os dados do usuario logado)
		
		List<Pedido> pedidos = pedidoRepository.findAllByUser(principal.getName());
		model.addAttribute("pedidos", pedidos);
		
		return "user/home"; 
	}
	
	
	@GetMapping("pedido/{status}")//outra maneira de fazer a substituicao do status
	public String byStatus(@PathVariable ("status")String status, Model model, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findByStatusUser(StatusOrder.valueOf(status.toUpperCase()), principal.getName());
    	model.addAttribute("pedidos", pedidos);	
    	model.addAttribute("status", status);//adicionar cor na selecao dos status quando clicar 
    	return "user/home"; 
	}
	@ExceptionHandler(IllegalArgumentException.class) //para passar a excessao que vc quer mapear
	public String onError() {//se o usurio digitar o status errado
		return "redirect:/user/home";
	}

}
