package pe.edu.vallegrande.demomongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.demomongo.model.Client;
import pe.edu.vallegrande.demomongo.repository.ClientRepository;
import pe.edu.vallegrande.demomongo.utils.Constants;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Mono<Client> save(Client client) {
        client.setStatus(Constants.A.name());
        client.setCreatedAt(LocalDateTime.now());
        return clientRepository.save(client);
    }

    public Flux<Client> findAll() {
        return clientRepository.findAll();
    }

    public Flux<Client> findByStatus(String status) {
        return clientRepository.findAllByStatus(status);
    }

    public Mono<Client> findById(String clientId) {
        return clientRepository.findByClientId(clientId);
    }

    public Mono<Client> updatePartial(String clientId, Client clientUpdates) {
        return clientRepository.findByClientId(clientId)
                .flatMap(existingClient -> {
                    if (clientUpdates.getClientName() != null) {
                        existingClient.setClientName(clientUpdates.getClientName());
                    }
                    if (clientUpdates.getClientLastName() != null) {
                        existingClient.setClientLastName(clientUpdates.getClientLastName());
                    }
                    if (clientUpdates.getEmail() != null) {
                        existingClient.setEmail(clientUpdates.getEmail());
                    }
                    if (clientUpdates.getPhone() != null) {
                        existingClient.setPhone(clientUpdates.getPhone());
                    }
                    return clientRepository.save(existingClient);
                });
    }

    public Mono<Client> delete(String clientId) {
        return clientRepository.findByClientId(clientId)
                .flatMap(client -> {
                    client.setStatus(Constants.I.name());
                    return clientRepository.save(client);
                });
    }

    public Mono<Client> restore(String clientId) {
        return clientRepository.findByClientId(clientId)
                .flatMap(client -> {
                    client.setStatus(Constants.A.name());
                    return clientRepository.save(client);
                });
    }
}
