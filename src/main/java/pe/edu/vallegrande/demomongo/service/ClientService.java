package pe.edu.vallegrande.demomongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.demomongo.model.Client;
import pe.edu.vallegrande.demomongo.repository.ClientRepository;
import pe.edu.vallegrande.demomongo.utils.Constants;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client){
        client.setStatus(Constants.A.name());
        return clientRepository.save(client);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

}
