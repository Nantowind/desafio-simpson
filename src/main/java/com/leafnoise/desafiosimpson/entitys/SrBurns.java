package com.leafnoise.desafiosimpson.entitys;

public class SrBurns {
    private boolean bancaRota;
    private int dinero;
    private int donas;

    public SrBurns(int donas) {
        this.donas = donas;
        this.dinero = 155 - (donas * 4);
        bancaRota = estaEnBancaRota();
    }

    private boolean estaEnBancaRota() {
        return dinero < 0;
    }

    public boolean isBancaRota() {
        return bancaRota;
    }

}
