package com.netbiis.wasabibackend.controller;

import com.netbiis.wasabibackend.Exceptions.ProductsNotFoundException;
import com.netbiis.wasabibackend.entetys.CategoriaEntity;
import com.netbiis.wasabibackend.entetys.ProdutosEntity;
import com.netbiis.wasabibackend.repository.CategoriaRepository;
import com.netbiis.wasabibackend.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProdutoController {

    @Autowired
    private CategoriaRepository catrep;

    @Autowired
    private ProdutosService serviceP;

    // Achar Todos os produtos
    @GetMapping("/produtos")
    public List<ProdutosEntity> getProdutos(){
        return serviceP.findAllprodutos();
    }

    // Achar produtos por Categoria
    @GetMapping("/produtosByCar/{id_categoria}")
    public List<ProdutosEntity> getProdutosByCad(@PathVariable("id_categoria")int i){
        Optional<CategoriaEntity> cat = catrep.findById(i);
        return cat.map(categoria -> {
            try {
                return serviceP.findProducstByCatego(categoria);
            } catch (ProductsNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).orElse(null);
    }


}
