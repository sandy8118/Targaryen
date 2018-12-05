package com.scp.java.HbOperations;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.*;
@Entity
@Table(name="Employee_T")
@NamedQueries
(
    {
        @NamedQuery(name=Employee.getEmpById, query=Employee.getEmpByIdQuery)   
       // @NamedQuery(name=DepartmentEntity.UPDATE_DEPARTMENT_BY_ID, query=DepartmentEntity.UPDATE_DEPARTMENT_BY_ID_QUERY)
    }
)
public class Employee {
	static final String getEmpByIdQuery="from Employee where employee_Id=:id";
    public static final String getEmpById="getEmpById";
	
	@Id
	private int employee_Id;
	private String employee_Name;
	private String employee_address;
	private int employee_sallary;
	
	public Employee(int emloyee_Id, String employee_Name, String employee_address, int employee_sallary) {
		super();
		this.employee_Id = emloyee_Id;
		this.employee_Name = employee_Name;
		this.employee_address = employee_address;
		this.employee_sallary = employee_sallary;
	}

	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", employee_Name=" + employee_Name + ", employee_address="
				+ employee_address + ", employee_sallary=" + employee_sallary + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmployee_Id() {
		return employee_Id;
	}
	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getEmployee_Name() {
		return employee_Name;
	}
	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}
	public String getEmployee_address() {
		return employee_address;
	}
	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}
	public int getEmployee_sallary() {
		return employee_sallary;
	}
	public void setEmployee_sallary(int employee_sallary) {
		this.employee_sallary = employee_sallary;
	}
	

}
