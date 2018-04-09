package ar.edu.utn.frba.tadp.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frba.tadp.dao.IUsuarioDao;
import ar.edu.utn.frba.tadp.entity.Usuario;

/*
 * La recomendaci�n es que s�lo se anoten clases concretas con la anotaci�n @transaccional, en lugar de anotar las interfaces. 
 * Por supuesto, se puede colocar la anotaci�n @transaccional en una interfaz (o un m�todo de interfaz), pero esto s�lo funcionar� 
 * correctamente si est� utilizando una interfaz basada en proxies.
 * 
 * */
	 
@Service("usuarioManager")
/**
 * El tener configurado este bean nos habilita a poder anotar nuestras clases y m�todos con @Transactional y 
 * definir de esta forma nuestras transacciones de forma declarativa y dentro de nuestro c�digo Java.
 * @Transactional en nuestra clase nos indica que todos los m�todos definidos en esta clase van a ser transaccionales,
 * sino le agregamos los atributos por defecto son :
 * 1. propagation: REQUIRED, esto quiere decir que si el m�todo no se ejecuta en un contexto transaccional, entonces spring 
 * crea una nueva transacci�n y si ya est� en un contexto transaccional(por alg�n otro lado se inici� una transacci�n), 
 * entonces el m�todo se acopla a la transacci�n.
 * 2. isolation: DEFAULT, el nivel de aislamiento de la transacci�n.
 * 3. timeout: -1, el tiempo m�ximo en segundos que debe de ejecutarse la transacci�n.
 * 4. read-only: false, es la transacci�n no es solo lectura,  es decir nuestros m�todos pueden realizar insert o update
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
