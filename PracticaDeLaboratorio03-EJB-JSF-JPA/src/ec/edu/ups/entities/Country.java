package ec.edu.ups.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pais
 *
 */
@Entity

public class Country implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cou_id")
    private int cod_cou;
	
	@Column(name="cou_name", length=255, nullable=false, unique=true)
	private String countryName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "country_city")
    private List<City> citys= new ArrayList<City>();
	
	
	public Country() {
		super();
	}


	public Country(int cod_cou, String countryName) {
		super();
		this.cod_cou = cod_cou;
		this.countryName = countryName;
	}


	public int getCod_cou() {
		return cod_cou;
	}


	public void setCod_cou(int cod_cou) {
		this.cod_cou = cod_cou;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public List<City> getCitys() {
		return citys;
	}


	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public void addCitys(City city) {
		this.citys.add(city);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citys == null) ? 0 : citys.hashCode());
		result = prime * result + cod_cou;
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
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
		Country other = (Country) obj;
		if (citys == null) {
			if (other.citys != null)
				return false;
		} else if (!citys.equals(other.citys))
			return false;
		if (cod_cou != other.cod_cou)
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Country [cod_cou=" + cod_cou + ", countryName=" + countryName + ", citys=" + citys + "]";
	}
   
	
}
