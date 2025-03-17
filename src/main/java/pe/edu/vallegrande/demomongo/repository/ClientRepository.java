package pe.edu.vallegrande.demomongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.demomongo.model.Client;
import reactor.core.publisher.Flux;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
    Flux<Client> findAllByStatus(String status);
}
