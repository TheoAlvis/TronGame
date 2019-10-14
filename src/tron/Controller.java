package tron;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.File;


public class Controller {

    @FXML
    Canvas canvas;

    @FXML
    BorderPane borderPane;

    @FXML
    Button start;

    private boolean gameEnd = false;

    public void initialize() {



        File imagePath = new File("tron/background.png");

        // create a image
        Image image = new Image(imagePath.getPath());

        BackgroundSize bSize = new BackgroundSize(900, 900, false, false, true, false);

        // create a background image
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                bSize);

        // create Background
        Background background = new Background(backgroundimage);


        borderPane.setBackground(background);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline tl = new Timeline(new KeyFrame(Duration.millis(100), e -> draw(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        canvas.setFocusTraversable(true);

        canvas.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                Player.getPlayer(0).setY(600/2);
                Player.getPlayer(0).setXDistance(10);

                Player.getPlayer(1).setY(600/2);
                Player.getPlayer(1).setX(590);
                Player.getPlayer(1).setXDistance(-10);

                tl.play();
            }
        });


    }

    public void draw(GraphicsContext gc){
        if(!gameEnd) {
            canvas.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.W) {
                    Player.getPlayer(0).setYDistance(-10);
                    Player.getPlayer(0).setXDistance(0);
                    System.out.println("test");
                }
                if (event.getCode() == KeyCode.A) {
                    Player.getPlayer(0).setYDistance(0);
                    Player.getPlayer(0).setXDistance(-10);
                }
                if (event.getCode() == KeyCode.S) {
                    Player.getPlayer(0).setYDistance(10);
                    Player.getPlayer(0).setXDistance(0);
                }
                if (event.getCode() == KeyCode.D) {
                    Player.getPlayer(0).setYDistance(0);
                    Player.getPlayer(0).setXDistance(10);
                }

                if (event.getCode() == KeyCode.UP) {
                    Player.getPlayer(1).setYDistance(-10);
                    Player.getPlayer(1).setXDistance(0);
                    System.out.println("test");
                }
                if (event.getCode() == KeyCode.LEFT) {
                    Player.getPlayer(1).setYDistance(0);
                    Player.getPlayer(1).setXDistance(-10);
                }
                if (event.getCode() == KeyCode.DOWN) {
                    Player.getPlayer(1).setYDistance(10);
                    Player.getPlayer(1).setXDistance(0);
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    Player.getPlayer(1).setYDistance(0);
                    Player.getPlayer(1).setXDistance(10);
                }
            });

            playerUpdate(0, gc);
            playerUpdate(1, gc);

            gameEnd = Player.getPlayer(0).colisionDetection(0);


        }

    }

    public void playerUpdate(int i, GraphicsContext gc){
        int tempX = Player.getPlayer(i).getX() + Player.getPlayer(i).getXDistance();
        int tempY = Player.getPlayer(i).getY() + Player.getPlayer(i).getYDistance();

        Player.getPlayer(i).setTrail(tempX,tempY);
        Player.getPlayer(i).setX(tempX);
        Player.getPlayer(i).setY(tempY);

        if(i == 0){
            gc.setFill(Color.AQUA);
        }
        else{
            gc.setFill(Color.RED);
        }

        gc.fillRect(tempX, tempY, Player.getTrailSize(), Player.getTrailSize());
    }
}
