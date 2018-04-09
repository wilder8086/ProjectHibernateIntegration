package ar.edu.utn.frba.tadp.dao;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract  class AbstractDao<PK extends Serializable, T> {
	
	/**
	 * Una SessionFactory es un objeto costoso de crear destinado a ser compartido por todos los subprocesos de la aplicaci�n. 
	 * Se crea una vez, generalmente al inicio de la aplicaci�n, desde una instancia de Configuraci�n.
	 */
    @Autowired
    private SessionFactory sessionFactory;
 
    private final Class<T> persistentClass;
    
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }    
    
    protected Session getSession() {
    	/* Una session es un objeto no seguro, que debe usarse una vez y luego descartarse para: una solo request, 
    	 * una conversaci�n o una sola unidad de trabajo(unit of work, un conjunto de operaciones que deen llevarse a cabo juntas,
    	 * aunque cumplir una unit of work abarcara multiples transacciones de DB fisicas).
    	 * Una sesi�n no obtendr� una conexi�n JDBC o un origen de datos, a menos que sea necesario. 
    	 * No consumir� ning�n recurso hasta que se use.
    	 * 
    	 * sessionFactory.openSession(), este m�todo siempre abre una nueva sesion que se debe vaciar(flush) y cerrar explicitamente
    	 * una vez que se haya terminada las operaciones.
    	 * No necesita configurar ninguna propiedad para llamar a este m�todo, por ejemplo no necesuta setear la propiedad:
    	 * <prop key="hibernate.current_session_context_class">thread</prop>
    	 * 
    	 * sessionFactory.getCurrentSession(), ese m�todo devuelve una session vinculada al contexto de hibernate actual, 
    	 * o sea, crea una nueva sesi�n si no existe una ya abierta, y si ya existe una te devuelve la del contexto de hibernate actual. 
    	 * Pero cuando haces commit a una transacci�n, la siguiente vez que se invoque getCurrentSession te dar� una sesi�n diferente.
    	 * No es necesario vaciar/limpiar(flush), ni que se cierre la sesion. Hibernate lo hace automaticamente con los atributos de 
    	 * auto-flush y auto-close cuando termina una tx, y lo hace hibernate internamente.
    	 * Necesita configurar la propiedad : <prop key="hibernate.current_session_context_class">thread</prop>, caso contrario generara
    	 * una excepcion.
    	 * 
    	 * La session no es por app web, la session es un object thread safe, no puede ser compartida en multiple threads.
    	 * Entonces dicho lo anterior, siempre debes usar una session por request o una session por transaccion, de esto se encargara
    	 * sessionFactory.getCurrentSession()
    	 * 
    	 * getCurrentSession suele ser suficiente. openSession proporciona y facilita un mayor nivel de gesti�n de d�nde se 
    	 * almacena y gestiona la sesi�n. Sin duda es una opci�n avanzada, pero que realmente se ajusta a la necesidad de 
    	 * desarrolladores muy inteligentes que est�n haciendo algunas cosas ingeniosas con la sesi�n.
    	 */
    	return sessionFactory.getCurrentSession();
    	//return sessionFactory.openSession();
    }
    
    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
    	// El metodo get cuando no encuentra la entidad devolver� null 
        return (T) getSession().get(persistentClass, key);
    }
    
 
    public void persist(T entity) {
        getSession().persist(entity);
    }
 
    public void delete(T entity) {
        getSession().delete(entity);
    }
    
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }    
    
    @SuppressWarnings("unchecked")
	protected List<T> createEntityQuery(String restrictions){
        return (List<T>) getSession().createQuery(restrictions).list();
    }     
}
