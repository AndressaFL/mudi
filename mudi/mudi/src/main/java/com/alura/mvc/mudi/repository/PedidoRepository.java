package com.alura.mvc.mudi.repository;


import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.model.StatusOrder;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	@Cacheable("home")
	List<Pedido> findByStatus(StatusOrder status, Pageable sort);//spring ja implementa o select para buscar pelo status
	
@Query("select p from Pedido p join p.user  u where u.username = :username")
	List<Pedido> findAllByUser(@Param("username")String username);


@Query("select p from Pedido p join p.user  u where u.username = :username and p.status = :status")
List<Pedido> findByStatusUser(@Param("status")StatusOrder status, @Param("username")String username);
	
}