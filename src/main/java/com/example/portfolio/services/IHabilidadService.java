package com.example.portfolio.services;

import com.example.portfolio.models.Habilidad;

import java.util.List;

public interface IHabilidadService {

    List<Habilidad> getHabilidades();

    void saveHabilidad(Habilidad habilidad);

    void deleteHabilidad(Long id);

    Habilidad findHabilidad(Long id);
}
