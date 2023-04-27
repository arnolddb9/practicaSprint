package com.pfcti.practicaSprint.repository;

import com.pfcti.practicaSprint.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>, JpaSpecificationExecutor<Cliente> {


    @Modifying
    @Query(value = "update Cliente c set c.estado=:estado where c.id=:id")
    void updateClienteEstadoByQuery(boolean estado, int id);
}
