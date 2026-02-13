package com.aluracursos.desafio.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPlanetas(
        @JsonAlias("id") Integer id,
        @JsonAlias("name") String nombre,
        @JsonAlias("isDestroyed") Boolean isDestroyed
) {
}
