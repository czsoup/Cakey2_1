package com.example.cakey.vue;

import com.example.cakey.modele.Ennemi;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class EnnemisVue {
    private Pane panneauDeJeu;

    public EnnemisVue(Pane pane) {
        this.panneauDeJeu = pane;
    }

    public void afficherEnnemi(Ennemi e) {
        Circle sprite = new Circle(8);
        sprite.setFill(Color.RED);
        sprite.setId(e.getId());
        sprite.translateXProperty().bind(e.getXProperty());
        sprite.translateYProperty().bind(e.getYProperty());
        panneauDeJeu.getChildren().add(sprite);


    }

}
