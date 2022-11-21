package com.netbiis.wasabibackend.controller;

import com.netbiis.wasabibackend.Exceptions.ClientNotFoundException;
import com.netbiis.wasabibackend.Exceptions.PaymentNotFoundException;
import com.netbiis.wasabibackend.entetys.ClienteEntity;
import com.netbiis.wasabibackend.entetys.PagamentoEntity;
import com.netbiis.wasabibackend.services.ClienteService;
import com.netbiis.wasabibackend.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @Autowired
    private ClienteService serviceC;

    //Achar todos os pagamentos
    @GetMapping("/findAllPagamentos")
    public List<PagamentoEntity> getAllPagamentos (){
        return service.findAll();
    }
    //Achar pagamentos por Id
    @GetMapping("/findByClient/{email}")
    public List<PagamentoEntity> getPagamentosById (@PathVariable("email")String email) throws PaymentNotFoundException, ClientNotFoundException {
        return service.findPagamentoByCliente(serviceC.getClientByEmail(email));
    }

    //Cadastrar um pagamento
    @PostMapping("/addPagamento/{idC}&{idP}&{quantidade}")
    public String addPagamento (@PathVariable("idC") int idC,@PathVariable("idP") int idP, @PathVariable("quantidade")int quantidade) throws ClientNotFoundException {
        service.save(new PagamentoEntity(idC, idP,quantidade,serviceC.getById(idC).get()));
        return "Cliente added";
    }
}
