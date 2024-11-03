package edu.dio.flavio.java.designpatterns.spring.demo.service;

import ch.qos.logback.core.net.server.Client;

public interface ClientService {

    //searchAll
    Iterable<Client> searchAll();
    //searchById
    Client searchById( Long id);
    //insert
    void insert(Client client);
    //update
    void  update(Long id, Client client);
    //delete
    void delete(Long id);
}
