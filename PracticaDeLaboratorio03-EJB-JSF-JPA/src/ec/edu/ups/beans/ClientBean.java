package ec.edu.ups.beans;

import java.io.Serializable;




import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ec.edu.ups.EJB.ClientFacade;
import ec.edu.ups.entities.Client;
import ec.edu.ups.entities.User;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ClientBean implements Serializable{

	private static final long serialVersionUID = -8280135126172101061L;
	//private String nombreCliente;
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private String estado;
	private Client cliente;
	
	@EJB
	private ClientFacade ejbCliente;
	
	public ClientBean() {
        // TODO Auto-generated constructor stub
    }

	public void buscarClienteCedula() {
		
		System.out.println("cedula"+getCedula());
		cliente = ejbCliente.buscarClienteCedula(getCedula());
		System.out.println("Cliente:>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+cliente.getDni());
		this.setCedula(cliente.getDni());
		this.setNombre(cliente.getName()); 
		this.setApellido(cliente.getLastname());
		this.setEmail(cliente.getEmail());
		this.setEstado(cliente.getState());    
	}
	
	
	public void crearNuevoCliente() {

		Client clt = new Client();
		clt.setDni(getCedula());
		clt.setEmail(getEmail());
		clt.setLastname(getApellido());
		clt.setName(getNombre());
		
		try {
			ejbCliente.create(clt);
			addMessage("Cliente creado!!");
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("No se pudo crear el cliente!!");
		}
		
	}
	
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	
	 public void cargarDatosEditarCliente(String dni) {
		 Client clt = ejbCliente.buscarClienteCedula(dni);
		 System.out.println("Datos>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+cliente.getDni());
		 cedula = clt.getDni();
		 nombre = clt.getName(); 
		 apellido = clt.getLastname();
		 email = clt.getEmail();
		 estado = clt.getState();    	
	}
	
	 
	public void eliminarCliente(Client cli) {
		Client clt2 = ejbCliente.buscarClienteCedula(cli.getDni());
		System.out.println(clt2.getCod_cli());
		ejbCliente.remove(clt2);
	}
	
	
	public void editarCliente() {
    	System.out.println("cedula:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+cedula);
    	if(nombre!=null && nombre.equals("")!=true) {
    		Client persona = ejbCliente.buscarClienteCedula(cedula);
    		persona.setName(nombre);
    		persona.setLastname(apellido);
    		persona.setState(estado);
    		persona.setEmail(email);
        	
    		try {
    			ejbCliente.edit(persona);
    			addMessage("El Cliente a sido editado!!");
    			nombre="";
            	apellido="";
            	estado="";
            	cedula="";
            	email="";
    		} catch (Exception e) {
    			e.printStackTrace();
    			addMessage("No se pudo editar al cliente!!");
    		}
       	} 	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Client getCliente() {
		return cliente = ejbCliente.buscarClienteCedula(getCedula());
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}


	public ClientFacade getEjbCliente() {
		return ejbCliente;
	}

	public void setEjbCliente(ClientFacade ejbCliente) {
		this.ejbCliente = ejbCliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
