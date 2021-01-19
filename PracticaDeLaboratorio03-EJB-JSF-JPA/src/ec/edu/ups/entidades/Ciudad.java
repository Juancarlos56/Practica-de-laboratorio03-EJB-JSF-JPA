package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Ciudad
 *
 */
@Entity

public class Ciudad implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nombre;
	
	@ManyToOne
	@JoinColumn
	private Provincia provincia;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
	private List<Bodega> bodegas = new ArrayList<Bodega>();
	
	public Ciudad(int id, String nombre, Provincia provincia) {
		this.setId(id);
		this.setNombre(nombre);
		this.setProvincia(provincia);
	}

	public Ciudad() {
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

	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Bodega> getBodegas() {
		return bodegas;
	}
	
	public void setBodegas(List<Bodega> bodegas) {
		this.bodegas = bodegas;
	}

	public void addBodegas(Bodega bodegas) {
		this.bodegas.add(bodegas);
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
		Ciudad other = (Ciudad) obj;
		if (id != other.id)
		    return false;
		return true;
	}
   
}
