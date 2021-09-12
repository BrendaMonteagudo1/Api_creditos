package ar.com.ada.api.creditos.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.models.request.InfoClienteActualizada;
import ar.com.ada.api.creditos.models.response.GenericResponse;
import ar.com.ada.api.creditos.services.ClienteService;

@RestController
public class ClienteController {
    @Autowired
    ClienteService service;

    @GetMapping("/clientes")
    public List<Cliente> traerTodos(){
        return service.traerTodos();
    }


    public void crearCliente(Cliente cliente){
     service.createCliente(cliente);
    }

    @PostMapping ("/clientes")
    public ResponseEntity<GenericResponse> crearClienteV2(@RequestBody Cliente cliente){

        GenericResponse r = new GenericResponse();

        service.createCliente(cliente);

        r.isOk = true;
        r.id = cliente.getClienteId();
        r.mensaje = "el cliente fue creado con exito";


        return ResponseEntity.ok(r);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<GenericResponse> actualizarCliente(@PathVariable Integer id,
            @RequestBody InfoClienteActualizada infoCliente) {

        Cliente cliente = service.buscarPorId(id);
        cliente.setNombre(infoCliente.nombre);
        cliente.setDireccion(infoCliente.direccion);
        cliente.setDireccionAlternativa(infoCliente.direccionAlternativa);
        cliente.setFechaNacimiento(infoCliente.fechaNacimiento);
        service.actualizar(cliente);

        GenericResponse respuesta = new GenericResponse();

        respuesta.isOk = true;
        respuesta.id = cliente.getClienteId();
        respuesta.mensaje = "Los datos del cliente han sido actualizados.";

        return ResponseEntity.ok(respuesta);
    }


}
