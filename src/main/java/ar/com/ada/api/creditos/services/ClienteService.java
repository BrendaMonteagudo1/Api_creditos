package ar.com.ada.api.creditos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.repos.ClienteRepository;

///vamos a crear un servis con la funcionalidad de traer todos lo clientes y de grabar un cliente

@Service
public class ClienteService {

   @Autowired
    ClienteRepository repository;

    public List<Cliente> traerTodos(){
    return repository.findAll();
    } 
    
    
    public void createCliente(Cliente cliente){
     repository.save(cliente);
    } 

    public Cliente buscarPorId(Integer id){
        return repository.findByClienteId(id);
     }
    
}
