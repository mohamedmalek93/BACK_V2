package com.programmer.gate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.programmer.gate.model.Step;

@Repository
public interface StepRepository extends CrudRepository<Step, Long> {

	
}
