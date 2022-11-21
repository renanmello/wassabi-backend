package com.netbiis.wasabibackend.services;

import com.netbiis.wasabibackend.Exceptions.ClientNotFoundException;
import com.netbiis.wasabibackend.entetys.ClienteEntity;
import com.netbiis.wasabibackend.repository.ClienteRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepositry repository;

    public boolean verifyClient(String email, String senha) throws ClientNotFoundException{
        try {
            ClienteEntity clientEntity = repository.findClienteEntityByClienteEmail(email);
            return clientEntity != null && clientEntity.getClienteSenha().equals(senha);
        }catch (Exception e){
            return false;
        }
    }

    public List<ClienteEntity> findAllClients(){
        return (List<ClienteEntity>) repository.findAll();
    }


    public ClienteEntity getClientByEmail(String email) throws ClientNotFoundException{
        try{
            return repository.findClienteEntityByClienteEmail(email);
        }catch (Exception e) {
            throw new ClientNotFoundException("Cliente not found");
        }
    }

    public List<ClienteEntity> getClients(){
        return (List<ClienteEntity>) repository.findAll();
    }

    public void save(ClienteEntity client) {
        repository.save(client);
    }

    public ClienteEntity getClient(String email) throws ClientNotFoundException {
        try {
            ClienteEntity clientEntity = repository.findClienteEntityByClienteEmail(email);

            return clientEntity;
        }catch (Exception e) {
            throw new ClientNotFoundException("Could not find client with email=" + email);
        }
    }

    public void deleteClient(String email) throws ClientNotFoundException {
        ClienteEntity cliente = repository.findClienteEntityByClienteEmail(email);
        if(cliente == null){
            throw new ClientNotFoundException("Could not find client with email="+cliente);
        }
        repository.deleteById(cliente.getIdCliente());
    }

    public Optional<ClienteEntity> getById (int id) throws ClientNotFoundException{
          return repository.findById(id);
    }
}
