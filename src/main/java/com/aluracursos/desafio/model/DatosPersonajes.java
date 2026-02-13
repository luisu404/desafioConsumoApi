package com.aluracursos.desafio.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPersonajes(
        @JsonAlias("id") Integer id,
        @JsonAlias("name") String nombre,
        @JsonAlias("ki") String ki,
        @JsonAlias("maxKi") String kiMaximo,
        @JsonAlias("race") String raza,
        @JsonAlias("gender") String genero

) {}
