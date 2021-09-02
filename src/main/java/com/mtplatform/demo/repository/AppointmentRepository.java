package com.mtplatform.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtplatform.demo.model.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Long>{

	List<Appointment> findByIsDeletedFalseOrIsDeletedIsNull();
	
	@Query(value = "select * from appointment  where patient_id=:id", nativeQuery = true)
	List<Appointment> findByPatientId(@Param("id") Long id);
	
	@Query(value = "select * from appointment  where date=:dat", nativeQuery = true)
	List<Appointment> findByDate(@Param("dat") String mysqlDateString);
}