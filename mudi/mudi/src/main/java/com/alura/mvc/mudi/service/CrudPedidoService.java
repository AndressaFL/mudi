package com.alura.mvc.mudi.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.alura.mvc.mudi.dto.ReqNewOrder;
import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.repository.PedidoRepository;

@Service
public class CrudPedidoService {
	
	private final PedidoRepository pedidoRepository;
	
	public CrudPedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	/*
	 * public void salvar(Pedido pedido) {
	 * 
	 * 
	 * // Pedido pedido = new Pedido(); // // pedido.setNameProduct(name);
	 * //pedido.setDescricao("Iphone 13 , pink"); //pedido.setUrlImagem(
	 * "https://www.apple.com/newsroom/images/product/iphone/standard/Apple_iphone13_hero_09142021_inline.jpg.large.jpg"
	 * ); //pedido.setValorNegociado(new BigDecimal( 900));
	 * 
	 * pedidoRepository.save(pedido);
	 * 
	 * 
	 * System.out.println("Salvo"); }
	 * 
	 */
	/*
	 * private void visualizar() { Iterable<Pedido> pedidos =
	 * pedidoRepository.findAll(); pedidos.forEach(pedido ->
	 * System.out.println(pedido)); }
	 */

	
	

}
