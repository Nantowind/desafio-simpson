package com.leafnoise.desafiosimpson.entitys;

public class PlantaNuclear {
    int cantidadUranio;
    int energiaHomero;
    int energiaEduardo;
    boolean estaEnPeligro;

    public PlantaNuclear(int energiaHomero, int energiaEduardo) {
        this.energiaHomero = energiaHomero;
        this.energiaEduardo = energiaEduardo;
        estaEnPeligro = cargaUranio(energiaHomero,energiaEduardo);
        cantidadUranio = cantidadUranioPorDia(energiaHomero,6) +
                cantidadUranioPorDia(energiaEduardo,18);

    }

    public boolean cargaUranio(int energiaHomero, int energiaEduardo){
       int cargaHomero = cantidadUranioPorDia(energiaHomero,6);
       int cargaEdudardo = cantidadUranioPorDia(energiaEduardo,18);

       if (cargaHomero + cargaEdudardo <9500){
           return true;
       } else if (cargaHomero + cargaEdudardo > 10000) {
           return true;
       }else {
           return false;
       }

    }
    public int cantidadUranioPorDia(int energiaEmpleado, int velocidadEmpleado){

        return energiaEmpleado * velocidadEmpleado * 8;
    }

    public int getCantidadUranio() {
        return cantidadUranio;
    }

    public boolean isEstaEnPeligro() {
        return estaEnPeligro;
    }
}
