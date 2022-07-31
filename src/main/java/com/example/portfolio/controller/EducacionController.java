package com.example.portfolio.controller;

import com.example.portfolio.dto.Mensaje;
import com.example.portfolio.models.Educacion;
import com.example.portfolio.services.IEducacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class EducacionController {

    private final IEducacionService interfaceEducacion;

    public EducacionController(IEducacionService interfaceEducacion) {
        this.interfaceEducacion = interfaceEducacion;
    }


    @GetMapping("/educacion")
    public List<Educacion> getEducacion(){
        return interfaceEducacion.getEducaciones();
    }

    @PostMapping("/educacion/nueva")
    public ResponseEntity<?> createEducacion(@RequestBody Educacion educacion){
        interfaceEducacion.saveEducacion(educacion);
        return new ResponseEntity<>(new Mensaje("Educación registrada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/educacion/borrar/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable Long id){
        interfaceEducacion.deleteEducacion(id);
        return new ResponseEntity<>(new Mensaje("Educación eliminada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/educacion/editar/{id}")
    public Educacion editEducacion(@PathVariable Long id,
                                 @RequestBody Educacion educacionNueva){

        Educacion educacion = interfaceEducacion.findEducacion(id);

        educacion.setTitulo(educacionNueva.getTitulo());
        educacion.setDescripcion(educacionNueva.getDescripcion());
        educacion.setFecha(educacionNueva.getFecha());

        interfaceEducacion.saveEducacion(educacion);

        return educacion;
    }
}