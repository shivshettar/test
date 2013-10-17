package com.wenzins.webhis.entity;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "department_details")
public class DepartmentDetails implements java.io.Serializable {

	private static final long serialVersionUID = 926436474204511691L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "DEP_ID", unique = true, nullable = false)
	private Long depId;
	
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	

	

	public Long getDepId() {
		return depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	
	@Override
	public String toString() {
		return "DepartmetDetails [departmentName=" + departmentName 
				+ "]";
	}

	
	
	

}
