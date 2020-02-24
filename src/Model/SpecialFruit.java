package Model;

import static Model.GameObject.url;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;



public class SpecialFruit implements GameObject{
    
    private BufferedImage [] image = new BufferedImage[2];
    private Random rand = new Random();
    private int rand1 = rand.nextInt(400);
    private int x = 600-rand1;
    private int y = 500;
    private boolean sliced= false;
    private int direction = 0;

    public SpecialFruit(int x) {
         switch (x){
            case 1: {try {
                            image [0] = ImageIO.read(new File(url+"guava1.png"));
                            image [1] = ImageIO.read(new File(url+"guava2.png"));
                            
                        } catch (IOException e) {
                        }
                    }break;
            case 2: {try {
                            image [0] = ImageIO.read(new File(url+"apple1.png"));
                            image [1] = ImageIO.read(new File(url+"apple2.png"));
                        } catch (IOException e) {
                        }
                    }break;
    }
    }
    
    @Override
    public GameObject.type getObjectType(){
        return GameObject.type.SpecialFruit;
    }

    @Override
    public int getXlocation() {
        return x;
    }

    @Override
    public int getYlocation() {
        return y;
    }

    @Override
    public int getMaxHeight() {
        return 50;
    }

    @Override
    public boolean isSliced() {
       return sliced;
    }

    @Override
    public boolean haveMovedOffScreen() {
        if (y>500)
            return true;
        else return false;
    }

    @Override
    public void slice() {
        sliced = true;
    }

    @Override
    public void move(int speed) {
        if (y > getMaxHeight()&& direction == 0){
            y-=3*speed;
            x-=0.75*speed;
        }
        else {
            direction = 1;
            y+=3*speed;
            x-=0.5*speed;
        }
    }

    @Override
    public BufferedImage [] getBufferedImages() {
            return image;
    }
    
}
