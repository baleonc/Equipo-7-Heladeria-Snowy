package co.edu.unbosque.ciclo3back.JPAdataAccess;

import co.edu.unbosque.ciclo3back.model.AdministratorUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


/**Service class that implements CRUD methods for table "usuarios" in db_heladeria_snowy 
 * database
 * @author Brayan Leon
 * @version 3 OCT 2021
 */

public interface AdmUserRepository extends JpaRepository<AdministratorUser, Long>
{
	/**This method implements a way to get the user by "cedula" field
	 * 
	 * @param cedulaIn A value of type Long that is the Id in the table usuarios 
	 * @return A generic class optional that wraps an optional value of type AdministratorUser
	 */
	public Optional<AdministratorUser> findByCedulaUsuario(Long cedulaIn);
	
	/**This method implements a way to get the user by "password" field
	 * 
	 * @param password
	 * @return A generic class optional that wraps an optional value of type AdministratorUser
	 */
	public Optional<AdministratorUser> findByPassword(String passwordIn);
	
	
	/**This method implements a way to get the user by "Usuario" field
	 * 
	 * @param usuarioIn A value of type String that is the user name in the table "usuarios" 
	 * @return A generic class optional that wraps an optional value of type AdministratorUser
	 */
	public Optional<AdministratorUser> findByUsuario(String usuarioIn);
}
