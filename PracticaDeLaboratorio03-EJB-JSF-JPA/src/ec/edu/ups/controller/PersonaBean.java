package ec.edu.ups.controller;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ec.edu.ups.EJB.PersonaFacade;
import ec.edu.ups.entidades.FacturaCabecera;
import ec.edu.ups.entidades.Persona;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class PersonaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PersonaFacade ejbPersonaFacade;
	
	public static Persona persona;
	
	public static List<Persona> personas;
	
	private String nombre;
	private String apellido;
    private String direccion;
    private String telefono;
    private String cedula;
    private String correo;
    private String password;
    
    public void buscarPersonaCedula() {
    	persona = ejbPersonaFacade.buscarPorCedula(this.getCedula());
    	this.setNombre(persona.getNombre());
    	this.setApellido(persona.getApellido());
    	this.setDireccion(persona.getDireccion());
    	this.setTelefono(persona.getTelefono());
    	this.setCorreo(persona.getCorreo());
    }
    
    public void agregarPersona() {
    	if(nombre!=null && nombre.equals("")!=true) {
    		Persona persona2= new Persona(0, nombre, apellido, cedula, direccion, telefono, correo, password, 'C');
        	ejbPersonaFacade.create(persona2);
        	nombre="";
        	apellido="";
        	direccion="";
        	telefono="";
        	cedula="";
        	correo="";
    	}
    		
    }
    
    @PostConstruct
    public void init() {
    	personas=ejbPersonaFacade.listarClientes();
    }
    
    public void cargarDatosEditarPersona(Persona persona) {
    	nombre=persona.getNombre();
    	apellido=persona.getApellido();
    	direccion=persona.getDireccion();
    	telefono=persona.getTelefono();
    	cedula=persona.getCedula();
    	correo=persona.getCorreo();    	
    }
    
    public void filtrarDatos() {
    	personas=new ArrayList<Persona>();
    	Persona per=ejbPersonaFacade.buscarPorCedula(cedula);
    	personas.add(per);
    	if(per==null ) {
    		personas=ejbPersonaFacade.listarClientes();
		}
    }
    
    public void editarPersona() {
    	System.out.println("siquiera llega "+cedula);
    	if(nombre!=null && nombre.equals("")!=true) {
    		Persona persona = ejbPersonaFacade.buscarPorCedula(cedula);
    		persona.setNombre(nombre);
    		persona.setApellido(apellido);
    		persona.setDireccion(direccion);
    		persona.setTelefono(telefono);
    		persona.setCorreo(correo);
    		System.out.println(persona.getId());
        	ejbPersonaFacade.edit(persona);
        	nombre="";
        	apellido="";
        	direccion="";
        	telefono="";
        	cedula="";
        	correo="";
        	personas=ejbPersonaFacade.listarClientes();
    	} 	
    }
    
    public void eliminarUsuario(Persona persona) {
    	Persona persona2 = ejbPersonaFacade.buscarPorCedula(persona.getCedula());
    	System.out.println(persona2.getId());
    	ejbPersonaFacade.remove(persona2);
    	personas=ejbPersonaFacade.listarClientes();
    }
    

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public static Persona getPersona() {
		return persona;
	}




	public static void setPersona(Persona persona) {
		PersonaBean.persona = persona;
	}




	public PersonaFacade getEjbPersonaFacade() {
		return ejbPersonaFacade;
	}
	public void setEjbPersonaFacade(PersonaFacade ejbPersonaFacade) {
		this.ejbPersonaFacade = ejbPersonaFacade;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
    
    
}
