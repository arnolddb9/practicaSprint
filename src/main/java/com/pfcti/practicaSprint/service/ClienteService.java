package com.pfcti.practicaSprint.service;

import com.pfcti.practicaSprint.dto.ClienteDto;
import com.pfcti.practicaSprint.dto.ContactosDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import com.pfcti.practicaSprint.model.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.pfcti.practicaSprint.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    public List<ClienteDto> obtenerClientes() {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(cliente -> {
            clienteDtos.add(fromClienteToClienteDto(cliente));
        });
        return clienteDtos;
    }

    public ClienteDto obtenerCliente(int clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> {
                            throw new RuntimeException("Cliente no existe");
                        }
                );
        ClienteDto clienteDto = new ClienteDto();
        clienteDto = fromClienteToClienteDto(cliente);

        return clienteDto;
    }

    public void insertarCliente(ClienteDto clienteDto) {

        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setPaisnacimiento(clienteDto.getPaisnacimiento());
        cliente.setPaisresidencia(clienteDto.getPaisresidencia());
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setEstado(clienteDto.getEstado());
        clienteRepository.save(cliente);
    }

    public void actualizarContactosCliente(ContactosDto contactosDto) {

        Cliente cliente = clienteRepository.findById(contactosDto.getIdCliente())
                .orElseThrow(() -> {
                            throw new RuntimeException("Cliente no existe");
                        }
                );

        cliente.setId(contactosDto.getIdCliente());
        cliente.setPaisresidencia(contactosDto.getPaisresidencia());
        cliente.setDireccion(contactosDto.getDireccion());
        cliente.setTelefono(contactosDto.getTelefono());

        clienteRepository.save(cliente);

    }

    public void updateClienteEstadoByQuery(boolean estado, int id) {
        clienteRepository.updateClienteEstadoByQuery(estado, id);
    }


    private ClienteDto fromClienteToClienteDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }
}
