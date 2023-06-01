package com.example.cakey.modele;

import javafx.beans.property.IntegerProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class Ennemi extends Acteur {

    List<Integer> chemin;
    private int xCaseSuivante, yCaseSuivante, i, j, cptChemin;


    public Ennemi(int PV, int PA, int porteeAttaque, Environnement environnement, Terrain t){

        super(PV, PA, porteeAttaque, "e" + cpt, 24, 24, environnement, t);
        this.chemin = this.getTerrain().getChemin();
        xCaseSuivante = chemin.get(cptChemin) % Terrain.NBCOLONNE * 16 + 8;
        yCaseSuivante = chemin.get(cptChemin) / Terrain.NBLIGNE * 16 + 8;
        i = (this.getX() - xCaseSuivante) / 16;
        j = (this.getY() - yCaseSuivante) / 16;
    }


    public void agir() {
        //diff selon les sous classes
        // avance
        // regarde périmètre si tour
        // si oui attaque
    }

    @Override
    public String toString() {
        return "Ennemi{" +
                "xProperties=" + getX() +
                ", yProperties=" + getX() +
                ", pv=" + getPV() +
                ", id='" + getId() + '\'' +
                '}';
    }


    public int positionTerrain() {
        return getX() / 16 + (getY() / 16 * 17);
    }

    void seDeplacer() {
        if (this.getX() != xCaseSuivante || this.getY() != yCaseSuivante) {
            this.setX(this.getX() - i);
            this.setY(this.getY() - j);
        } else {
            cptChemin++;
            xCaseSuivante = chemin.get(cptChemin) % Terrain.NBCOLONNE * 16 + 8;
            yCaseSuivante = chemin.get(cptChemin) / 17 * 16 + 8;
            i = (this.getX() - xCaseSuivante) / 16;
            j = (this.getY() - yCaseSuivante) / 16;
        }

    }
}
