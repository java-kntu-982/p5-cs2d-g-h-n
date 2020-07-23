package ir.ac.kntu.cs2d.server;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Map {
    static private Tiles[][] tiles = new Tiles[126][160];

    public void fileReader() {
        try {
            File file = new File("src/main/resources/maps/TheMap.txt");
            Scanner in = new Scanner(file);
            for (int i = 0; in.hasNextLine(); i++) {
                for (int j = 0; in.hasNext("a-z"); j++) {
                    ServerMain.getRoot().getChildren().add(tiles[i][j].getRect());
                    tiles[i][j].getRect().setHeight(5);
                    tiles[i][j].getRect().setWidth(5);
                    tiles[i][j].getRect().setX(i * 5);
                    tiles[i][j].getRect().setY(j * 5);
                    switch (in.next("a-z")) {
                        case "y":
                            tiles[i][j].getRect().setFill(Color.rgb(255, 250, 205));
                            tiles[i][j].setHeight(2);
                            break;
                        case "w":
                            tiles[i][j].getRect().setFill(Color.WHITE);
                            tiles[i][j].setHeight(0);
                            break;
                        case "p":
                            tiles[i][j].getRect().setFill(Color.rgb(255, 215, 0));
                            tiles[i][j].setHeight(1);
                            break;
                        case "b":
                            tiles[i][j].getRect().setFill(Color.rgb(139, 69, 19));
                            tiles[i][j].setHeight(2);
                            break;
                        case "r":
                            tiles[i][j].getRect().setFill(Color.rgb(255, 0, 0));
                            tiles[i][j].setHeight(0);
                            break;
                        case "l":
                            tiles[i][j].getRect().setFill(Color.rgb(250, 128, 114));
                            tiles[i][j].setHeight(0);
                            break;
                        case "s":
                            tiles[i][j].getRect().setFill(Color.rgb(135,206,235));
                            tiles[i][j].setHeight(0);
                            break;
                        case "g" :
                            tiles[i][j].getRect().setFill(Color.rgb(119,136,153));
                            tiles[i][j].setHeight(1);
                            break;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
