package ir.ac.kntu.cs2d.server;


import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ServerMain extends Application {
    static Group root = new Group();
    static Scene scene = new Scene(root,800,630,false, SceneAntialiasing.BALANCED);

    public static void main(String[] args) {
        launch(args);
    }



    public static Group getRoot() {
        return root;
    }



    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Scene scene1 = new Scene(pane,600,600);
        stage.setScene(scene1);
        stage.setTitle("two dimensional counter strike ");
        Map map = new Map();
        map.fileReader();
        stage.show();

    }
}
