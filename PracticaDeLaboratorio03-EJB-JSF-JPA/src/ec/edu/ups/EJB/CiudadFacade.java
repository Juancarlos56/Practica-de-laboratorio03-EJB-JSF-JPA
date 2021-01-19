package ec.edu.ups.EJB;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Ciudad;

@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

    @PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
    private EntityManager em;

    public CiudadFacade() {
        super(Ciudad.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

