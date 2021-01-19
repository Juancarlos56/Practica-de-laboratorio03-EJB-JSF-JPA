package ec.edu.ups.EJB;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;

@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
    private EntityManager em;

    public PersonaFacade() {
        super(Persona.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Persona buscarPorCedula (String cedula) {
    	Persona persona=null;
    	String consulta = "Select per From Persona per Where per.cedula=:cedula";
    	try {
    		persona= (Persona) em.createQuery(consulta).setParameter("cedula", cedula).getSingleResult();
    	}catch(Exception e) {
    		System.out.println(">>>Warning (PersonaFacade:buscarPorCedula: )"+e.getMessage());
    	}
    	return persona;
    }
    
    
    public Persona inicioSesion (String correo, String password) {
    	Persona persona=null;
    	System.out.println("Intento Inicio");
    	
    	String consulta = "Select per From Persona per Where per.correo=:correo and per.password=:password";
    	try {
    		persona= (Persona) em.createQuery(consulta).setParameter("correo", correo).setParameter("password", password).getSingleResult();
    	}catch(Exception e) {
    		System.out.println(">>>Warning (PersonaFacade:buscarPorCedula: )"+e.getMessage());
    	}
    	return persona;
    }
    
    public List<Persona> listarClientes () {
    	List<Persona> persona=new ArrayList<Persona>();
    	String consulta = "Select per From Persona per Where per.rol='C'";
    	try {
    		persona= em.createQuery(consulta).getResultList();
    	}catch(Exception e) {
    		System.out.println(">>>Warning (PersonaFacade:buscarPorCedula: )"+e.getMessage());
    	}
    	return persona;
    }
    
}

