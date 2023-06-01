package com.example.cakey.controleur;

import com.example.cakey.modele.Ennemi;
import com.example.cakey.vue.EnnemisVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ListObsEnnemis implements javafx.collections.ListChangeListener<Ennemi> {
    private Pane panneauDeJeu;
    private EnnemisVue ennemisVue;

    public ListObsEnnemis(Pane panneauDeJeu, EnnemisVue ennemisVue) {
        this.panneauDeJeu = panneauDeJeu;
        this.ennemisVue=ennemisVue;
    }

    public void onChanged(ListChangeListener.Change<? extends Ennemi> c) {
        while (c.next()) {
            if (c.wasAdded()) {
                System.out.println("ajouté");
                for (int i = 0; i < c.getAddedSize(); i++) {
                    ennemisVue.afficherEnnemi(c.getAddedSubList().get(i));
                }
            }
            else{
                System.out.println("retiré");
                for(int i =0;i<c.getRemovedSize();i++) {
                    panneauDeJeu.getChildren().remove(panneauDeJeu.lookup('#'+c.getRemoved().get(i).getId()));
                }

            }
        }
    }

}

