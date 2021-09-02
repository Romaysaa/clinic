package com.mtplatform.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mtplatform.demo.dto.APIError;
import com.mtplatform.demo.dto.Errors;
import com.mtplatform.demo.model.Appointment;
import com.mtplatform.demo.repository.AppointmentRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@Service
public class AppointmentService {
	@Autowired
	AppointmentRepository appointmentRepository;

	public   Appointment addAppointment(Appointment data)
	{		
		return appointmentRepository.save(data);
	}
	
	
    public Iterable<Appointment> getAllAppointments(){  
    	return appointmentRepository.findByIsDeletedFalseOrIsDeletedIsNull();
    }

    public List<Appointment> getAllAppointmentsByPatientId(Long id){  
    	return appointmentRepository.findByPatientId(id);
    }
//    java.time.LocalTime.now()
    public List<Appointment> getAllAppointmentsByDate(String dat){  
    	Date date = StringToDate(dat);
    	String pattern = "yyyy-MM-dd HH:mm:ss";
    	SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    	String mysqlDateString = formatter.format(date);

    	return appointmentRepository.findByDate(mysqlDateString);
    }
    public Date StringToDate(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }
    public List<Appointment> getAllAppointmentsByToday(){  
    	Date date=java.util.Calendar.getInstance().getTime();  
    	String pattern = "yyyy-MM-dd HH:mm:ss";
    	SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    	String mysqlDateString = formatter.format(date);

    	return appointmentRepository.findByDate(mysqlDateString);
    }
    
	public ResponseEntity<?> deleteAppointment(Long appointmentId,String msgLog) {
		try{
			Optional<Appointment> appointment=	appointmentRepository.findById(appointmentId);
		
		if(appointment.isPresent()) {
			Appointment temp=appointment.get();
			temp.setIsDeleted(true);
			appointmentRepository.save(temp);
			
		}
		return ResponseEntity.status(HttpStatus.OK).body(msgLog);

		} catch (Exception e) {
			APIError error = new APIError(Errors.GENERAL_ERROR.getCode(), Errors.GENERAL_ERROR.getMessage(),
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	} 
	 

}
