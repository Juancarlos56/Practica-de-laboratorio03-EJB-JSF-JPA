package ec.edu.ups.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.BillHead;

/**
 * Session Bean implementation class BillHeadFacade
 */
@Stateless
public class BillHeadFacade extends AbstractFacade<BillHead> {

	@PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
	private EntityManager em;
	
    public BillHeadFacade() {
    	super(BillHead.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
