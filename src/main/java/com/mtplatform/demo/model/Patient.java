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
public class Patient {
	@Id
	@SequenceGenerator(allocationSize = 1, name="crm_contact_s",sequenceName="crm_contact_s")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="crm_contact_s" )
	@Column(name = "patient_id", nullable = false)
	
    private Long patientId;
	
	@Column(name="patient_name")
	private String	patientName;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	

}
