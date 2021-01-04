package ec.edu.ups.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.BillDetail;

/**
 * Session Bean implementation class BillDetailFacade
 */
@Stateless
public class BillDetailFacade extends AbstractFacade<BillDetail>{

	 @PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
	 private EntityManager em;
	 
    /**
     * Default constructor. 
     */
    public BillDetailFacade() {
    	super(BillDetail.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
