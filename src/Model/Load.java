package Model;


public class Load implements Command{

    @Override
    public int execute() {
        Files file = new Files();
        file.openRead();
        return file.read();
    }
    
}
