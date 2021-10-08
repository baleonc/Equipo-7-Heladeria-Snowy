package co.edu.unbosque.ciclo3back.JPAdataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.ciclo3back.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>
{
	public Optional<Client> findByCedulaCliente(Long cedulaCliente);
}
