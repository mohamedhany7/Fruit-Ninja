package Controller;

import Model.GameObject;
import java.util.ArrayList;
import java.util.List;


public interface GameActions {
    
    public List<GameObject> list = new ArrayList<>();
    
    enum type {
        Fruit,
        FatalBomb,
        DangerousBomb,
        SpecialFruit
    }
    
    public void CreateGameObject();
    
    public List<GameObject> getList();
    
    public void updateObjectsLocation();
    
    public void sliceObjects();
    
    public void updateScore(int inc);
    
    public void decrementLive();
    
    public void lost();
    
    public boolean gameover();

}
