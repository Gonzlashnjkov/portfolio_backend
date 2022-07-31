package com.example.portfolio.services;

import com.example.portfolio.models.Persona;

import java.util.List;

public interface IPersonaService {

     List<Persona> getPersonas();

     void savePersona(Persona persona);

     void deletePersona(Long id);

     Persona findPersona(Long id);
}
