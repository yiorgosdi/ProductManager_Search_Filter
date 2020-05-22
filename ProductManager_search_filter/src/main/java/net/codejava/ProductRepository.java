package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

	/*
	 * @Query("Select p FROM Product p WHERE p.name LIKE %?1%" +
	 * " OR p.brand LIKE %?1%" + " OR p.madein LIKE %?1% " )
	 */
	@Query("Select p FROM Product p WHERE " + "CONCAT(p.id, p.name, p.brand, p.madein, p.price)" 
			+ "LIKE %?1%")
	public List<Product> findAll(String keyword);
}
