package com.example.portfolio.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String titulo;
    private String foto;
    private String resumen;
    private String banner;
}

