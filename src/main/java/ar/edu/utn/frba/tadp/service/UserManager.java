package ar.edu.utn.frba.tadp.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frba.tadp.dao.IUsuarioDao;
import ar.edu.utn.frba.tadp.entity.Usuario;

/*
 * La recomendación es que sólo se anoten clases concretas con la anotación @transaccional, en lugar de anotar las interfaces. 
 * Por supuesto, se puede colocar la anotación @transaccional en una interfaz (o un método de interfaz), pero esto sólo funcionará 
 * correctamente si está utilizando una interfaz basada en proxies.
 * 
 * */
	 
@Service("usuarioManager")
/**
 * El tener configurado este bean nos habilita a poder anotar nuestras clases y métodos con @Transactional y 
 * definir de esta forma nuestras transacciones de forma declarativa y dentro de nuestro código Java.
 * @Transactional en nuestra clase nos indica que todos los métodos definidos en esta clase van a ser transaccionales,
 * sino le agregamos los atributos por defecto son :
 * 1. propagation: REQUIRED, esto quiere decir que si el método no se ejecuta en un contexto transaccional, entonces spring 
 * crea una nueva transacción y si ya está en un contexto transaccional(por algún otro lado se inició una transacción), 
 * entonces el método se acopla a la transacción.
 * 2. isolation: DEFAULT, el nivel de aislamiento de la transacción.
 * 3. timeout: -1, el tiempo máximo en segundos que debe de ejecutarse la transacción.
 * 4. read-only: false, es la transacción no es solo lectura,  es decir nuestros métodos pueden realizar insert o update
 * @author Eduardo Zevallos
 *
 */
@Transactional
public class UserManager implements IUserManager{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Transactional
	public void addUser(Usuario user) {
		usuarioDao.addUser(user);
	}

	@Transactional
	public List<Usuario> getAllUsers() {
		return usuarioDao.getAllUsers();
	}

	@Transactional
	public void deleteUser(Integer userId) {
		usuarioDao.deleteUser(userId);
	}
	
}
