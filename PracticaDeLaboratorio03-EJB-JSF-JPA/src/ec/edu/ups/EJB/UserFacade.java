package ec.edu.ups.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.Client;
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
	
	
	@SuppressWarnings("unchecked")
	public User buscarUsuario(String usuario, String password) {
		User user = new User();
		String consulta = "SELECT  u FROM User u WHERE u.email=:email AND u.password=:password";
		try {
			//em.clear();
			user = (User) em.createQuery(consulta).setParameter("email", usuario).setParameter("password", password).getSingleResult();
			//em.refresh(prod);
		} catch (Exception e) {
			System.out.println(">>>WARNING2222 (buscarClienteCedula ): " + e.getMessage());
		}
		
		return user;
	}
	
}
