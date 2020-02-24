package Model;


public class ObserverClass implements Observer{
    
    int score=0;
    
    @Override
    public int updateScore(GameObject obj) {
        if (obj.getObjectType() == GameObject.type.Fruit)
            score+=1;
        if (obj.getObjectType() == GameObject.type.SpecialFruit)
            score+=2;
        return score;
    }

    @Override
    public int reset() {
        score = 0;
        return score;
    }
    
}
