package com.example.portfolio.controller;

import com.example.portfolio.dto.Mensaje;
import com.example.portfolio.models.Experiencia;
import com.example.portfolio.services.IExperienciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ExperienciaController {

    private final IExperienciaService interfaceExperiencia;

    public ExperienciaController(IExperienciaService interfaceExperiencia) {
        this.interfaceExperiencia = interfaceExperiencia;
    }


    @GetMapping("/experiencia")
    public List<Experiencia> getExperiencia(){
        return interfaceExperiencia.getExperiencias();
    }

    @PostMapping("/experiencia/nueva")
    public ResponseEntity<?> createEducacion(@RequestBody Experiencia experiencia){
        interfaceExperiencia.saveExperiencia(experiencia);
        return new ResponseEntity<>(new Mensaje("Experiencia registrada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/experiencia/borrar/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable Long id){
        interfaceExperiencia.deleteExperiencia(id);
        return new ResponseEntity<>(new Mensaje("Experiencia eliminada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/experiencia/editar/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
                                   @RequestBody Experiencia experienciaNueva){

        Experiencia experiencia = interfaceExperiencia.findExperiencia(id);

        experiencia.setTitulo(experienciaNueva.getTitulo());
        experiencia.setDescripcion(experienciaNueva.getDescripcion());
        experiencia.setFecha(experienciaNueva.getFecha());

        interfaceExperiencia.saveExperiencia(experiencia);

        return experiencia;
    }
}