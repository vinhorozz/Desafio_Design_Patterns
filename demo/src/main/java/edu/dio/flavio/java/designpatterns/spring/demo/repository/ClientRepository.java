package edu.dio.flavio.java.designpatterns.spring.demo.repository;

import edu.dio.flavio.java.designpatterns.spring.demo.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {

}
