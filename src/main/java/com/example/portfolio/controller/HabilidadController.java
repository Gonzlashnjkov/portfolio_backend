package com.example.portfolio.controller;

import com.example.portfolio.dto.Mensaje;
import com.example.portfolio.models.Habilidad;
import com.example.portfolio.services.IHabilidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HabilidadController {

    private final IHabilidadService interfaceHabilidad;

    public HabilidadController(IHabilidadService interfaceHabilidad) {
        this.interfaceHabilidad = interfaceHabilidad;
    }


    @GetMapping("/habilidad")
    public List<Habilidad> getHabilidades(){
        return interfaceHabilidad.getHabilidades();
    }

    @PostMapping("/habilidad/nueva")
    public ResponseEntity<?> createHabilidad(@RequestBody Habilidad habilidad){
        interfaceHabilidad.saveHabilidad(habilidad);
        return new ResponseEntity<>(new Mensaje("Habilidad registrada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/habilidad/borrar/{id}")
    public ResponseEntity<?> deleteHabilidad(@PathVariable Long id){
        interfaceHabilidad.deleteHabilidad(id);
        return new ResponseEntity<>(new Mensaje("Habilidad eliminada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/habilidad/editar/{id}")
    public Habilidad editHabilidad(@PathVariable Long id,
                                   @RequestBody Habilidad habilidadNueva){

        Habilidad habilidad = interfaceHabilidad.findHabilidad(id);
        habilidad.setTitulo(habilidadNueva.getTitulo());
        habilidad.setPorcentaje(habilidadNueva.getPorcentaje());

        interfaceHabilidad.saveHabilidad(habilidad);

        return habilidad;
    }
}