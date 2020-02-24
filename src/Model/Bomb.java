package Model;

import static Model.GameObject.url;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;



public class Bomb implements GameObject{
    
    private BufferedImage [] image = new BufferedImage[2];
    private Random rand = new Random();
    private int rand1 = rand.nextInt(400);
    private int x = rand1;
    private int y = 500;
    private boolean sliced= false;
    private int s;
    private int direction = 0;

    public Bomb(int x) {
         switch (x){
            case 1: {try {
                            image [0] = ImageIO.read(new File(url+"DangerousBomb.png"));
                            image [1] = ImageIO.read(new File(url+"boom.png"));
                            
                        } catch (IOException e) {
                        }
                    }break;
            case 2: {try {
                            image [0] = ImageIO.read(new File(url+"FatalBomb.png"));
                            image [1] = ImageIO.read(new File(url+"explosive.png"));
                        } catch (IOException e) {
                        }
                    }break;
    }
         s=x;
    }
    
    @Override
    public GameObject.type getObjectType(){
        if (s==1)
        return GameObject.type.DangerousBomb;
        else return type.FatalBomb;
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
            x+=1.25*speed;
        }
        else {
            direction = 1;
            y+=2*speed;
            x+=0.75*speed;
        }
    }

    @Override
    public BufferedImage [] getBufferedImages() {
            return image;
    }
    
}
