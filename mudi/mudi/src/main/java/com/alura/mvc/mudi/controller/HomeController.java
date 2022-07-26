package com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.model.StatusOrder;
import com.alura.mvc.mudi.repository.PedidoRepository;
import com.alura.mvc.mudi.service.CrudPedidoService;

@Controller //integrando com Spring
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private CrudPedidoService service;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		//Principal e uma interface que ajuda a buscar nesse caso o nome do usuario(injetando os dados do usuario logado)
		
		Sort sort = Sort.by("deliveryDate").ascending();//paginacao
		PageRequest page = PageRequest.of(0, 20, sort);//paginacao
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusOrder.DELIVERED, page);
		model.addAttribute("pedidos", pedidos);
		
		return "home"; 
	}
////	@GetMapping("/waiting")
////	public String waiting(Model model) {
////		
////		List<Pedido> pedidos = repository.findByStatus(StatusOrder.WAITING);
////		model.addAttribute("pedidos", pedidos);
////		
////		return "home"; 
//	}
	
//	@GetMapping("/{status}")//outra maneira de fazer a substituicao do status
//	public String byStatus(@PathVariable ("status")String status, Model model) {
//		List<Pedido> pedidos = repository.findByStatus(StatusOrder.valueOf(status.toUpperCase()));
//    	model.addAttribute("pedidos", pedidos);	
//    	model.addAttribute("status", status);//adicionar cor na selecao dos status quando clicar 
//    	return "home"; 
//	}
	@ExceptionHandler(IllegalArgumentException.class) //para passar a excessao que vc quer mapear
	public String onError() {//se o usurio digitar o status errado
		return "redirect:/home";
	}
}