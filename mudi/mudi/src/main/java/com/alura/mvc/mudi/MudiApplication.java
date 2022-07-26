package com.alura.mvc.mudi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.alura.mvc.mudi.service.CrudPedidoService;

@EnableCaching
@EnableJpaRepositories
@SpringBootApplication
public class MudiApplication implements CommandLineRunner {
	
	private final CrudPedidoService pedidoService;
	
	
	public MudiApplication(
			CrudPedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(MudiApplication.class, args);
		
		
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
	}

}
