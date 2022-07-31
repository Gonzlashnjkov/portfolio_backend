package com.example.portfolio.services;

import com.example.portfolio.models.Educacion;

import java.util.List;

public interface IEducacionService {

     List<Educacion> getEducaciones();

     void saveEducacion(Educacion educacion);

     void deleteEducacion(Long id);

     Educacion findEducacion(Long id);
}