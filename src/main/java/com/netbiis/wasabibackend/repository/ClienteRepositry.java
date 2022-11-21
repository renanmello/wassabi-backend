package com.netbiis.wasabibackend.repository;

import com.netbiis.wasabibackend.entetys.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositry extends CrudRepository<ClienteEntity,Integer> {
    ClienteEntity findClienteEntityByClienteEmail(String ClientEmail);

}
