package com.baeldung.hexagonalarchitecture.repository;


import com.baeldung.hexagonalarchitecture.core.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
