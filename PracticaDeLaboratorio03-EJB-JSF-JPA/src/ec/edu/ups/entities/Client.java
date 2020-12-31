package ec.edu.ups.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cli_id")
    private int cod_cli;
	
	@Column(name="cli_email", length=255, nullable=false, unique=true)
    private String email;
	
	@Column(name="cli_dni", length=10, nullable=false, unique=true)
    private String dni;
	
	@Column(name="cli_name", length=255, nullable=false)
    private String name;
	
	@Column(name="cli_lastname", length=255, nullable=false)
    private String lastname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client_head")
    private List<BillHead> billsClient = new ArrayList<BillHead>();
	
	public Client() {
		super();
	}

	public Client(int cod_cli, String email, String dni, String name, String lastname) {
		super();
		this.cod_cli = cod_cli;
		this.email = email;
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
	}

	public int getCod_cli() {
		return cod_cli;
	}

	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<BillHead> getBillsClient() {
		return billsClient;
	}

	public void setBillsClient(List<BillHead> billsClient) {
		this.billsClient = billsClient;
	}
	
	public void addBillsClient(BillHead billClient) {
		this.billsClient.add(billClient);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billsClient == null) ? 0 : billsClient.hashCode());
		result = prime * result + cod_cli;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Client other = (Client) obj;
		if (billsClient == null) {
			if (other.billsClient != null)
				return false;
		} else if (!billsClient.equals(other.billsClient))
			return false;
		if (cod_cli != other.cod_cli)
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [cod_cli=" + cod_cli + ", email=" + email + ", dni=" + dni + ", name=" + name + ", lastname="
				+ lastname + ", billsClient=" + billsClient + "]";
	}
	
	
   
}
