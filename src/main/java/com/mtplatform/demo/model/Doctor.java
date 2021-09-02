package com.mtplatform.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Doctor {
	@Id
	@SequenceGenerator(allocationSize = 1, name="crm_contact_s",sequenceName="crm_contact_s")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="crm_contact_s" )
	@Column(name = "doctor_id", nullable = false)
	
    private Long doctorId;
	
	@Column(name="doctor_name")
	private String	doctorName;

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

}