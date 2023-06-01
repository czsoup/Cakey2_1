package com.example.cakey.vue;

import com.example.cakey.Main;
import com.example.cakey.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.net.URL;

public class TerrainVue {

    private Terrain terrain;
    private TilePane tilePane;

    public TerrainVue(Terrain terrain, TilePane tilePane) {
        this.terrain = terrain;
        this.tilePane = tilePane;
    }

    public void afficherTerrain() {

        URL urlNappe = Main.class.getResource("nappe16x16.png");
        Image nappe = new Image(String.valueOf(urlNappe));

        URL urlWhite = Main.class.getResource("white16x16.png");
        Image white = new Image(String.valueOf(urlWhite));

        for (int i = 0; i < terrain.getLongueur(); i++) {

            if (terrain.getValeurTuile(i) == 1){
                ImageView nappeView = new ImageView(nappe);
                this.tilePane.getChildren().add(nappeView);
            }
            else if (terrain.getValeurTuile(i) == 0){
                ImageView whiteView = new ImageView(white);
                this.tilePane.getChildren().add(whiteView);
            }
        }

    }



}
