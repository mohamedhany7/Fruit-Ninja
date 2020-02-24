package Model;

public class ObjectFactory {
    
    public GameObject createNewObject(int x){
        GameObject obj = null;
        switch (x) {
            case 1:
                obj = new Fruit(1);
                break;
            case 2:
                obj = new Fruit(2);
                break;
            case 3:
                obj = new Fruit(3);
                break;
            case 4:
                obj = new SpecialFruit(1);
                break;
            case 5:
                obj = new SpecialFruit(2);
                break;
            case 6:
                obj = new Bomb(1);
                break;
            case 7:
                obj = new Bomb(2);
                break;
        }
        return obj;
    }
    
}
