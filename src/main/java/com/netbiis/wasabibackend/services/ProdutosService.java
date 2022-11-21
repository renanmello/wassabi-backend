package com.netbiis.wasabibackend.services;

import com.netbiis.wasabibackend.Exceptions.ClientNotFoundException;
import com.netbiis.wasabibackend.Exceptions.ProductsNotFoundException;
import com.netbiis.wasabibackend.entetys.CategoriaEntity;
import com.netbiis.wasabibackend.entetys.ClienteEntity;
import com.netbiis.wasabibackend.entetys.ProdutosEntity;
import com.netbiis.wasabibackend.repository.ProdutosRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepositry repositry;
/*
    public ClienteEntity getClient(String email) throws ClientNotFoundException {
        try {
            ClienteEntity clientEntity = repository.findClienteEntityByClienteEmail(email);

            return clientEntity;
        }catch (Exception e) {
            throw new ClientNotFoundException("Could not find client with email=" + email);
        }
    }


 */
    public List<ProdutosEntity> findAllprodutos(){
        return (List<ProdutosEntity>) repositry.findAll();
    }

    public List<ProdutosEntity> findProducstByCatego(CategoriaEntity categoria) throws ProductsNotFoundException {
        List<ProdutosEntity> Products = repositry.findProdutosEntitiesByCategoriaByIdCategoria(categoria);
        if(!Products.isEmpty())
            return Products;
        throw new ProductsNotFoundException("Product not found from "+categoria+" type");
    }

}
