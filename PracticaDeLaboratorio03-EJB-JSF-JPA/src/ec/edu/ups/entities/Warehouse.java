package ec.edu.ups.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Warehouse
 *
 */
@Entity

public class Warehouse implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "warehouse_id")
    private int cod_warehouse;
	
	@Column(name = "warehouse_name", length = 255, nullable = false)
    private String wareHouseName;
	
	@Column(name = "warehouse_description", length = 255, nullable = false)
    private String wareHouseDescription;
	
	@Column(name = "warehouse_state", length = 10, nullable = false)
    private String wareHouseState;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouse_ware_pro")
    private List<ProductWarehouse> warehousesProduct= new ArrayList<ProductWarehouse>();
	
	@ManyToOne 
    @JoinColumn(name="fk_warehouse_City")
    private City city_warehouse;
	
	public Warehouse() {
		super();
	}

	public Warehouse(String wareHouseName, String wareHouseDescription, String wareHouseState,
			City city_warehouse) {
		super();
		this.wareHouseName = wareHouseName;
		this.wareHouseDescription = wareHouseDescription;
		this.wareHouseState = wareHouseState;
		this.city_warehouse = city_warehouse;
	}

	public int getCod_warehouse() {
		return cod_warehouse;
	}

	public void setCod_warehouse(int cod_warehouse) {
		this.cod_warehouse = cod_warehouse;
	}

	public String getWareHouseName() {
		return wareHouseName;
	}

	public void setWareHouseName(String wareHouseName) {
		this.wareHouseName = wareHouseName;
	}

	public String getWareHouseDescription() {
		return wareHouseDescription;
	}

	public void setWareHouseDescription(String wareHouseDescription) {
		this.wareHouseDescription = wareHouseDescription;
	}

	public String getWareHouseState() {
		return wareHouseState;
	}

	public void setWareHouseState(String wareHouseState) {
		this.wareHouseState = wareHouseState;
	}

	public List<ProductWarehouse> getWarehousesProduct() {
		return warehousesProduct;
	}

	public void setWarehousesProduct(List<ProductWarehouse> warehousesProduct) {
		this.warehousesProduct = warehousesProduct;
	}
	
	public void addWarehousesProduct(ProductWarehouse warehouseProduct) {
		this.warehousesProduct.add(warehouseProduct);
	}

	public City getCity_warehouse() {
		return city_warehouse;
	}

	public void setCity_warehouse(City city_warehouse) {
		this.city_warehouse = city_warehouse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city_warehouse == null) ? 0 : city_warehouse.hashCode());
		result = prime * result + cod_warehouse;
		result = prime * result + ((wareHouseDescription == null) ? 0 : wareHouseDescription.hashCode());
		result = prime * result + ((wareHouseName == null) ? 0 : wareHouseName.hashCode());
		result = prime * result + ((wareHouseState == null) ? 0 : wareHouseState.hashCode());
		result = prime * result + ((warehousesProduct == null) ? 0 : warehousesProduct.hashCode());
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
		Warehouse other = (Warehouse) obj;
		if (city_warehouse == null) {
			if (other.city_warehouse != null)
				return false;
		} else if (!city_warehouse.equals(other.city_warehouse))
			return false;
		if (cod_warehouse != other.cod_warehouse)
			return false;
		if (wareHouseDescription == null) {
			if (other.wareHouseDescription != null)
				return false;
		} else if (!wareHouseDescription.equals(other.wareHouseDescription))
			return false;
		if (wareHouseName == null) {
			if (other.wareHouseName != null)
				return false;
		} else if (!wareHouseName.equals(other.wareHouseName))
			return false;
		if (wareHouseState == null) {
			if (other.wareHouseState != null)
				return false;
		} else if (!wareHouseState.equals(other.wareHouseState))
			return false;
		if (warehousesProduct == null) {
			if (other.warehousesProduct != null)
				return false;
		} else if (!warehousesProduct.equals(other.warehousesProduct))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Warehouse [cod_warehouse=" + cod_warehouse + ", wareHouseName=" + wareHouseName
				+ ", wareHouseDescription=" + wareHouseDescription + ", wareHouseState=" + wareHouseState
				+ ", warehousesProduct=" + warehousesProduct + ", city_warehouse=" + city_warehouse + "]";
	}
	
	
   
}
