package com.pfcti.practicaSprint.api;

import com.pfcti.practicaSprint.dto.ClienteDto;
import com.pfcti.practicaSprint.dto.ContactosDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.pfcti.practicaSprint.service.ClienteService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/cliente")
public class Clienteapi {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ClienteDto buscarCliente(@PathVariable int id){
        log.info("Busqueda de cliente : {}", id);
        return clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "/all")
    public List<ClienteDto> buscarTodosClientes(){
        return clienteService.obtenerClientes(); }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void guardarCliente(@RequestBody ClienteDto clienteDto){
        log.info("cliente de cliente : {}", clienteDto);
        clienteService.insertarCliente(clienteDto);
    }

    @PutMapping
    public void actualizarContactosCliente(@RequestBody ContactosDto contactosDto){
        log.info("contactos de cliente : {}", contactosDto);
        clienteService.actualizarContactosCliente(contactosDto); }


    @PutMapping(value = "/updateEstado")
    public void updateClienteEstadoByQuery(@RequestBody boolean estado, int idCliente){
        log.info("estado actualizado de cliente: {} {}", idCliente,estado);
        clienteService.updateClienteEstadoByQuery(estado,idCliente);
    }

}


