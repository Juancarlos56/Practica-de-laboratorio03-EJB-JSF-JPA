package ec.edu.ups.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.Client;
import ec.edu.ups.entities.ProductWarehouse;

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
    
    @SuppressWarnings("unchecked")
	public Client buscarClienteCedula(String cedula) {
    	Client prod = new Client();
		String consulta = "SELECT  c FROM Client c WHERE c.dni =:cedula";
		try {
			em.clear();
			prod = (Client) em.createQuery(consulta).setParameter("cedula", cedula).getSingleResult();
			//em.refresh(prod);
		} catch (Exception e) {
			System.out.println(">>>WARNING2222 (buscarClienteCedula ): " + e.getMessage());
		}
		
		return prod;
    }

}
