package ir.ac.kntu.cs2d.server;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ServerMain {
    Group root = new Group();
    Scene scene = new Scene(root);

    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();

        try{
            Object obj = jsonParser.parse(new FileReader("src/main/resources/maps/map.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray buildingsArray = (JSONArray) jsonObject.get("buildings");
            Iterator<String> iterator = buildingsArray.iterator();
            while (iterator.hasNext()){
                ArrayList buildings = (ArrayList) buildingsArray.get(Integer.parseInt(iterator.next()));
                Polygon polygon = new Polygon();
                int[] points;
                for(int i=0; i<=buildings.size();i+=2){
                    polygon.getPoints().addAll((Double) buildings.get(i), (Double) buildings.get(i+1));
                    points = new int[buildings.size()];
                    points[i] = (int)buildings.get(i);
                    /*if(i%2==0)
                        XPoints.add((int)buildings.get(1));
                    else
                        YPoints.add((int)buildings.get(1));*/
                }


            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    private ServerMain() {
    }
}
