package ar.edu.utn.frba.tadp.dao;

import java.util.List;



import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frba.tadp.entity.Usuario;

@Repository("usuarioDao")
public class UsuarioDao extends AbstractDao<Integer, Usuario> implements IUsuarioDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(Usuario user) {
		Transaction tx = getSession().beginTransaction();
		this.sessionFactory.getCurrentSession().save(user);
		tx.commit();
		//persist(user);
		/*this.sessionFactory.close();*/
	}

	public List<Usuario> getAllUsers() {
		List<Usuario> users;
		
		Transaction tx = getSession().beginTransaction();
		
		users = createEntityQuery("from Usuario");
		
		tx.commit();
		
		// no cerrar la session sino tira un error , ya que este listado se carga este cierra la session de session factory
		/*this.sessionFactory.close();*/
		
		return users;
/*		Criteria criteria = getSession().createCriteria(Usuario.class);
        return (List<Usuario>) criteria.list();*/
	}

	public void deleteUser(Integer userId) {
		Transaction tx = getSession().beginTransaction();
		// Si el usuario no se encuentra en la DB entonces el m�todo load() lanzar� una excepci�n de Hibernate. 
		// Usar load asumiendo que la instancia existe. No se debe usar este m�todo para determinar 
		// si una instancia existe (en cambio, usar get()). 
		// S�lo usar este m�todo para recuperar una instancia que se asume existe, 
		// en donde la no existencia ser�a un error real.
		Usuario user = (Usuario) getSession().load(Usuario.class, userId);
        if (null != user) {
            delete(user);
        }
		
        tx.commit();
/*		Query query = getSession().createSQLQuery("delete from Usuario where ID = :id");
        query.setInteger("id", userId);
        query.executeUpdate();	*/
	}

	public void updateUser(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	public Usuario findById(Integer id) {
		return getByKey(id);
	}


	

}
