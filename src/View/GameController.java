package View;

import Controller.FruitNinja;
import Controller.GameEngine;
import Model.GameObject;
import java.applet.Applet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class GameController implements Initializable {

    @FXML
    private Label live3lbl;
    @FXML
    private Label live2lbl;
    @FXML
    private Label live1lbl;
    @FXML
    private Label score;
    @FXML
    private Label bestScore;
    @FXML
    public ImageView image1;
    @FXML
    public ImageView image2;
    @FXML
    public ImageView image3;
    @FXML
    public ImageView image4;
    @FXML
    public ImageView image5;
    @FXML
    public Label timelbl;
    @FXML
    private ImageView instructionsimage;
    @FXML
    private Label instructionslbl;

    
    int second=0;
    int miniute=0;
    GameObject obj;
    GameEngine engine = GameEngine.getInstance();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       instructionsimage.setVisible(true);
       instructionslbl.setVisible(true);
       image1.setLayoutY(700);
       image2.setLayoutY(700);
       image3.setLayoutY(700);
       image4.setLayoutY(700);
       image5.setLayoutY(700);
       engine.loadScore();
       bestScore.setText(Integer.toString(engine.getBestScore()));
    }    
    
    public void slice1(){
        music();
        BufferedImage [] buffer = engine.getList().get(0).getBufferedImages();
        Image image = SwingFXUtils.toFXImage(buffer[1], null);
        image1.setImage(image);
        engine.getList().get(0).slice();
    }
    
    public void slice2(){
        BufferedImage [] buffer = engine.getList().get(1).getBufferedImages();
        Image image = SwingFXUtils.toFXImage(buffer[1], null);
        image2.setImage(image);
        engine.getList().get(1).slice();
        music();
    }
    
    public void slice3(){
        BufferedImage [] buffer = engine.getList().get(2).getBufferedImages();
        Image image = SwingFXUtils.toFXImage(buffer[1], null);
        image3.setImage(image);
        engine.getList().get(2).slice();
        music();
    }
    
    public void slice4(){
        BufferedImage [] buffer = engine.getList().get(3).getBufferedImages();
        Image image = SwingFXUtils.toFXImage(buffer[1], null);
        image4.setImage(image);
        engine.getList().get(3).slice();
        music();
    }
    
    public void slice5(){
        BufferedImage [] buffer = engine.getList().get(4).getBufferedImages();
        Image image = SwingFXUtils.toFXImage(buffer[1], null);
        image5.setImage(image);
        engine.getList().get(4).slice();
        music();
    }
    
    public void click(){
        instructionsimage.setVisible(false);
        instructionslbl.setVisible(false);
        clock();
        animation();
        time();
    }
    
    public void unsetImages(){
        image1.setVisible(false);
        image2.setVisible(false);
        image3.setVisible(false);
        image4.setVisible(false);
        image5.setVisible(false);
    }
    
    public void setImages(){
        switch (engine.getList().size()) {
            case 1:{
                setImage(engine.getList().get(0).getBufferedImages(),1);
                image1.setVisible(true);
            }break;
            case 2:{
                setImage(engine.getList().get(0).getBufferedImages(),1);
                setImage(engine.getList().get(1).getBufferedImages(),2);
                image1.setVisible(true);
                image2.setVisible(true);
            }break;
            case 3:{
                setImage(engine.getList().get(0).getBufferedImages(),1);
                setImage(engine.getList().get(1).getBufferedImages(),2);
                setImage(engine.getList().get(2).getBufferedImages(),3);
                image1.setVisible(true);
                image2.setVisible(true);
                image3.setVisible(true);
            }break;
            case 4:{
                setImage(engine.getList().get(0).getBufferedImages(),1);
                setImage(engine.getList().get(1).getBufferedImages(),2);
                setImage(engine.getList().get(2).getBufferedImages(),3);
                setImage(engine.getList().get(3).getBufferedImages(),4);
                image1.setVisible(true);
                image2.setVisible(true);
                image3.setVisible(true);
                image4.setVisible(true);
            }break;
            case 5:{
                setImage(engine.getList().get(0).getBufferedImages(),1);
                setImage(engine.getList().get(1).getBufferedImages(),2);
                setImage(engine.getList().get(2).getBufferedImages(),3);
                setImage(engine.getList().get(3).getBufferedImages(),4);
                setImage(engine.getList().get(4).getBufferedImages(),5);
                image1.setVisible(true);
                image2.setVisible(true);
                image3.setVisible(true);
                image4.setVisible(true);
                image5.setVisible(true);
            }break;
        }
    }
    
    public void setImage(BufferedImage [] buffer,int switchcase){
        Image image = SwingFXUtils.toFXImage(buffer[0], null);
        switch (switchcase) {
            case 1:{
                image1.setImage(image);
            }break;
            case 2:
                image2.setImage(image);
                break;
            case 3:
                image3.setImage(image);
                break;    
            case 4:
                image4.setImage(image);
                break;
            case 5:
                image5.setImage(image);
                break;
        }
    }
    
    public void decLive(){
        if (FruitNinja.mode == 0){
       int l = engine.getLives();
            if (l==2)
                live1lbl.setTextFill(Color.web("#D3D3D3"));
            if (l==1){
                live1lbl.setTextFill(Color.web("#D3D3D3"));
                live2lbl.setTextFill(Color.web("#D3D3D3"));
            }
            if(l<=0){
                live1lbl.setTextFill(Color.web("#D3D3D3"));
                live2lbl.setTextFill(Color.web("#D3D3D3"));
                live3lbl.setTextFill(Color.web("#D3D3D3"));
            }
        }
    }
    
    public void clock(){
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        KeyFrame Timeframe = new KeyFrame(Duration.seconds(1),new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(engine.gameover() && FruitNinja.mode == 0)
                    time.stop();
                else if(second ==59 && FruitNinja.mode == 1)
                    time.stop();
                 second++;
                if (second==60){
                    miniute++;
                    second=0;
                }
                if (miniute<10){
                    if (second<10)
                        timelbl.setText("0"+miniute+":"+"0"+second);
                    else timelbl.setText("0"+miniute+":"+second);
                }
                else {
                    if (second<10)
                        timelbl.setText(miniute+":"+"0"+second);
                    else timelbl.setText(miniute+":"+second);
                }
            }
        });
        time.getKeyFrames().add(Timeframe);
        time.playFromStart();
    }
    
    public void updateimagesposition(){
        switch (engine.getList().size()) {
            case 1:{
                image1.setLayoutX(engine.getList().get(0).getXlocation());
                image1.setLayoutY(engine.getList().get(0).getYlocation());
                engine.getList().get(0).move(2);
            }break;
            case 2:{
                image1.setLayoutX(engine.getList().get(0).getXlocation());
                image1.setLayoutY(engine.getList().get(0).getYlocation());
                image2.setLayoutX(engine.getList().get(1).getXlocation());
                image2.setLayoutY(engine.getList().get(1).getYlocation());
                engine.getList().get(0).move(2);
                engine.getList().get(1).move(2);
            }break;
            case 3:{
                image1.setLayoutX(engine.getList().get(0).getXlocation());
                image1.setLayoutY(engine.getList().get(0).getYlocation());
                image2.setLayoutX(engine.getList().get(1).getXlocation());
                image2.setLayoutY(engine.getList().get(1).getYlocation());
                image3.setLayoutX(engine.getList().get(2).getXlocation());
                image3.setLayoutY(engine.getList().get(2).getYlocation());
                engine.getList().get(0).move(2);
                engine.getList().get(1).move(2);
                engine.getList().get(2).move(2);
            }break;
            case 4:{
                image1.setLayoutX(engine.getList().get(0).getXlocation());
                image1.setLayoutY(engine.getList().get(0).getYlocation());
                image2.setLayoutX(engine.getList().get(1).getXlocation());
                image2.setLayoutY(engine.getList().get(1).getYlocation());
                image3.setLayoutX(engine.getList().get(2).getXlocation());
                image3.setLayoutY(engine.getList().get(2).getYlocation());
                image4.setLayoutX(engine.getList().get(3).getXlocation());
                image4.setLayoutY(engine.getList().get(3).getYlocation());
                engine.getList().get(0).move(2);
                engine.getList().get(1).move(2);
                engine.getList().get(2).move(2);
                engine.getList().get(3).move(2);
            }break;
            case 5:{
                image1.setLayoutX(engine.getList().get(0).getXlocation());
                image1.setLayoutY(engine.getList().get(0).getYlocation());
                image2.setLayoutX(engine.getList().get(1).getXlocation());
                image2.setLayoutY(engine.getList().get(1).getYlocation());
                image3.setLayoutX(engine.getList().get(2).getXlocation());
                image3.setLayoutY(engine.getList().get(2).getYlocation());
                image4.setLayoutX(engine.getList().get(3).getXlocation());
                image4.setLayoutY(engine.getList().get(3).getYlocation());
                image5.setLayoutX(engine.getList().get(4).getXlocation());
                image5.setLayoutY(engine.getList().get(4).getYlocation());
                engine.getList().get(0).move(2);
                engine.getList().get(1).move(2);
                engine.getList().get(2).move(2);
                engine.getList().get(3).move(2);
                engine.getList().get(4).move(2);

            }break;
        }
    }
    
    void animation(){
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        KeyFrame frame = new KeyFrame(Duration.millis(13),new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {
                    updateimagesposition();
                    updateScore();
                    decLive();
                    if(engine.gameover() && FruitNinja.mode == 0){
                    time.stop();
                    engine.endGame();
                    }
                    else if(second ==59 && FruitNinja.mode == 1){
                    time.stop();
                    engine.endGame();
                    }
                }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();
        
    }

    void time(){
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        KeyFrame frame = new KeyFrame(Duration.millis(3500),new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {
                    creation();
                }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();
    }
    
    void creation(){
        engine.algorithm();
        engine.getList().clear();
        Random random = new Random();
        int rand = random.nextInt(FruitNinja.difficulty+2)+1;
        unsetImages();
        for (int i =0;i<rand;i++)
            engine.CreateGameObject();
        setImages();
    }
    
    void updateScore(){
        score.setText(Integer.toString(engine.getScore()));
    }
    
    void music(){
      /*  File file = new File("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\FruitNinja\\src\\audio\\slice.wav");
        URL url = null;
        if (file.canRead()) {try {
            url = file.toURI().toURL();
            } catch (MalformedURLException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        java.applet.AudioClip clip = Applet.newAudioClip(url);
        clip.play();
    */}
}
