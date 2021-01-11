package ec.edu.ups.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: City
 *
 */
@Entity

public class City implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cit_id")
    private int cod_city;
	
	@Column(name="cit_name", length=255, nullable=false, unique=true)
	private String cityName;
	
	@Column(name="cit_postCode", length=255, nullable=false, unique=true)
	private String cityPostCode;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "city_warehouse")
    private List<Warehouse> warehouses= new ArrayList<Warehouse>();
	
	@ManyToOne 
    @JoinColumn(name="fk_city_country", insertable=false, updatable=false)
    private Country country_city;
	
	public City() {
		super();
	}

	public City(int cod_city, String cityName, String cityPostCode, Country country_city) {
		super();
		this.cod_city = cod_city;
		this.cityName = cityName;
		this.cityPostCode = cityPostCode;
		this.country_city = country_city;
	}

	public int getCod_city() {
		return cod_city;
	}

	public void setCod_city(int cod_city) {
		this.cod_city = cod_city;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityPostCode() {
		return cityPostCode;
	}

	public void setCityPostCode(String cityPostCode) {
		this.cityPostCode = cityPostCode;
	}

	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public void addWarehouses(Warehouse warehouse) {
		this.warehouses.add(warehouse);
	}
	
	public Country getCountry_city() {
		return country_city;
	}

	public void setCountry_city(Country country_city) {
		this.country_city = country_city;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result + ((cityPostCode == null) ? 0 : cityPostCode.hashCode());
		result = prime * result + cod_city;
		result = prime * result + ((country_city == null) ? 0 : country_city.hashCode());
		result = prime * result + ((warehouses == null) ? 0 : warehouses.hashCode());
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
		City other = (City) obj;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (cityPostCode == null) {
			if (other.cityPostCode != null)
				return false;
		} else if (!cityPostCode.equals(other.cityPostCode))
			return false;
		if (cod_city != other.cod_city)
			return false;
		if (country_city == null) {
			if (other.country_city != null)
				return false;
		} else if (!country_city.equals(other.country_city))
			return false;
		if (warehouses == null) {
			if (other.warehouses != null)
				return false;
		} else if (!warehouses.equals(other.warehouses))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [cod_city=" + cod_city + ", cityName=" + cityName + ", cityPostCode=" + cityPostCode
				+ ", warehouses=" + warehouses + ", country_city=" + country_city + "]";
	}
   
	
}
