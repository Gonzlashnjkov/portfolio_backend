package com.example.portfolio.services;

import com.example.portfolio.models.Experiencia;
import com.example.portfolio.repositories.ExperienciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService implements IExperienciaService {

    private final ExperienciaRepository experienciaRepository;

    public ExperienciaService(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }

    @Override
    public List<Experiencia> getExperiencias(){
        return experienciaRepository.findAll();
    }

    @Override
    public void saveExperiencia(Experiencia experiencia){
        experienciaRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id){
        experienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id){
        return experienciaRepository.findById(id).orElse(null);
    }
}
