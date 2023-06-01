package com.example.cakey.modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tour extends Acteur{

    private int prix;
    private ArrayList<Ennemi> ennemisAPortee;

    public Tour(int prix, int PV, int PA,int porteeAttaque, int x, int y, Environnement environnement, Terrain t) {
        super(PV, PA, porteeAttaque, "t"+cpt, x,y , environnement, t);
        this.ennemisAPortee = new ArrayList<>();
        this.prix = prix;
    }


    public void agir() {
//        if (ennemisAPortee.isEmpty())
            remplirEnnemiAPortee(); //l'arraylist est trié par ID

        System.out.println("ennemis à portée : "+ ennemisAPortee);
        if (!ennemisAPortee.isEmpty()) {
            attaquerLEnnemiNeeEnPremier();
        }

    }

    public void remplirEnnemiAPortee() {
        ennemisAPortee.clear();
        Ennemi ennemi;
        for (int i = 0; i < getEnvironnement().getEnnemis().size(); i++) {
            ennemi = getEnvironnement().getEnnemis().get(i);
            if (estDansPerimetre(ennemi)) { //retourne si ennemi est ds perim de la tour
                ennemisAPortee.add(ennemi);
            }
        }
        //tri la fonction du plus petit [0] au plus grand
        Collections.sort(ennemisAPortee, new Comparator<Ennemi>() {
            public int compare(Ennemi ennemi1, Ennemi ennemi2) {
                return ennemi1.getId().compareTo(ennemi2.getId()); //lexico
            }

        });
        Collections.reverse(ennemisAPortee);

    }

    public void attaquerLEnnemiNeeEnPremier(){
        for (int i = ennemisAPortee.size()-1; i >= 0; i--) {
            if (estDansPerimetre(ennemisAPortee.get(i))) {
                System.out.println("i index : "+i+", ennemi :" + ennemisAPortee.get(i).getId());
                attaquer(ennemisAPortee.get(i));
                //    if (ennemisAPortee.get(i).estMort())
                //        getEnvironnement().retirerEnnemi(ennemisAPortee.get(i));
                System.out.println("ennemi trouvé par la tour");
                break;
            }else {
                ennemisAPortee.remove(ennemisAPortee.get(i));
            }
            System.out.println("pas d'ennemi dans le perimetre");
        }
    }
 /*   public void attaquerLEnnemiNeeEnPremier(){
        for (int i = 0; i < ennemisAPortee.size(); i++) {

            if (estDansPerimetre(ennemisAPortee.get(i))) {
                attaquer(ennemisAPortee.get(i));
            //    if (ennemisAPortee.get(i).estMort())
            //        getEnvironnement().retirerEnnemi(ennemisAPortee.get(i));
                System.out.println("ennemi trouvé par la tour");
                break;
            }else {
                ennemisAPortee.remove(ennemisAPortee.get(i));
            }
            System.out.println("pas d'ennemi dans le perimetre");
        }
    }*/

        /*
   public Ennemi ennemiNeeEnPremier(){
            if (ennemisAPortee.isEmpty()) {
                return null;
            }

            Ennemi plusPetitID = ennemisAPortee.get(0);

            for (int i = 1; i < ennemisAPortee.size(); i++) {
                Ennemi e = ennemisAPortee.get(i);
                if (e.getId().compareTo(plusPetitID.getId()) < 0) {
                    plusPetitID = e;
                }
            }

            return plusPetitID;
        }
*/
}
