package ec.edu.ups.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.User;

/**
 * Session Bean implementation class UserFacade
 */
@Stateless
public class UserFacade extends AbstractFacade<User>{

	@PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
    private EntityManager em;
	
	public UserFacade() {
		super(User.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
