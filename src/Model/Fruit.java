package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;


public class Fruit implements GameObject{
    
    private BufferedImage [] image = new BufferedImage[2];
    private Random rand = new Random();
    private int rand1 = rand.nextInt(400);
    private int x = 150+rand1;
    private int y = 500;
    private boolean sliced= false;
    private int direction = 0;

    public Fruit(int x) {
         switch (x){
            case 1: {try {
                            image [0] = ImageIO.read(new File(url+"orange1.png"));
                            image [1] = ImageIO.read(new File(url+"orange2.png"));
                            
                        } catch (IOException e) {
                        }
                    }break;
            case 2: {try {
                            image [0] = ImageIO.read(new File(url+"peach1.png"));
                            image [1] = ImageIO.read(new File(url+"peach2.png"));
                        } catch (IOException e) {
                        }
                    }break;
            case 3: {try {
                            image [0] = ImageIO.read(new File(url+"pomegranate1.png"));
                            image [1] = ImageIO.read(new File(url+"pomegranate2.png"));
                        } catch (IOException e) {
                        }
                    }break;
    }
    }
    
    @Override
    public type getObjectType(){
        return type.Fruit;
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
        if (y > getMaxHeight() && direction == 0){
            y-=2*speed;
            x+=0.75*speed;
        }
        else {
            direction = 1;
            y+=2*speed;
            x+=0.5*speed;
        }
    }

    @Override
    public BufferedImage [] getBufferedImages() {
            return image;
    }
    
}
