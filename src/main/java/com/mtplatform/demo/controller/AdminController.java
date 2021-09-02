package com.mtplatform.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mtplatform.demo.dto.APIError;
import com.mtplatform.demo.dto.Errors;
import com.mtplatform.demo.model.Appointment;
import com.mtplatform.demo.model.Patient;
import com.mtplatform.demo.repository.PatientRepository;
import com.mtplatform.demo.service.AppointmentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController

public class AdminController {

	@Autowired
	AppointmentService appointmentService;

	@Operation(summary = "add Appointment ")
	@RequestMapping(value = "/appointment/add", method = RequestMethod.POST)
	public ResponseEntity<?> addAppointment(@RequestBody Appointment data) {
		try {
			appointmentService.addAppointment(data);
			return ResponseEntity.status(HttpStatus.OK).body("{ \"success\":true }");

		} catch (Exception e) {
			APIError error = new APIError(Errors.GENERAL_ERROR.getCode(), Errors.GENERAL_ERROR.getMessage(),
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}

	}

	@Operation(summary = "gett all Appointment ")
	@RequestMapping(value = "/appointment/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAppointments() {
		try {

			Iterable<Appointment> appointments = appointmentService.getAllAppointments();
			return ResponseEntity.status(HttpStatus.OK).body(appointments);
		} catch (Exception e) {
			APIError error = new APIError(Errors.GENERAL_ERROR.getCode(), Errors.GENERAL_ERROR.getMessage(),
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}

	@Autowired
	PatientRepository patientRepo;
	@Operation(summary = "get Appointment by patient name")
	@RequestMapping(value = "/appointment/getbypatient", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAppointmentsByPatientId(String name) {
		List<Appointment> appoinments=new ArrayList<>();
		try {
			Optional<Patient> patient =patientRepo.findByPatientName(name);
			if(patient.isPresent()) {
			appoinments = appointmentService.getAllAppointmentsByPatientId(patient.get().getPatientId());
		} 
			return ResponseEntity.status(HttpStatus.OK).body(appoinments);

			}catch (Exception e) {
			APIError error = new APIError(Errors.GENERAL_ERROR.getCode(), Errors.GENERAL_ERROR.getMessage(),
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	              new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true, 10));   
	}
	@Operation(summary = "get Appointment by date")
	@RequestMapping(value = "/appointment/allbydate", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAppointmentsByDate(String dat) {
		try {
			List<Appointment> appoinments = appointmentService.getAllAppointmentsByDate(dat);
			return ResponseEntity.status(HttpStatus.OK).body(appoinments);

		} catch (Exception e) {
			APIError error = new APIError(Errors.GENERAL_ERROR.getCode(), Errors.GENERAL_ERROR.getMessage(),
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}
	
	@Operation(summary = "get Appointment by date")
	@RequestMapping(value = "/appointment/alltoday", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAppointmentsByDate() {
		try {
			List<Appointment> appoinments = appointmentService.getAllAppointmentsByToday();
			return ResponseEntity.status(HttpStatus.OK).body(appoinments);

		} catch (Exception e) {
			APIError error = new APIError(Errors.GENERAL_ERROR.getCode(), Errors.GENERAL_ERROR.getMessage(),
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}

	@Operation(summary = "delete Appointment ")
	@RequestMapping(value = "/appointment/delete", method = RequestMethod.GET)
	public ResponseEntity<?> deleteAppointment(Long appointmentId, String msgLog) {
		try {
			ResponseEntity appointment = appointmentService.deleteAppointment(appointmentId, msgLog);

			return ResponseEntity.status(HttpStatus.OK).body(appointment.getBody());

		} catch (Exception e) {
			APIError error = new APIError(Errors.GENERAL_ERROR.getCode(), Errors.GENERAL_ERROR.getMessage(),
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}

}
