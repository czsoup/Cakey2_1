package com.example.cakey.controleur;

import com.example.cakey.modele.Ennemi;
import com.example.cakey.modele.Tour;
import com.example.cakey.vue.EnnemisVue;
import com.example.cakey.vue.TourVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ListObsTours implements javafx.collections.ListChangeListener<Tour> {
    private Pane panneauDeJeu;
    private TourVue tourVue;

    public ListObsTours(Pane panneauDeJeu, TourVue tourVue) {
        this.panneauDeJeu = panneauDeJeu;
        this.tourVue = tourVue;
    }

    // TODO: 30/05/2023 verif onchanged
    public void onChanged(ListChangeListener.Change<? extends Tour> c) {
        while (c.next()) {
            if (c.wasAdded()) {
                System.out.println("tour ajouté");
                for (int i = 0; i < c.getAddedSize(); i++) {
                    tourVue.afficherTour(c.getAddedSubList().get(i));
                }
            } else {
                System.out.println("tour retiré");
                for (int i = 0; i < c.getRemovedSize(); i++) {
                    panneauDeJeu.getChildren().remove(panneauDeJeu.lookup('#' + c.getRemoved().get(i).getId()));
                }

            }
        }

    }
}

