package pe.edu.vallegrande.sprinbootpostgres.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.sprinbootpostgres.model.Client;
import pe.edu.vallegrande.sprinbootpostgres.service.ClientService;
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
    public Mono<ResponseEntity<Client>> findById(@PathVariable Long id) {
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PatchMapping("/update/{id}")
    public Mono<ResponseEntity<Client>> update(@PathVariable Long id, @RequestBody Client client) {
        return clientService.update(id, client)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/delete/{id}")
    public Mono<ResponseEntity<Client>> softDelete(@PathVariable Long id) {
        return clientService.delete(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/restore/{id}")
    public Mono<ResponseEntity<Client>> restore(@PathVariable Long id) {
        return clientService.restore(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}

