package ec.edu.ups.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usu_id")
    private int cod_usu;
	
	@Column(name="usu_email", length=255, nullable=false, unique=true)
    private String email;
	
	@Column(name="usu_password", length=255, nullable=false, unique=false)
    private String password;
	
	@Column(name="usu_nombre", length=255, nullable=false)
    private String userName;
	
	@Column(name="usu_role", length=255, nullable=false)
    private String role;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user_head")
    private List<BillHead> billsUser= new ArrayList<BillHead>();
	
	
	public User() {
		super();
	}


	public User(int cod_usu, String email, String password, String userName, String role) {
		super();
		this.cod_usu = cod_usu;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.role = role;
	}


	public int getCod_usu() {
		return cod_usu;
	}


	public void setCod_usu(int cod_usu) {
		this.cod_usu = cod_usu;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public List<BillHead> getBillsUser() {
		return billsUser;
	}


	public void setBillsUser(List<BillHead> billsUser) {
		this.billsUser = billsUser;
	}

	public void addBillsUser(BillHead billUser) {
		this.billsUser.add(billUser);
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billsUser == null) ? 0 : billsUser.hashCode());
		result = prime * result + cod_usu;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (billsUser == null) {
			if (other.billsUser != null)
				return false;
		} else if (!billsUser.equals(other.billsUser))
			return false;
		if (cod_usu != other.cod_usu)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [cod_usu=" + cod_usu + ", email=" + email + ", password=" + password + ", userName=" + userName
				+ ", role=" + role + ", billsUser=" + billsUser + "]";
	}
	
	
	
	
   
}
