package com.netbiis.wasabibackend.repository;

import com.netbiis.wasabibackend.entetys.CategoriaEntity;
import com.netbiis.wasabibackend.entetys.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutosRepositry extends CrudRepository<ProdutosEntity,Integer> {
    List<ProdutosEntity> findProdutosEntitiesByCategoriaByIdCategoria(CategoriaEntity categoria);
}
