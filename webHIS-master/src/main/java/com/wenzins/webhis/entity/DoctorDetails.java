package com.wenzins.webhis.entity;


import java.util.Date;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.wenzins.webhis.entity.types.AddressType;
import com.wenzins.webhis.entity.types.PhoneType;

@Entity
@Table(name = "doctor_details")
public class DoctorDetails implements java.io.Serializable {

	private static final long serialVersionUID = -8158361737220282015L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "DOCTOR_ID", unique = true, nullable = false)
	private Long doctorId ;
	
	@Column(name = "DOCTOR_NAME")
	private String doctorName;
	
	
	
	
	@Column(name = "FROM_DATE")
	private Date fromDate;
	@Column(name = "TO_DATE")
	private Date toDate;
	
	
	@Column(name = "FROM_TIME")
	private String fromTime;
	
	@Column(name = "TO_TIME")
	private String toTime;
	
	


	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}





	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	

	

	@Override
	public String toString() {
		return "DoctorDetails [doctorName=" + doctorName + ", fromDate="
				+ fromDate + ", toDate=" + toDate+", fromTime=" + fromTime+",toTime=" + toTime+" departmentName=" + departmentName+"]";
	}
}
