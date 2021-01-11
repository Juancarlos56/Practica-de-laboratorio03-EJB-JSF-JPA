package ec.edu.ups.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProductoWarehouse
 *
 */
@Entity

public class ProductWarehouse implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_ware_id")
    private int cod_pro;
	
	@Column(name = "pro_ware_state", length = 10, nullable = false)
    private String productName;
	
	@Column(name = "pro_ware_stock", nullable = false)
    private Double productPrice;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pro_war_detail")
    private List<BillDetail> details= new ArrayList<BillDetail>();
	
	@ManyToOne 
    @JoinColumn(name="fk_productwarehouse_warehouse", insertable=false, updatable=false)
    private Warehouse warehouse_ware_pro;
	
	@ManyToOne 
    @JoinColumn(name="fk_productwarehouse_product", insertable=false, updatable=false)
    private Product product_ware_pro;
	
	public ProductWarehouse() {
		super();
	}

	public ProductWarehouse(int cod_pro, String productName, Double productPrice, Warehouse warehouse_ware_pro,
			Product product_ware_pro) {
		super();
		this.cod_pro = cod_pro;
		this.productName = productName;
		this.productPrice = productPrice;
		this.warehouse_ware_pro = warehouse_ware_pro;
		this.product_ware_pro = product_ware_pro;
	}

	public int getCod_pro() {
		return cod_pro;
	}

	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public List<BillDetail> getDetails() {
		return details;
	}

	public void setDetails(List<BillDetail> details) {
		this.details = details;
	}
	
	public void addDetails(BillDetail detail) {
		this.details.add(detail);
	}

	public Warehouse getWarehouse_ware_pro() {
		return warehouse_ware_pro;
	}

	public void setWarehouse_ware_pro(Warehouse warehouse_ware_pro) {
		this.warehouse_ware_pro = warehouse_ware_pro;
	}

	public Product getProduct_ware_pro() {
		return product_ware_pro;
	}

	public void setProduct_ware_pro(Product product_ware_pro) {
		this.product_ware_pro = product_ware_pro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_pro;
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
		result = prime * result + ((product_ware_pro == null) ? 0 : product_ware_pro.hashCode());
		result = prime * result + ((warehouse_ware_pro == null) ? 0 : warehouse_ware_pro.hashCode());
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
		ProductWarehouse other = (ProductWarehouse) obj;
		if (cod_pro != other.cod_pro)
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice == null) {
			if (other.productPrice != null)
				return false;
		} else if (!productPrice.equals(other.productPrice))
			return false;
		if (product_ware_pro == null) {
			if (other.product_ware_pro != null)
				return false;
		} else if (!product_ware_pro.equals(other.product_ware_pro))
			return false;
		if (warehouse_ware_pro == null) {
			if (other.warehouse_ware_pro != null)
				return false;
		} else if (!warehouse_ware_pro.equals(other.warehouse_ware_pro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductWarehouse [cod_pro=" + cod_pro + ", productName=" + productName + ", productPrice="
				+ productPrice + ", details=" + details + ", warehouse_ware_pro=" + warehouse_ware_pro
				+ ", product_ware_pro=" + product_ware_pro + "]";
	}
	
	
   
}
