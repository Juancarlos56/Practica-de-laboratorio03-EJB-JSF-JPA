package ec.edu.ups.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Company
 *
 */
@Entity

public class Company implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="com_id")
    private int cod_com;
	
	@Column(name="com_name", length=255, nullable=false, unique=true)
	private String nombre;
	@Column(name="com_url", length=255, nullable=false, unique=false)
	private String url;
	@Column(name="com_description", length=255, nullable=false, unique=false)
    private String description;
	@Column(name="com_address", length=255, nullable=false, unique=false)
    private String address;
    
	
	public Company() {
		super();
	}


	public Company(String nombre, String url, String description, String address) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.description = description;
		this.address = address;
	}


	public int getCod_com() {
		return cod_com;
	}


	public void setCod_com(int cod_com) {
		this.cod_com = cod_com;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + cod_com;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Company other = (Company) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cod_com != other.cod_com)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Company [cod_com=" + cod_com + ", nombre=" + nombre + ", url=" + url + ", description=" + description
				+ ", address=" + address + "]";
	}
	
	
	
   
}
