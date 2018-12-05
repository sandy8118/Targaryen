package com.scp.java.HbOperations;
import java.lang.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name="Customer")
public class Customer{
	@Id
	private int cust_Id;
	private String cust_Name;
	private String cust_address;
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="CustomersAndVendors",
	           joinColumns={@JoinColumn(name="Customer_Id")},
	           inverseJoinColumns={@JoinColumn(name="Vendor_Id")}
	          )
	//for ManyToMAnyrelationship--> joinColumn is Relation owning side
	private List<Vendor> vendors;
    public Customer(int cust_Id, String cust_Name, String cust_address, List<Vendor> vendors) {
		super();
		this.cust_Id = cust_Id;
		this.cust_Name = cust_Name;
		this.cust_address = cust_address;
		this.vendors = vendors;
	}
	@Override
	public String toString() {
		return "Customer [cust_Id=" + cust_Id + ", cust_Name=" + cust_Name + ", cust_address=" + cust_address
				+ ", vendors=" + vendors + "]";
	}

	public int getCust_Id() {
		return cust_Id;
	}

	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
	}

	public String getCust_Name() {
		return cust_Name;
	}

	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	
}

@Entity
@Table(name="Vendor")
class Vendor{
	@Id
	private int vendorId;
   	private String vendorName;	
   	private String productType;
   	@ManyToMany(mappedBy="vendors")
   	private List<Customer> cust;
	public Vendor(int vendorId, String vendorName, String productType, List<Customer> cust) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.productType = productType;
		this.cust = cust;
	}
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", productType=" + productType
				+ ", cust=" + cust + "]";
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public List<Customer> getCust() {
		return cust;
	}
	public void setCust(List<Customer> cust) {
		this.cust = cust;
	}
	   	
   	
}



/*
 * OneToMany Bidirectional-using join column and join Table
@Entity
public class Customer {
@Table(name="Customer_Info")
	@Id
	private int cust_Id;
	private String cust_Name;
	private String cust_address;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Vendor> vendors;

	public Customer(int cust_Id, String cust_Name, String cust_address, List<Vendor> vendors) {
		super();
		this.cust_Id = cust_Id;
		this.cust_Name = cust_Name;
		this.cust_address = cust_address;
		this.vendors = vendors;
	}

	@Override
	public String toString() {
		return "Customer [cust_Id=" + cust_Id + ", cust_Name=" + cust_Name + ", cust_address=" + cust_address
				+ ", vendors=" + vendors + "]";
	}

	public int getCust_Id() {
		return cust_Id;
	}

	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
	}

	public String getCust_Name() {
		return cust_Name;
	}

	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	
}

@Entity
@Table(name="Vendor_Info")
class Vendor{
	@Id
	private int vendorId;
   	private String vendorName;	
   	private String productType;
   	@ManyToOne(optional=false)
   	@JoinColumn(name="Product_Id")
   	private Customer cust;
	public Vendor(int vendorId, String vendorName, String productType, Customer cust) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.productType = productType;
		this.cust = cust;
	}
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", productType=" + productType
				+ ", cust=" + cust + "]";
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	   	
}*/

