package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.Date;
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
 * Entity implementation class for Entity: FacturaCabecera
 *
 */
@Entity

public class FacturaCabecera implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date fecha;
	private float subtotal;
	private float total;
	private float iva;
	private char estado;
	
	@ManyToOne
	@JoinColumn
	private Persona persona;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaCabecera")
	private List<FacturaDetalle> facturasDetalle;
	
	public FacturaCabecera(int id, Date fecha, float subtotal, float total, float iva, char estado, Persona persona) {
		this.setId(id);
		this.setFecha(fecha);
		this.setSubtotal(subtotal);
		this.setTotal(total);
		this.setSubtotal(subtotal);
		this.setTotal(total);
		this.setIva(iva);
		this.setEstado(estado);
		this.setPersona(persona);
	}
	
	public FacturaCabecera() {
		super();
	}
	
	
	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public Date getFecha() {
		return fecha;
	}





	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}





	public float getSubtotal() {
		return subtotal;
	}





	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}





	public float getTotal() {
		return total;
	}





	public void setTotal(float total) {
		this.total = total;
	}





	public float getIva() {
		return iva;
	}





	public void setIva(float iva) {
		this.iva = iva;
	}





	public char getEstado() {
		return estado;
	}





	public void setEstado(char estado) {
		this.estado = estado;
	}





	public Persona getPersona() {
		return persona;
	}





	public void setPersona(Persona persona) {
		this.persona = persona;
	}





	public List<FacturaDetalle> getFacturasDetalle() {
		return facturasDetalle;
	}





	public void setFacturasDetalle(List<FacturaDetalle> facturasDetalle) {
		this.facturasDetalle = facturasDetalle;
	}
	
	public void addFacturasDetalle(FacturaDetalle facturasDetalle) {
		this.facturasDetalle.add(facturasDetalle);
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
		FacturaCabecera other = (FacturaCabecera) obj;
		if (id != other.id)
		    return false;
		return true;
	}
   
}
