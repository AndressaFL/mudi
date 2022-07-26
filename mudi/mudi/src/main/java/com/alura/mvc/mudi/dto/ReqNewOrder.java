package com.alura.mvc.mudi.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.model.StatusOrder;

public class ReqNewOrder {
	
@NotBlank //nao pode ser nulo nem vazio
	private String nameProduct;
@NotBlank
	private String urlProduct;
@NotBlank
	private String urlImage;

	private String overview;
	
	@Enumerated(EnumType.STRING)
	private StatusOrder status;
	
	
	
	public StatusOrder getStatus() {
		return status;
	}


	public void setStatus(StatusOrder status) {
		this.status = status;
	}


	public String getNameProduct() {
		return nameProduct;
	}


	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}


	public String getUrlProduct() {
		return urlProduct;
	}


	public void setUrlProduct(String urlProduct) {
		this.urlProduct = urlProduct;
	}


	public String getUrlImage() {
		return urlImage;
	}


	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}


	public String getOverview() {
		return overview;
	}


	public void setOverview(String overview) {
		this.overview = overview;
	}

		
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setOverview(overview);
		pedido.setNameProduct(nameProduct);
		pedido.setUrlImage(urlImage);
		pedido.setUrlProduct(urlProduct);
		pedido.setStatus(StatusOrder.WAITING);
		return pedido;
	}
	
	
}