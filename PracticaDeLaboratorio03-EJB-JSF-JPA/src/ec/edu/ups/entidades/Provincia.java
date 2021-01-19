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
 * Entity implementation class for Entity: Provincia
 *
 */
@Entity

public class Provincia implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia")
	private List<Ciudad> ciudades = new ArrayList<Ciudad>();
	
	public Provincia(int id, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
	}
		
	public Provincia() {
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



	public List<Ciudad> getCiudades() {
		return ciudades;
	}



	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	
	public void addCiudades(Ciudad ciudades) {
		this.ciudades.add(ciudades);
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
		Provincia other = (Provincia) obj;
		if (id != other.id)
		    return false;
		return true;
	}
   
}
