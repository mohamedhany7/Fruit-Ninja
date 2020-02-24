package View;

import Controller.FruitNinja;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class StartController implements Initializable {
    
    @FXML
    public Button easy;
    
    @FXML
    public Button medium;
    
    @FXML
    public Button hard;
    
    @FXML
    public Button classic;
    
    @FXML
    public Button arcade;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void easy(ActionEvent event) throws IOException{
        Parent fruitninja = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene fruitninja_scene = new Scene (fruitninja);
        Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App_stage.setScene(fruitninja_scene);
        App_stage.show();
        FruitNinja.difficulty=1;
    }
    
    public void medium(ActionEvent event) throws IOException{
        Parent fruitninja = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene fruitninja_scene = new Scene (fruitninja);
        Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App_stage.setScene(fruitninja_scene);
        App_stage.show();
        FruitNinja.difficulty=2;
    }
    
    public void hard(ActionEvent event) throws IOException{
        Parent fruitninja = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene fruitninja_scene = new Scene (fruitninja);
        Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App_stage.setScene(fruitninja_scene);
        App_stage.show();
        FruitNinja.difficulty=3;
    }
    
    public void classic(){
        easy.setDisable(false);
        medium.setDisable(false);
        hard.setDisable(false);
        FruitNinja.mode=0;
    }
    
    public void arcade(){
        easy.setDisable(false);
        medium.setDisable(false);
        hard.setDisable(false);
        FruitNinja.mode=1;
    }
}
