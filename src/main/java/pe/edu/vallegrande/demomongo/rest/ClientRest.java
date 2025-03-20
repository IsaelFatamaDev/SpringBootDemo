package pe.edu.vallegrande.demomongo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Mono<ResponseEntity<Client>> save(@RequestBody Client client) {
        return clientService.save(client)
                .map(savedClient -> ResponseEntity.ok().body(savedClient))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @GetMapping("/findAll")
    public ResponseEntity<Flux<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/findByStatus/{status}")
    public ResponseEntity<Flux<Client>> findByStatus(@PathVariable String status) {
        return ResponseEntity.ok(clientService.findByStatus(status));
    }

    @GetMapping("/find/{id}")
    public Mono<ResponseEntity<Client>> findById(@PathVariable String id) {
        return clientService.findById(id)
                .map(client -> ResponseEntity.ok().body(client))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PatchMapping("/update/{id}")
    public Mono<ResponseEntity<Client>> updatePartial(@PathVariable String id, @RequestBody Client client) {
        return clientService.updatePartial(id, client)
                .map(updatedClient -> ResponseEntity.ok().body(updatedClient))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/delete/{id}")
    public Mono<ResponseEntity<Client>> softDelete(@PathVariable String id) {
        return clientService.delete(id)
                .map(client -> ResponseEntity.ok().body(client))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/restore/{id}")
    public Mono<ResponseEntity<Client>> restore(@PathVariable String id) {
        return clientService.restore(id)
                .map(client -> ResponseEntity.ok().body(client))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
