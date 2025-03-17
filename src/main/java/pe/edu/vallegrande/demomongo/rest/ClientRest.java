package pe.edu.vallegrande.demomongo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.demomongo.model.Client;
import pe.edu.vallegrande.demomongo.service.ClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class ClientRest {

    @Autowired
    private ClientService clientService;

    @PostMapping("/save")
    public Mono<Client> save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @GetMapping("/findAll")
    public Flux<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/findActive")
    public Flux<Client> findActiveClients() {
        return clientService.findActiveClients();
    }
}
