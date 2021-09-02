package com.mtplatform.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
public class Appointment {
	@Id
	@SequenceGenerator(allocationSize = 1, name = "crm_contact_s", sequenceName = "crm_contact_s")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crm_contact_s")
	@Column(name = "appointment_id", nullable = false)

	private Long appointmentId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.DATE)

	@Column(name = "date")
	private Date date;

	@ManyToOne()
	@JoinColumn(name = "patient_id")
	Patient patient;

	@ManyToOne()
	@JoinColumn(name = "doctor_id")
	Doctor doctor;

	@Column(name = "is_deleted")
	@ColumnDefault("0")
	private Boolean isDeleted;

	
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
