package com.mtplatform.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtplatform.demo.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Long>{

	 Optional<Patient> findByPatientName(String name); 
	
}