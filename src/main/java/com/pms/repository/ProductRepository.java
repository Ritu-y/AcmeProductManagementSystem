package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.model.Products;


@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{

	@Query(value="SELECT p from Products p where lower(p.pName) =lower(:pName)",nativeQuery=false)
	public Products getProductByPnameIgnoreCase(@Param(value="pName") String pName);
}
