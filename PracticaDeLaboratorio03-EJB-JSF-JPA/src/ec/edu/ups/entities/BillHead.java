package ec.edu.ups.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: BillHead
 *
 */
@Entity

public class BillHead implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hea_id")
	private int id;
	
	@Column(name = "hea_subtotal", nullable=false)
	private double subtotal;
	
	@Column(name = "hea_iva" , nullable = false)
    private int iva;
	
	@Column(name = "hea_date", nullable=false)
	private Date date;
	
	@Column(name = "hea_status", nullable=false, columnDefinition = "VARCHAR(10) DEFAULT 'Activo'")
	private char status;
	
	@Column(name = "hea_total", precision = 12, scale = 2, nullable=false)
	private double total;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "head_detail")
    private List<BillDetail> headDetails= new ArrayList<BillDetail>();
	
	@ManyToOne 
    @JoinColumn(name="fk_billhead_user")
    private User user_head;
	
	@ManyToOne 
    @JoinColumn(name="fk_billhead_client")
    private Client client_head;
	
	public BillHead() {
		super();
	}

	public BillHead(double subtotal, int iva, Date date, char status, double total, User user_head,
			Client client_head) {
		super();
		this.subtotal = subtotal;
		this.iva = iva;
		this.date = date;
		this.status = status;
		this.total = total;
		this.user_head = user_head;
		this.client_head = client_head;
	}

	public BillHead(double subtotal, int iva, Date date, char status, double total) {
		super();
		this.subtotal = subtotal;
		this.iva = iva;
		this.date = date;
		this.status = status;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<BillDetail> getHeadDetails() {
		return headDetails;
	}

	public void setHeadDetails(List<BillDetail> headDetails) {
		this.headDetails = headDetails;
	}
	
	public void addHeadDetails(BillDetail headDetails) {
		this.headDetails.add(headDetails);
	}

	public User getUser_head() {
		return user_head;
	}

	public void setUser_head(User user_head) {
		this.user_head = user_head;
	}

	public Client getClient_head() {
		return client_head;
	}

	public void setClient_head(Client client_head) {
		this.client_head = client_head;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client_head == null) ? 0 : client_head.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((headDetails == null) ? 0 : headDetails.hashCode());
		result = prime * result + id;
		result = prime * result + iva;
		result = prime * result + status;
		long temp;
		temp = Double.doubleToLongBits(subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user_head == null) ? 0 : user_head.hashCode());
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
		BillHead other = (BillHead) obj;
		if (client_head == null) {
			if (other.client_head != null)
				return false;
		} else if (!client_head.equals(other.client_head))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (headDetails == null) {
			if (other.headDetails != null)
				return false;
		} else if (!headDetails.equals(other.headDetails))
			return false;
		if (id != other.id)
			return false;
		if (iva != other.iva)
			return false;
		if (status != other.status)
			return false;
		if (Double.doubleToLongBits(subtotal) != Double.doubleToLongBits(other.subtotal))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		if (user_head == null) {
			if (other.user_head != null)
				return false;
		} else if (!user_head.equals(other.user_head))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BillHead [id=" + id + ", subtotal=" + subtotal + ", iva=" + iva + ", date=" + date + ", status="
				+ status + ", total=" + total + ", headDetails=" + headDetails + ", user_head=" + user_head
				+ ", client_head=" + client_head + "]";
	}
   
	
	
	
}
