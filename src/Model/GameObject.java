package Model;

import java.awt.image.BufferedImage;

public interface GameObject {
    
    String url = "C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\FruitNinja\\src\\images\\";

    enum type {
        Fruit,
        FatalBomb,
        DangerousBomb,
        SpecialFruit
    }
    
    public type getObjectType();
    
    public int getXlocation();
    
    public int getYlocation();
    
    public int getMaxHeight();
     
    public boolean isSliced();
    
    public boolean haveMovedOffScreen();
    
    public void slice();
    
    public void move(int speed);
    
    public BufferedImage[] getBufferedImages();
}
