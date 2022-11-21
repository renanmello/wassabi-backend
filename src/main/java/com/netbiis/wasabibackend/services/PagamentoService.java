package com.netbiis.wasabibackend.services;

import com.netbiis.wasabibackend.Exceptions.PaymentNotFoundException;
import com.netbiis.wasabibackend.entetys.ClienteEntity;
import com.netbiis.wasabibackend.entetys.PagamentoEntity;
import com.netbiis.wasabibackend.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    public List<PagamentoEntity> findPagamentoByCliente(ClienteEntity cliente) throws PaymentNotFoundException {
        List<PagamentoEntity> payments = repository.findPagamentoEntitiesByClienteByIdCliente(cliente);
        if(!payments.isEmpty())
            return payments;
        throw new PaymentNotFoundException("Payments not found from client with the email: "+cliente.getClienteEmail());
    }

    public List<PagamentoEntity> findAll(){
        return (List<PagamentoEntity>) repository.findAll();
    }

    public void save (PagamentoEntity pagamento){repository.save(pagamento);}
}
