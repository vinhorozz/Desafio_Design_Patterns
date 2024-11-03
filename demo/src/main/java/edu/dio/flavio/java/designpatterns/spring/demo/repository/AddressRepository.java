package edu.dio.flavio.java.designpatterns.spring.demo.repository;

import edu.dio.flavio.java.designpatterns.spring.demo.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,String> {
}
