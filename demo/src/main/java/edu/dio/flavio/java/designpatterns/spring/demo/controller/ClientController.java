package edu.dio.flavio.java.designpatterns.spring.demo.controller;
// Classe responsável por pegar os dados da página e vinculálos aos endpoints

import edu.dio.flavio.java.designpatterns.spring.demo.model.Client;
import edu.dio.flavio.java.designpatterns.spring.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("client")
public class ClientController {
        @Autowired
        private ClientService clientService;
        @GetMapping("/{}")
        public ResponseEntity<Iterable<Client>> searchAllClients(){
            return ResponseEntity.ok(clientService.searchAll());
        }
        @GetMapping("/{id}")
        public  ResponseEntity<Client>searchClientById(@PathVariable Long id){
            return ResponseEntity.ok(clientService.searchById(id));
        }

        @PostMapping
        public ResponseEntity<Client>addClient(@RequestBody Client client){
            clientService.insert(client);
            return ResponseEntity.ok(client);
        }
        @PutMapping("/{id}")
        public ResponseEntity<Client>updateClient(@PathVariable Long id, @RequestBody Client client){
            clientService.update(id,client);
            return ResponseEntity.ok(client);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteClient(@PathVariable Long id ){
            clientService.delete(id);
            return ResponseEntity.ok().build();
        }

}
