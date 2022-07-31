package com.example.portfolio.controller;

import com.example.portfolio.dto.Mensaje;
import com.example.portfolio.models.Persona;
import com.example.portfolio.services.IPersonaService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PersonaController {

    private final IPersonaService interfacePersona;

    public PersonaController(IPersonaService interfacePersona) {
        this.interfacePersona = interfacePersona;
    }


    @GetMapping("/persona")
    public List<Persona> getPersonas(){
        return interfacePersona.getPersonas();
    }

    @PostMapping("/persona/nueva")
    public ResponseEntity<?> createPersona(@RequestParam("nombre") String nombre,
                                          @RequestParam("titulo") String titulo,
                                          @RequestParam("foto") String foto,
                                          @RequestParam("banner") String banner,
                                          @RequestParam("resumen") String resumen)  {

        Persona persona = new Persona();

        persona.setTitulo(titulo);
        persona.setNombre(nombre);
        persona.setFoto(foto);
        persona.setBanner(banner);
        persona.setResumen(resumen);
        interfacePersona.savePersona(persona);
        return new ResponseEntity<>(new Mensaje("Persona registrada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/persona/borrar/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id){
        interfacePersona.deletePersona(id);
        return new ResponseEntity<>(new Mensaje("Persona eliminada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                             @RequestParam("nombre") String nombre,
                             @RequestParam("titulo") String titulo,
                             @RequestParam("foto") String foto,
                             @RequestParam("banner") String banner,
                             @RequestParam("resumen") String resumen)  {

        Persona persona = interfacePersona.findPersona(id);

        persona.setTitulo(titulo);
        persona.setNombre(nombre);
        persona.setFoto(foto);
        persona.setBanner(banner);
        persona.setResumen(resumen);
        interfacePersona.savePersona(persona);
        return persona;
    }

    @PutMapping("/nombre/editar/{id}")
    public Persona editNombre(@PathVariable Long id,
                             @RequestParam("nombre") String nombre) {

        Persona persona = interfacePersona.findPersona(id);
        persona.setNombre(nombre);
        interfacePersona.savePersona(persona);
        return persona;
    }

    @PutMapping("/titulo/editar/{id}")
    public Persona editTitulo(@PathVariable Long id,
                             @RequestParam("titulo") String titulo) {
        Persona persona = interfacePersona.findPersona(id);
        persona.setTitulo(titulo);
        interfacePersona.savePersona(persona);
        return persona;
    }

    @PutMapping("/foto/editar/{id}")
    public Persona editFoto(@PathVariable Long id,
                           @RequestParam("foto") String foto)  {

        Persona persona = interfacePersona.findPersona(id);
        persona.setFoto(foto);

        interfacePersona.savePersona(persona);
        return persona;
    }

    @PutMapping("/banner/editar/{id}")
    public Persona editBanner(@PathVariable Long id,
                             @RequestParam("banner") @NotNull String banner)  {

        Persona persona = interfacePersona.findPersona(id);
        persona.setBanner(banner);

        interfacePersona.savePersona(persona);
        return persona;
    }

    @PutMapping("/resumen/editar/{id}")
    public Persona editResumen(@PathVariable Long id,
                              @RequestParam("resumen") String resumen) {

        Persona persona = interfacePersona.findPersona(id);
        persona.setResumen(resumen);
        interfacePersona.savePersona(persona);
        return persona;
    }
}
