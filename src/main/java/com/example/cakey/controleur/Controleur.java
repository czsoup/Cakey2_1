package com.example.cakey.controleur;

import com.example.cakey.Main;
import com.example.cakey.modele.Ennemi;
import com.example.cakey.modele.Environnement;
import com.example.cakey.modele.Terrain;
import com.example.cakey.modele.Tour;
import com.example.cakey.vue.EnnemisVue;
import com.example.cakey.vue.TerrainVue;
import com.example.cakey.vue.TourVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    @FXML
    private TilePane tilepane;
    private Terrain terrain;
    @FXML
    private Pane panneauDeJeu;
    @FXML
    private Button ajouterTour;
    @FXML
    private Button boutonEnnemi;
    private Environnement env;
    private Timeline gameLoop;
    private int temps;

    @Override
    public void initialize(URL location, ResourceBundle ressources) {

        this.terrain = new Terrain();

        TerrainVue terrainVue = new TerrainVue(terrain, tilepane);
        terrainVue.afficherTerrain();
        this.env= new Environnement(terrain);
        EnnemisVue ennemisVue=new EnnemisVue(panneauDeJeu);

        ListChangeListener listen = new ListObsEnnemis(panneauDeJeu,ennemisVue);
        env.getEnnemis().addListener(listen);

        initAnimation();
        gameLoop.play();



    }
    @FXML
    void ajouterTour(){

        System.out.println("clic sur ajouterTour");
        Tour t1  = new Tour(100,100,5,30,70,50,env,terrain);
        env.ajouterTour(t1);
        TourVue tourVue = new TourVue(panneauDeJeu);
        tourVue.afficherTour(t1);
    }
    /*
     @FXML
    void ajouterTour(MouseEvent event){

        int x = (int) event.getSceneX();
        int y = (int) event.getSceneY();

        System.out.println("clic sur ajouterTour");
        Tour t1  = new Tour(100,100,5,30,x,y,env,terrain);
        env.ajouterTour(t1);
        TourVue tourVue = new TourVue(panneauDeJeu);
        tourVue.afficherTour(t1);
    }
     */

    void unTour(){
        env.unTour();
    }

    private void initAnimation() {
        gameLoop = new Timeline();
        temps=0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.05),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{
                    if(temps==500) {
                        System.out.println("fini");
                        gameLoop.stop();
                    }
                    else {
                        System.out.println("un tour");
                        unTour();
                        temps++;
                    }
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }
}
