package ec.edu.ups.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.Client;

/**
 * Session Bean implementation class ClientFacade
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client>{

    @PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
    private EntityManager em;
	
    public ClientFacade() {
    	super(Client.class);
    }
	
    @Override
	protected EntityManager getEntityManager() {
		return em;
	}
    
    

}
