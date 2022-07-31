package com.example.portfolio.services;

import com.example.portfolio.models.Experiencia;

import java.util.List;

public interface IExperienciaService {

    List<Experiencia> getExperiencias();

    void saveExperiencia(Experiencia habilidad);

    void deleteExperiencia(Long id);

    Experiencia findExperiencia(Long id);
}
