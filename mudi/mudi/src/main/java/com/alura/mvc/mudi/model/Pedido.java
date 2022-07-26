package com.alura.mvc.mudi.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Pedido {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private BigDecimal price;
	private LocalDate deliveryDate;
	private String nameProduct;
	private String urlProduct;
	private String urlImage;
	private String overview;
	
	@Enumerated(EnumType.STRING)
	private StatusOrder status;//criar enum

	@ManyToOne(fetch = FetchType.LAZY)
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDataDaEntrega(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	
	
	
}
