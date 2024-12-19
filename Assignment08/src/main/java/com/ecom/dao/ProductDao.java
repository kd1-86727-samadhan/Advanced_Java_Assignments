package com.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecom.pojos.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

	@Query("select p from Product p where p.status = :status")
	List<Product> findByStatus(@Param("status") int status);
}
