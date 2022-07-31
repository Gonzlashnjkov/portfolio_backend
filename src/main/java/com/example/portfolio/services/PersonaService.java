package com.example.portfolio.services;

import com.example.portfolio.repositories.PersonaRepository;
import com.example.portfolio.models.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona){
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id){
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id){
        return personaRepository.findById(id).orElse(null);
    }
}
