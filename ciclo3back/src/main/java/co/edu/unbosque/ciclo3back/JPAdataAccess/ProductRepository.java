package co.edu.unbosque.ciclo3back.JPAdataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.ciclo3back.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	
}
