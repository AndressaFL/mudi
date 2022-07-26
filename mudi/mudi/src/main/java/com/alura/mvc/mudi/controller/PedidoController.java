package com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.mvc.mudi.dto.ReqNewOrder;
import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.model.User;
import com.alura.mvc.mudi.repository.PedidoRepository;
import com.alura.mvc.mudi.repository.UserRepository;
import com.alura.mvc.mudi.service.CrudPedidoService;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CrudPedidoService service;
	
	
	
	@GetMapping("form")
	public String form(ReqNewOrder requisicao) {
		//service.salvar();
		return "pedido/form";
		
	}
	
	/*
	 * @PostMapping("new") public String novo(Pedido pedido) {
	 * service.salvar(pedido); return "pedido/form"; }
	 */
	
	@PostMapping("new")
	public String novo(@Valid ReqNewOrder requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/form";//se erro
		}
		
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByusername(username);
		
		Pedido pedido = requisicao.toPedido();//cria pedido
		pedido.setUser(user);
		pedidoRepository.save(pedido);//salva
		
		return "redirect:/home";//redireciona o usurio para a home
	}

}
