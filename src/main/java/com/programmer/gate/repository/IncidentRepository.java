package com.programmer.gate.repository;

import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.model.Incident;
import com.programmer.gate.model.Scenario;

public interface IncidentRepository extends CrudRepository<Incident, Long> {

}
