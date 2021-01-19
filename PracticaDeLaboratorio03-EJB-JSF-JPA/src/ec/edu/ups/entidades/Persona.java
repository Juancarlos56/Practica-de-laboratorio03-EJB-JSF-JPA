package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Persona implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private String cedula;
    private String direccion;
    private String telefono;
    private String correo;
    private String password;
    private char rol;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<FacturaCabecera> facturasCab= new ArrayList<FacturaCabecera>();

    
    public Persona(int id, String nombre, String apellido, String cedula,String direccion, String telefono, String correo, String password, char rol) {
    	this.setId(id);
    	this.setNombre(nombre);
    	this.setApellido(apellido);
    	this.setCedula(cedula);
    	this.setDireccion(direccion);
    	this.setTelefono(telefono);
    	this.setCorreo(correo);
    	this.setPassword(password);
    	this.setRol(rol);
    }
    
    

	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public Persona() {
		super();
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public char getRol() {
		return rol;
	}



	public void setRol(char rol) {
		this.rol = rol;
	}



	public List<FacturaCabecera> getFacturasCab() {
		return facturasCab;
	}



	public void setFacturasCab(List<FacturaCabecera> facturasCab) {
		this.facturasCab = facturasCab;
	}
	
	public void addFacturasCab(FacturaCabecera facturasCab) {
		this.facturasCab.add(facturasCab);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		    return true;
		if (obj == null)
		    return false;
		if (getClass() != obj.getClass())
		    return false;
		Persona other = (Persona) obj;
		if (id != other.id)
		    return false;
		return true;
	}
   
}
