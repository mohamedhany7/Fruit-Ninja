package Controller;

import Controller.GameActions;
import Model.Files;
import Model.GameObject;
import Model.ObjectFactory;
import java.util.List;
import java.util.Random;
import javafx.scene.control.Alert;


public class GameEngine implements GameActions{
    
    private static GameEngine instance;
    private GameObject obj;
    private int speed = FruitNinja.difficulty*20;
    private int score=0;
    private int bestScore=0;
    private int lives=3;
    private boolean lost = false;

    private GameEngine() { 
    }
    
    public static GameEngine getInstance (){
        if (instance == null)
        instance = new GameEngine();
        return instance;
    }


    public int getBestScore() {
        return bestScore;
    }
    
    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }
    
    
    @Override
    public void CreateGameObject() {
        Random rand = new Random();
        int x = rand.nextInt(7)+1;
        ObjectFactory factory = new ObjectFactory();
        obj = factory.createNewObject(x);
        list.add(obj);
    }

    @Override
    public List<GameObject> getList(){
                return list;
    }
    
    @Override
    public void updateObjectsLocation() {
                obj.move(speed);
    }

    @Override
    public void sliceObjects() {
       for(int i =0; i<list.size();i++)
                if(obj.isSliced()){
                    if (obj.getObjectType() == GameObject.type.Fruit)
                    updateScore(1);
                    if (obj.getObjectType() == GameObject.type.SpecialFruit)
                        updateScore(2);
                    if (obj.getObjectType() == GameObject.type.DangerousBomb)
                        decrementLive();
                    if (obj.getObjectType() == GameObject.type.FatalBomb)
                        lost();
                }
    }
    
    @Override
    public void updateScore(int inc)
    {
        switch (inc) {
            case 1:
                score++;
                break;
            case 2:
                score+=2;
                break;
        }
    }
    
    @Override
    public void decrementLive(){
        lives--;
        if (lives<0)
            lost();
    }
    
    @Override
    public void lost(){
        lost = true;
    }
    
    @Override
    public boolean gameover(){
        return lost;
    }
    
    public void algorithm(){
        for(int i =0; i<list.size();i++){
            if(list.get(i).isSliced()){
                    if (list.get(i).getObjectType() == GameObject.type.Fruit)
                        updateScore(1);
                    if (list.get(i).getObjectType() == GameObject.type.SpecialFruit)
                        updateScore(2);
                    if (list.get(i).getObjectType() == GameObject.type.DangerousBomb)
                        decrementLive();
                    if (list.get(i).getObjectType() == GameObject.type.FatalBomb)
                        lost();
            }
            else{
                if(list.get(i).haveMovedOffScreen())
                    if ((list.get(i).getObjectType() == GameObject.type.Fruit || list.get(i).getObjectType() == GameObject.type.SpecialFruit))
                        decrementLive();
            }
        }
    }
    
    public void endGame(){
        saveScore();
        if (FruitNinja.mode == 0){
        if(score<bestScore){
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Game Ended");
                alert.setContentText("You Have Lost");
                alert.show();
        }
        else{
            Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Game Ended");
                alert.setContentText("You Beated The Best Score!");
                alert.show();
        }
        }
        else{
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
                alert.setHeaderText("Game Ended");
                alert.setContentText("Your Score: " + score + "!");
                alert.show();
        } 
    }
    
    public void loadScore(){
        Files F = new Files();
        F.openRead();
        bestScore = F.read();
    }
    
    public void saveScore(){
        if (score>bestScore){
            Files F = new Files();
            F.openWrite();
            F.write(score);
        }
    }
}
