package ec.edu.ups.EJB;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.FacturaCabecera;
import ec.edu.ups.entidades.Persona;

@Stateless
public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera> {

    @PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
    private EntityManager em;

    public FacturaCabeceraFacade() {
        super(FacturaCabecera.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<FacturaCabecera> facturasCabeceraReves(){
    	List<FacturaCabecera> cabeceras=new ArrayList<FacturaCabecera>();
    	String consulta = "Select fC From FacturaCabecera fC  where fc.estado='A' order by fc.id desc";
    	try {
    		cabeceras = em.createQuery(consulta).getResultList();
    	}catch(Exception e) {
    		System.out.println(">>>Warning (PersonaFacade:buscarPorCedula: )"+e.getMessage());
    	}
    	return cabeceras;
    }
    
    public List<FacturaCabecera> facturasCabeceraFiltrada(String cedula){
    	List<FacturaCabecera> cabeceras=new ArrayList<FacturaCabecera>();
    	String consulta = "Select fC From FacturaCabecera fC where fc.estado='A' and fc.persona.cedula='"+cedula+"' order by fc.id desc";
    	try {
    		cabeceras = em.createQuery(consulta).getResultList();
    	}catch(Exception e) {
    		System.out.println(">>>Warning (FacturaCabeceraFacade:facturasCabeceraFiltrada: )"+e.getMessage());
    	}
    	return cabeceras;
    }
    
}

