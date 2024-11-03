package edu.dio.flavio.java.designpatterns.spring.demo.service;

import edu.dio.flavio.java.designpatterns.spring.demo.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="viacep",url="https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    Address checkCep(@PathVariable("cep")String cep);
}
