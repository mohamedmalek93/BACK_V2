package com.programmer.gate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.programmer.gate.model.Product;
@Repository
public interface USRepository extends CrudRepository<Product, Long>{

}
