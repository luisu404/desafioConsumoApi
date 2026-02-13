package com.aluracursos.desafio.service;

import org.springframework.boot.json.JsonParseException;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

public class ConvierteDatos implements IConvierteDatos {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return mapper.readValue(json, clase);
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        }
    }
}