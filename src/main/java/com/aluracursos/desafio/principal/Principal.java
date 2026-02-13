package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.model.DatosPersonajes;
import com.aluracursos.desafio.model.DatosPlanetas;
import com.aluracursos.desafio.service.ConsumoAPI;
import com.aluracursos.desafio.service.ConvierteDatos;

import java.util.Arrays;
import java.util.Scanner;

public class Principal {
    private static final String URL_BASE = "https://dragonball-api.com/api/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    Scanner scanner = new Scanner(System.in);

    public void muestraMenu(){

        String valor = "";
        int opcion;

        System.out.println("******************* MENU DE DRAGON BALL *******************");
        System.out.println("""
                      * * * * * * * * * * * * * * * * * * * * * * *
                      *       En esta App puedes encontrar        *
                      *       información de los personajes       *
                      *      y planetas del anime Dragon Ball     *
                      * * * * * * * * * * * * * * * * * * * * * * *
                """);
        System.out.println("Seleccione digitando el numero del menu");
        System.out.println("""
                      * * * * * * * * * * * * * * * * * * * * * * *
                      *      [1]. Personajes                      *
                      *      [3]. Planetas                        *
                      *      [0]. Salir                           *
                      * * * * * * * * * * * * * * * * * * * * * * *
                """);
        System.out.print(": --> ");
        opcion = scanner.nextInt();

        switch (opcion){
            case 1:
                System.out.println("Digite el nombre del PERSONAJE");
                valor = scanner.next();
                var jsonPersonajes = consumoAPI.obtenerDatos(URL_BASE+"characters?name="+valor);
                System.out.println(jsonPersonajes);

                DatosPersonajes[] datosPersonajes = conversor.obtenerDatos(jsonPersonajes, DatosPersonajes[].class);
                System.out.println(Arrays.toString(datosPersonajes));
                break;

            case 2:
                System.out.println("Digite el nombre del PLANETA");
                valor  = scanner.next();
                var jsonPlanetas = consumoAPI.obtenerDatos(URL_BASE+"planets?name="+valor);
                System.out.println(jsonPlanetas);
                DatosPlanetas[] datosPlanetas = conversor.obtenerDatos(jsonPlanetas, DatosPlanetas[].class);
                System.out.println(Arrays.toString(datosPlanetas));
                break;

            case 0:
                System.out.println("Adios! Muchas gracias");
                break;

            default:
                System.out.println("Opción no es valida.");

        }

    }

}
