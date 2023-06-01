package com.example.cakey.modele;

import java.util.ArrayList;

public class Terrain {
    private int [] terrain1 ;
    public static int NBCOLONNE= 17;
    public static int NBLIGNE= 16;
    public static int SOURCE = 270;
    public static int CASEDEPART=18;
    private ArrayList<Integer> chemin;
    public static int TAILLETILE = 16;

    public Terrain(){

        terrain1= new int[]{
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,1,
                1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,
                1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,
                1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,
                1,0,1,1,0,0,0,1,0,0,0,0,1,0,1,0,1,
                1,0,1,1,0,1,0,1,0,1,1,0,1,0,1,0,1,
                1,0,0,0,0,1,0,1,0,1,1,0,0,0,1,0,1,
                1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,
                1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,
                1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,
                1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,
                1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,
                1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1};
//
//        terrain1= new int[]{
//                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//                1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,
//                1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,
//                1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,
//                1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,
//                1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,
//                1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,
//                1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,
//                1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,
//                1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,
//                1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,
//                1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,
//                1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,
//                1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,
//                1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,
//                1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,};
        BFS bfs= new BFS(this,SOURCE);
        chemin = bfs.cheminVersSource(CASEDEPART);

    }

    public void afficherTab(){
        for (int i = 0; i < terrain1.length; i++) {
            if ((i+1)%5==0) {
                System.out.print(terrain1[i] + "\t");
                System.out.println("\n");
            }else
                System.out.print(terrain1[i]+"\t");
        }
    }

    public int getValeurTuile(int i){
       return terrain1[i];
    }
    public int getLongueur(){
        return terrain1.length;
    }
    public int[] getTerrain() {
        return terrain1;
    }

    public int positionTerrain(Ennemi ennemi){
            return ennemi.getX()/TAILLETILE+(ennemi.getY()/TAILLETILE*17);

    }
    public ArrayList<Integer> getChemin() {
        return chemin;
    }

    public ArrayList<Integer> adjacentes(int valeurCase){
        ArrayList<Integer> adjacentes = new ArrayList<>();
        if (valeurCase%NBCOLONNE!=0){
//            System.out.println("entrée1");
            if (terrain1[valeurCase-1]==0)
                adjacentes.add(valeurCase-1);
        }
        if (valeurCase%NBCOLONNE!=NBCOLONNE-1){
//            System.out.println("entrée 2");
            if (terrain1[valeurCase+1]==0) {
                adjacentes.add(valeurCase + 1);
            }
        }
        if (!(valeurCase/NBLIGNE==0)){
//            System.out.println("entrée 3");
            if (terrain1[valeurCase-NBCOLONNE]==0)
                adjacentes.add(valeurCase-NBCOLONNE);
        }
        if (valeurCase/NBLIGNE!=NBLIGNE){

            if (terrain1[valeurCase+NBCOLONNE]==0)
                adjacentes.add(valeurCase+NBCOLONNE);
        }
        return adjacentes;
    }

}
