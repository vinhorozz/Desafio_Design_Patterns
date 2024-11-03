package edu.dio.flavio.java.designpatterns.spring.demo.service.implematation;

import edu.dio.flavio.java.designpatterns.spring.demo.model.Address;
import edu.dio.flavio.java.designpatterns.spring.demo.model.Client;
import edu.dio.flavio.java.designpatterns.spring.demo.repository.AddressRepository;
import edu.dio.flavio.java.designpatterns.spring.demo.repository.ClientRepository;
import edu.dio.flavio.java.designpatterns.spring.demo.service.ClientService;
import edu.dio.flavio.java.designpatterns.spring.demo.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClientServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> searchAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client searchById(Long id) {
        Optional<Client> client=clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
            saveChanges(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> client1=clientRepository.findById(id);
        if (client1.isPresent()){
            saveChanges(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveChanges(Client client){
        String cep=client.getAddress().getCep();
        Address address= addressRepository.findById(cep).orElseGet(
                ()->{
                    Address newAddress= viaCepService.checkCep(cep);
                    addressRepository.save(newAddress);
                    return newAddress;
                }
        );
    }

}
