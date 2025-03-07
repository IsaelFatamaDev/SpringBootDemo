package pe.edu.vallegrande.demomongo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.demomongo.model.Client;
import pe.edu.vallegrande.demomongo.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientRest {

    @Autowired
    private ClientService clientService;


    @PostMapping("/save")
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }

    @GetMapping("/findAll")
    public List<Client> findAll(){
        return clientService.findAll();
    }

}
