package com.netbiis.wasabibackend.repository;

import com.netbiis.wasabibackend.entetys.ClienteEntity;
import com.netbiis.wasabibackend.entetys.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends CrudRepository<PagamentoEntity,Integer> {

    List<PagamentoEntity> findPagamentoEntitiesByClienteByIdCliente(ClienteEntity cliente);

}
