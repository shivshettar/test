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
@Table(name = "APPOINTMENT")
public class Appointment implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "APP_ID", unique = true, nullable = false)
	private Long appId;
	
	@Column(name = "DATEOFAPP")
	private String dateofApp;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "DOCTOR")
	private String doctor;



	public Long getAppId() {
		return appId;
	}



	public void setAppId(Long appId) {
		this.appId = appId;
	}



	public String getDateofApp() {
		return dateofApp;
	}



	public void setDateofApp(String dateofApp) {
		this.dateofApp = dateofApp;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getDoctor() {
		return doctor;
	}



	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}



	@Override
	public String toString() {
		return "Appointment [appId=" + appId + ",dateofApp =" + dateofApp
				+ ", department=" + department + ", doctor=" +doctor
				 + "]";
	}

}