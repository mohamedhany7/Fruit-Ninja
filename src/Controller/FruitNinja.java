package Controller;

import java.applet.Applet;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import  java.io.*;
import java.net.URL;


public class FruitNinja extends Application {
    
    public static int difficulty=0;
    public static int mode=0;
    static int music = 1;
    
     @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Start.fxml"));
        System.out.println("java version: "+System.getProperty("java.version")); 
        System.out.println("javafx.version: " + System.getProperty("javafx.version"));
        System.out.println(System.getProperties());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FRUIT NINJA");
        stage.show();
        stage.setResizable(false);
    }

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\FruitNinja\\src\\audio\\ShakeYourBootay.wav");
        URL url = null;
        if (file.canRead()) {url = file.toURI().toURL();}
        java.applet.AudioClip clip = Applet.newAudioClip(url);
        clip.play();
        launch(args);
    }
    
}
