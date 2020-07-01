package com.programmer.gate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.programmer.gate.model.Scenario;

@Repository
public interface ScenarioRepository extends CrudRepository<Scenario, Long> {

	
}
