package com.example.cakey.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {

    public static int cpt = 0;
    private String id;
    private int PV, PA;
    private IntegerProperty x, y;

    private int porteeAttaque;
    private Environnement environnement;
    private Terrain terrain;



    public Acteur(int PV, int PA, int porteeAttaque, String id, int x, int y, Environnement environnement, Terrain t) {
        this.PV = PV;
        this.PA = PA;
        this.id = id;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.porteeAttaque = porteeAttaque;
        this.environnement = environnement;
        this.terrain = t;
        cpt++;
    }

    public void attaquer(Acteur a){
        if (a instanceof Ennemi) {
            Ennemi ennemi = (Ennemi) a;
            if (ennemi.estMort()) {
                getEnvironnement().retirerEnnemi(ennemi);
            }
        }
        a.seFaitAttaquer(PA);
        System.out.println("attaque de "+ PA);
        System.out.println(a);

    }
    public boolean estMort( ){
        return getPV()<1;
    }

    public void seFaitAttaquer(int pointAttaque){
        setPV(PV-pointAttaque);
    }


    public boolean estDansPerimetre(Acteur a){
        int distanceA = a.getX() - getX();
        int distanceB = a.getY() - getY();
        double distance= Math.sqrt(Math.pow(distanceA,2)+ Math.pow(distanceB,2));

        return distance <= porteeAttaque;
    }
    public abstract void agir();


    public void setPV(int PV) {
        this.PV = PV;
    }

    public String getId() {
        return id;
    }

    public int getPorteeAttaque() {
        return porteeAttaque;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public int getPV() {
        return PV;
    }

    public int getX() {
        return x.get();
    }

    public IntegerProperty getXProperty() {
        return x;
    }

    public int getY() {
        return y.get();
    }

    public final  IntegerProperty getYProperty() {
        return y;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public int getPA() {
        return PA;
    }



}
