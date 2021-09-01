package ar.com.ada.api.creditos.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.models.response.GenericResponse;
import ar.com.ada.api.creditos.services.ClienteService;

@RestController
public class ClienteController {
    @Autowired
    ClienteService service;

    public List<Cliente> traerTodos(){
        return service.traerTodos();
    }


    public void crearCliente(Cliente cliente){
     service.createCliente(cliente);
    }

    @PostMapping
    public ResponseEntity<GenericResponse> crearClienteV2(@RequestBody Cliente cliente){

        GenericResponse r = new GenericResponse();

        service.createCliente(cliente);

        r.isOk = true;
        r.id = cliente.getClienteId();
        r.mensaje = "el cliente fue creado con exito";


        return ResponseEntity.ok(r);
    }


}
