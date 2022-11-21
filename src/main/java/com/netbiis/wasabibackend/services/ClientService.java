/*package com.webstore.services;

import com.webstore.entities.ClientEntity;
import com.webstore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public boolean verifyClient(ClientEntity client){
        ClientEntity clientEntity = repository.findClientEntityByClientEmail(client.getClientEmail());
        return clientEntity != null && clientEntity.getClientPassword().equals(client.getClientPassword());
    }

    public ClientEntity getClientByEmail(String email){
        return repository.findClientEntityByClientEmail(email);
    }

    public List<ClientEntity> getClients(){
        return (List<ClientEntity>) repository.findAll();
    }

    public void save(ClientEntity client) {
        repository.save(client);
    }

    public ClientEntity getClient(long id) throws ClientNotFoundException {
        Optional<ClientEntity> result = repository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ClientNotFoundException("Could not find client with id="+id);
    }

    public void deleteClient(long id) throws ClientNotFoundException {
        Long count = repository.countClientByRegistration(id);
        if(count == null || count == 0){
            throw new ClientNotFoundException("Could not find client with id="+count);
        }
        repository.deleteById(id);
    }
}


 */