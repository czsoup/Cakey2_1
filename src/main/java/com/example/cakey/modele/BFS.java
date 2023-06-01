package com.example.cakey.modele;

import java.util.*;

public class BFS {
    private int source;
    private Terrain terrain ;
    private List<Integer> parcours ;
    private Map<Integer, Integer> predecesseurs;

    public BFS(Terrain terrain, int source ){
        this.terrain= terrain;
        this.source= source;
        this.parcours= new ArrayList<Integer>();
        predecesseurs= new HashMap<Integer, Integer>();
        algo();
    }

    public List<Integer> getParcours() {
        return parcours;
    }

    void algo() {
        LinkedList<Integer> fifo = new LinkedList();
        fifo.add(source);
        parcours.add(source);
        int caseCourante = source;
        predecesseurs.put(source, null);

        while (!fifo.isEmpty()) {
            caseCourante = fifo.pollFirst();
            for (int vCase : terrain.adjacentes(caseCourante)) {
                if (!parcours.contains(vCase)) {
                    parcours.add(vCase);
                    predecesseurs.put(vCase, caseCourante);
                    fifo.add(vCase);
                }
            }
        }
    }
    public ArrayList<Integer> cheminVersSource(int cible){
        ArrayList<Integer> chemin = new ArrayList<>();
        while(predecesseurs.get(cible)!=null){
            chemin.add(predecesseurs.get(cible));
            cible=predecesseurs.get(cible);
        }
        return chemin;
    }

    public static void main(String[] args) {
        Terrain t =new Terrain();
        BFS bfs = new BFS(t,Terrain.SOURCE);
        ArrayList<Integer> chemin = bfs.cheminVersSource(Terrain.CASEDEPART);
        System.out.println(chemin.size());
    }





}

