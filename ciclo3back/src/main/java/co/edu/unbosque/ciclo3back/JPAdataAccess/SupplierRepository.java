package co.edu.unbosque.ciclo3back.JPAdataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.ciclo3back.model.Supplier;



public interface SupplierRepository extends JpaRepository<Supplier, Long>
{
	public Optional<Supplier> findByNitProveedor(Long nitProveedorIn); 
}
