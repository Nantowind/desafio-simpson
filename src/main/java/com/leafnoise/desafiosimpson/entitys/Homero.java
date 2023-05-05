package com.leafnoise.desafiosimpson.entitys;

import com.leafnoise.desafiosimpson.imp.EmpleadoControl;

public class Homero implements EmpleadoControl {

    private int donas;
    private int energia;
    private boolean distraido;
    private boolean loco;

    public Homero(int donas) {
        this.donas = donas;
        this.energia = donas * 3;
        this.distraido = false;
        this.loco = false;
        distraido = estaDistraido(energia);
        loco = estaLoco(energia);
    }

    public boolean estaDistraido(int energia) {
        if (energia < 70) {
            distraido = true;
        } else {
            distraido = false;
        }
        return distraido;
    }

    public boolean estaLoco(int energia) {
        if (energia > 80) {
            loco = true;
        } else {
            loco = false;
        }
        return loco;
    }

    public boolean isDistraido() {
        return distraido;
    }

    public boolean isLoco() {
        return loco;
    }

    public int getEnergia() {
        return energia;
    }
}
