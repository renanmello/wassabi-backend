package com.netbiis.wasabibackend.controller;

import com.netbiis.wasabibackend.Exceptions.ClientNotFoundException;
import com.netbiis.wasabibackend.entetys.CategoriaEntity;
import com.netbiis.wasabibackend.entetys.ClienteEntity;
import com.netbiis.wasabibackend.entetys.ProdutosEntity;
import com.netbiis.wasabibackend.repository.CategoriaRepository;
import com.netbiis.wasabibackend.services.ClienteService;
import com.netbiis.wasabibackend.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    //Achar CLIENTE pelo email
    @GetMapping("/client/{email}")
    public ClienteEntity getClient(@PathVariable("email") String email) throws ClientNotFoundException {
        return service.getClient(email);
    }

    @PostMapping("/clientLogin/{email}&{senha}")
    public ClienteEntity isVerified(@PathVariable("email") String email, @PathVariable("senha") String senha) throws ClientNotFoundException {
        try{
            if(service.verifyClient(email, senha))
                return service.getClientByEmail(email);
            else
                return null;
        }catch (Exception e){
            return null;
        }
    }

    //Todos os CLIENTES
    @GetMapping("/allClients")
    public List<ClienteEntity> getAllClients() {
        return service.findAllClients();
    }

    //CADASTRAR CLIENTE
    @PostMapping("/singClient")
    public String addClient(@RequestBody ClienteEntity cliente) throws ClientNotFoundException {
        //ClienteEntity isso = new ClienteEntity("vinicius","122-122-122","Av.Paulista","98129999","555-555-555","vinicius@vinicus","123123");
        try {
            if(service.getClient(cliente.getClienteEmail()) == null){
                service.save(cliente);
                return "Client added";
            }else
                return "Email Already in use";
        }catch (Exception e){
            return "Erro";
        }
    }


}

