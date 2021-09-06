package ar.com.ada.api.creditos.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.creditos.entities.Prestamo;
import ar.com.ada.api.creditos.models.request.PrestamoRequest;
import ar.com.ada.api.creditos.models.response.GenericResponse;
import ar.com.ada.api.creditos.services.PrestamoService;

public class PrestamoController {
    

    @Autowired
    PrestamoService service;

    @PostMapping ("/prestamos")
    public ResponseEntity<GenericResponse> emitirPrestamo(@RequestBody PrestamoRequest request){
        GenericResponse r = new GenericResponse();

        Prestamo prestamo = service.emitirPrestamo(request.clienteId, request.importe, request.cuotas, request.fechaPrestamo);

        r.id = prestamo.getPrestamoId();
        r.isOk = true;
        r.mensaje = "El prestamo ha sido ingresado en el sistema "+ "Estado del prestamo:" + prestamo.getEstadoId();

        return ResponseEntity.ok(r);


    }
}
