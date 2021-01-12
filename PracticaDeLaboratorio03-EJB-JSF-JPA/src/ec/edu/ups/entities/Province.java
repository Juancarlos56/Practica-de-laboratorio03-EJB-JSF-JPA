package ec.edu.ups.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Province
 *
 */
@Entity

public class Province implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pro_id")
    private int codProvince;
	
	@Column(name="cou_name", length=255, nullable=false, unique=true)
	private String ProvinceName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "province_city")
    private List<City> citys= new ArrayList<City>();
	
	
	public Province() {
		super();
	}

	public Province(String provinceName) {
		super();
		ProvinceName = provinceName;
	}

	public int getCodProvince() {
		return codProvince;
	}

	public void setCodProvince(int codProvince) {
		this.codProvince = codProvince;
	}

	public String getProvinceName() {
		return ProvinceName;
	}

	public void setProvinceName(String provinceName) {
		ProvinceName = provinceName;
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
		result = prime * result + ((ProvinceName == null) ? 0 : ProvinceName.hashCode());
		result = prime * result + ((citys == null) ? 0 : citys.hashCode());
		result = prime * result + codProvince;
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
		Province other = (Province) obj;
		if (ProvinceName == null) {
			if (other.ProvinceName != null)
				return false;
		} else if (!ProvinceName.equals(other.ProvinceName))
			return false;
		if (citys == null) {
			if (other.citys != null)
				return false;
		} else if (!citys.equals(other.citys))
			return false;
		if (codProvince != other.codProvince)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Province [codProvince=" + codProvince + ", ProvinceName=" + ProvinceName + ", citys=" + citys + "]";
	}


	
   
	
}
