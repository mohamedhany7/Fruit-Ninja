package Model;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;


public class Files {
    
    private Formatter y;
    private Scanner x;
    
    
    public void openWrite() {
        try {
            y = new Formatter("score.txt");
        } catch (Exception e) {
            System.out.println("Error opening file");
        }
    }
    
    
    
    public void write(int score){
        y.format("%d",score);
        y.close();
    }
    
     public void openRead() {
        try {
            x = new Scanner(new File("score.txt"));
        } catch (Exception e) {
            System.out.println("Error opening file");
        }
    }

    public int read() {
        int a = 0;
        while (x.hasNext()) {
             a = Integer.parseInt(x.next());
        }
        x.close();
        return a;
    }
    
}
