package ec.edu.ups.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.EJB.ClientFacade;
import ec.edu.ups.entities.Client;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ClientBean implements Serializable{

	private static final long serialVersionUID = -8280135126172101061L;
	private String nombreCliente;
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	
	private Client cliente;
	
	@EJB
	private ClientFacade ejbCliente;
	
	public ClientBean() {
        // TODO Auto-generated constructor stub
    }

	public void buscarClienteCedula() {
		System.out.println("cedula"+getCedula());
		cliente = ejbCliente.buscarClienteCedula(getCedula());
		setApellido(cliente.getLastname());
		setEmail(cliente.getEmail());
		setNombre(cliente.getName());
		setCedula(cliente.getDni());
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

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public ClientFacade getEjbCliente() {
		return ejbCliente;
	}

	public void setEjbCliente(ClientFacade ejbCliente) {
		this.ejbCliente = ejbCliente;
	}
	
	
	
	
	
}
