package com.leafnoise.desafiosimpson.entitys;

import com.leafnoise.desafiosimpson.imp.EmpleadoControl;

public class PatoBalancin implements EmpleadoControl {
    private int donas;
    private int donasRobadas;
    private int energia;
    private boolean distraido;
    private boolean loco;

    public PatoBalancin(int donas, int donasRobadas) {
        this.donas = donas;
        this.donasRobadas = donasRobadas;
        this.energia = donas * 3 + donasRobadas * 4;
        this.distraido = false;
        this.loco = false;
        loco = estaLoco(energia);
        distraido = estaDistraido(energia);
    }

    public boolean estaDistraido(int energia) {
        if (energia < 35) {
            distraido = true;
        } else {
            distraido = false;
        }
        return distraido;
    }

    public boolean estaLoco(int energia) {
        if (energia > 45) {
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
