package com.example.cakey.modele;

import javafx.collections.FXCollections;

import java.util.ArrayList;
import javafx.collections.ObservableList;
public class Environnement {
    private Terrain terrain;
    private ObservableList<Ennemi> ennemis;
    private ObservableList<Tour> tours;
    private static  int NBMAXENNEMI1 = 5;
    private int nbEnnemiActuel =0;
    private int cptTour=0;

    public Environnement(Terrain terrain) {
        this.terrain = terrain;
        this.ennemis =FXCollections.observableArrayList();
        this.tours =FXCollections.observableArrayList();
    }

    public void ajouterTour(Tour t){
        tours.add(t);
    }
    public void retirerTour(Tour t){
        tours.remove(t);
    }
    public void ajouterEnnemi(Ennemi ennemi){
        ennemis.add(ennemi);
    }
    public void retirerEnnemi(Ennemi ennemi){
        ennemis.remove(ennemi);
        System.out.println("ennemi retiré :" + ennemis.remove(ennemi));
    }

    public void unTour(){
        for (int i =0 ;i<ennemis.size();i++) {
            ennemis.get(i).seDeplacer();
            System.out.println("id="+ennemis.get(i).getId());
            System.out.println("pv="+ennemis.get(i).getPV());
         if (ennemis.get(i).positionTerrain() == terrain.getTerrain().length-2 )
               ennemis.remove(ennemis.get(i));
       }
        if (cptTour%18==0){
            if(nbEnnemiActuel<NBMAXENNEMI1) {
                Ennemi e = new Ennemi(30,5,20,this,terrain); //
                ajouterEnnemi(e);
                nbEnnemiActuel++;
            }

        }
        cptTour++;
        System.out.println(tours.size());
        for (int i =0 ;i<tours.size();i++) {
            if (tours.get(i).estMort())
                tours.remove(tours.get(i));
            else tours.get(i).agir();

        }
     }

    public ObservableList<Ennemi> getEnnemis() {
        return ennemis;
    }
//
//    public static void main(String[] args) {
//        Terrain terrain =  new Terrain();
//    }
//
//
//    @Override
//    public String toString() {
//        return "Environnement{" +
//                "terrain=" + terrain +
//                ", ennemis=" + ennemis +
//                '}';
//    }
}
