package ec.edu.ups.EJB;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Categoria;

@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
    private EntityManager em;

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

