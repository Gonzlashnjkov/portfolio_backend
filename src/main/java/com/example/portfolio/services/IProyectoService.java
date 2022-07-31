package com.example.portfolio.services;

import com.example.portfolio.models.Proyecto;

import java.util.List;

public interface IProyectoService {

     List<Proyecto> getProyectos();

     void saveProyecto(Proyecto proyecto);

     void deleteProyecto(Long id);

     Proyecto findProyecto(Long id);
}
