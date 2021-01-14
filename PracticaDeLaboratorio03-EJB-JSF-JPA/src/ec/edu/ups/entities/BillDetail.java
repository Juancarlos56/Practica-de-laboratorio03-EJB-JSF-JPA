package ec.edu.ups.entities;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: BillDetail
 *
 */
@Entity

public class BillDetail implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="det_id")
    private int cod_det;
	
	@Column(name="det_subtotal",  precision = 12, scale = 2, nullable = false)
    private double subtotal;
	
	@Column(name="det_amount", nullable = false)
    private int amount;
	
	@Column(name = "det_unit_price", precision = 10, scale = 2, nullable = false)
	private double unitPrice;
	
	@Column(name = "det_state", columnDefinition = "VARCHAR(10) DEFAULT 'Activo'")
	private String state;
	
	@ManyToOne 
    @JoinColumn(name="fk_productowarehouse_billdetail")
    private ProductWarehouse pro_war_detail;
	
	@ManyToOne 
    @JoinColumn(name="fk_billhead_billdetail")
    private BillHead head_detail;
	
	
	public BillDetail() {
		super();
	}


	public BillDetail(double subtotal, int amount, double unitPrice, String state,
			ProductWarehouse pro_war_detail, BillHead head_detail) {
		super();
		this.subtotal = subtotal;
		this.amount = amount;
		this.unitPrice = unitPrice;
		this.state = state;
		this.pro_war_detail = pro_war_detail;
		this.head_detail = head_detail;
	}


	public BillDetail(int amount, double unitPrice, String state) {
		super();
		this.amount = amount;
		this.unitPrice = unitPrice;
		this.state = state;
	}
	
	
	public double calcularSubtotal() {
		return roundTwoDecimals(getAmount()*getUnitPrice());
	}
	
	double roundTwoDecimals(double d) { 
        DecimalFormat twoDForm = new DecimalFormat("#.##"); 
        return Double.valueOf(twoDForm.format(d));
	}
	


	public int getCod_det() {
		return cod_det;
	}


	public void setCod_det(int cod_det) {
		this.cod_det = cod_det;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public String isState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public ProductWarehouse getPro_war_detail() {
		return pro_war_detail;
	}


	public void setPro_war_detail(ProductWarehouse pro_war_detail) {
		this.pro_war_detail = pro_war_detail;
	}


	public BillHead getHead_detail() {
		return head_detail;
	}


	public void setHead_detail(BillHead head_detail) {
		this.head_detail = head_detail;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + cod_det;
		result = prime * result + ((head_detail == null) ? 0 : head_detail.hashCode());
		result = prime * result + ((pro_war_detail == null) ? 0 : pro_war_detail.hashCode());
		long temp;
		temp = Double.doubleToLongBits(unitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BillDetail other = (BillDetail) obj;
		if (amount != other.amount)
			return false;
		if (cod_det != other.cod_det)
			return false;
		if (head_detail == null) {
			if (other.head_detail != null)
				return false;
		} else if (!head_detail.equals(other.head_detail))
			return false;
		if (pro_war_detail == null) {
			if (other.pro_war_detail != null)
				return false;
		} else if (!pro_war_detail.equals(other.pro_war_detail))
			return false;
		if (state != other.state)
			return false;
		if (subtotal != other.subtotal)
			return false;
		if (Double.doubleToLongBits(unitPrice) != Double.doubleToLongBits(other.unitPrice))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "BillDetail [cod_det=" + cod_det + ", subtotal=" + subtotal + ", amount=" + amount + ", unitPrice="
				+ unitPrice + ", state=" + state + ", pro_war_detail=" + pro_war_detail + ", head_detail=" + head_detail
				+ "]";
	}
	
	
	
   
}
