package ec.edu.ups.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.edu.ups.entities.Warehouse;

/**
 * Session Bean implementation class WarehouseFacade
 */
@Stateless
public class WarehouseFacade extends AbstractFacade<Warehouse>{

    
    @PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
    private EntityManager em;
	
    public WarehouseFacade() {
    	super(Warehouse.class);
    }

	protected EntityManager getEntityManager() {
		return em;
	}

	public Warehouse findWarehouseByName(String nombre){
        System.out.println("Bodega buscada"+nombre);
        CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
        CriteriaQuery<Warehouse> criteriaQuery= criteriaBuilder.createQuery(Warehouse.class);
        Root<Warehouse> categoriaRoot= criteriaQuery.from(Warehouse.class);
        Predicate predicate= criteriaBuilder.equal(categoriaRoot.get("wareHouseName"),nombre);
        criteriaQuery.select(categoriaRoot).where(predicate);

        return em.createQuery(criteriaQuery).getSingleResult();
    }


}
