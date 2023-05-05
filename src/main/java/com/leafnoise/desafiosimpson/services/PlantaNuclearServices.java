package com.leafnoise.desafiosimpson.services;

import com.leafnoise.desafiosimpson.entitys.Homero;
import com.leafnoise.desafiosimpson.entitys.PatoBalancin;
import com.leafnoise.desafiosimpson.entitys.PlantaNuclear;
import com.leafnoise.desafiosimpson.entitys.SrBurns;

import java.util.HashMap;
import java.util.Map;

public class PlantaNuclearServices {
    public static Map<String, Object> calcularResultados(int donasCantidadHomero, int donasEduardo, int donasRobadas) {
        Map<String, Object> resultados = new HashMap<>();

        // Validar si las donas robadas son más que las que Homero tiene
        if (donasCantidadHomero < donasRobadas) {
            throw new IllegalArgumentException("Las donas robadas son más de las que Homero tiene");
        }


        // Actualizar la cantidad de donas de Homero después de restar las donas robadas
        donasCantidadHomero -= donasRobadas;

        // Crear objetos de las clases necesarias para el cálculo de las condiciones
        Homero homero = new Homero(donasCantidadHomero);
        PatoBalancin patoBalancin = new PatoBalancin(donasEduardo, donasRobadas);
        SrBurns srBurns = new SrBurns(donasCantidadHomero + donasEduardo);
        PlantaNuclear plantaNuclear = new PlantaNuclear(homero.getEnergia(), patoBalancin.getEnergia());

        // Agregar los resultados a un Map
        resultados.put("homero", homero);
        resultados.put("patoBalancin", patoBalancin);
        resultados.put("srBurns", srBurns);
        resultados.put("plantaNuclear", plantaNuclear);

        return resultados;
    }
}
