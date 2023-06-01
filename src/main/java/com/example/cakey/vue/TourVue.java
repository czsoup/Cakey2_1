package com.example.cakey.vue;

import com.example.cakey.modele.Ennemi;
import com.example.cakey.modele.Tour;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TourVue {
    private Pane panneauDeJeu;

    public TourVue(Pane pane) {
        this.panneauDeJeu = pane;
    }

    public void afficherTour(Tour t) {
        Circle sprite = new Circle(12);
        sprite.setFill(Color.BLUE);
        sprite.setId(t.getId());
        sprite.translateXProperty().bind(t.getXProperty());
        sprite.translateYProperty().bind(t.getYProperty());
        panneauDeJeu.getChildren().add(sprite);
    }




}
