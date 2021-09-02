package com.mtplatform.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtplatform.demo.model.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long>{

}
