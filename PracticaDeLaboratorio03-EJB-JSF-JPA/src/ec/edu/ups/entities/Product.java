package ec.edu.ups.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity

public class Product implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
    private int cod_pro;
	
	@Column(name = "pro_name", length = 255, nullable = false)
    private String productName;
	
	@Column(name = "pro_price", precision = 12, scale = 2, nullable = false)
    private Double productPrice;
	
	@Column(name = "pro_url_image", length = 255, nullable = false)
    private String productUrl;
	
	@Column(name = "pro_description", length = 255, nullable = false)
    private String proDescription;
	
	@Column(name = "pro_state", length = 10, nullable = false)
    private String productState;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product_ware_pro")
    private List<ProductWarehouse> productsWarehouse= new ArrayList<ProductWarehouse>();
	
	@ManyToOne 
    @JoinColumn(name="fk_product_category")
    private Category category_product;
	
	public Product() {
		super();
	}

	public Product(String productName, Double productPrice, String productUrl, String proDescription,
			String productState, Category category_product) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productUrl = productUrl;
		this.proDescription = proDescription;
		this.productState = productState;
		this.category_product = category_product;
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

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getProDescription() {
		return proDescription;
	}

	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public List<ProductWarehouse> getProductsWarehouse() {
		return productsWarehouse;
	}

	public void setProductsWarehouse(List<ProductWarehouse> productsWarehouse) {
		this.productsWarehouse = productsWarehouse;
	}
	
	public void addProductsWarehouse(ProductWarehouse productWarehouse) {
		this.productsWarehouse.add(productWarehouse);
	}

	public Category getCategory_product() {
		return category_product;
	}

	public void setCategory_product(Category category_product) {
		this.category_product = category_product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category_product == null) ? 0 : category_product.hashCode());
		result = prime * result + cod_pro;
		result = prime * result + ((proDescription == null) ? 0 : proDescription.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
		result = prime * result + ((productState == null) ? 0 : productState.hashCode());
		result = prime * result + ((productUrl == null) ? 0 : productUrl.hashCode());
		result = prime * result + ((productsWarehouse == null) ? 0 : productsWarehouse.hashCode());
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
		Product other = (Product) obj;
		if (category_product == null) {
			if (other.category_product != null)
				return false;
		} else if (!category_product.equals(other.category_product))
			return false;
		if (cod_pro != other.cod_pro)
			return false;
		if (proDescription == null) {
			if (other.proDescription != null)
				return false;
		} else if (!proDescription.equals(other.proDescription))
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
		if (productState == null) {
			if (other.productState != null)
				return false;
		} else if (!productState.equals(other.productState))
			return false;
		if (productUrl == null) {
			if (other.productUrl != null)
				return false;
		} else if (!productUrl.equals(other.productUrl))
			return false;
		if (productsWarehouse == null) {
			if (other.productsWarehouse != null)
				return false;
		} else if (!productsWarehouse.equals(other.productsWarehouse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [cod_pro=" + cod_pro + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productUrl=" + productUrl + ", proDescription=" + proDescription + ", productState=" + productState
				+ ", productsWarehouse=" + productsWarehouse + ", category_product=" + category_product + "]";
	}
   
	
	
}
