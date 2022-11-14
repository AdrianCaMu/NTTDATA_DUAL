package nttdata.hibernate.persistence.dao.implementations;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;

import nttdata.hibernate.persistence.dao.interfaces.CommonDaoI;
import nttdata.hibernate.persistence.entities.AbstractEntity;

/**
 * Common Dao Implementation
 * 
 * @author Adrian Camara Munoz
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesi�n de conexi�n a BD */
	private Session session;

	/**
	 * M�todo constructor.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(final T paramT) {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercci�n.
		session.save(paramT);
		session.flush();

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void update(final T paramT) {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercci�n.
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void delete(final T paramT) {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercci�n.
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public T searchById(final Long id) {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// B�squeda por PK.
		return session.get(this.entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// B�squeda de todos los registros.
		return session.createQuery("FROM " + this.entityClass.getName()).list();

	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
