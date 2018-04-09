package ar.edu.utn.frba.tadp.util;

import org.hibernate.Session;

public class HibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario user = new Usuario();
		
		//Get Session
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		user = (Usuario) session.load(Usuario.class, 9);
		
		// el método get() buscará en el caché de la Session, el cual retornara un proxy, loco no ?
		// este compratamiento es simetrico, si invertimos las sentencias.
		user = (Usuario) session.get(Usuario.class, 9);
		
		
		System.out.println("User ID=" + user.getUsername());

		// terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}

}
