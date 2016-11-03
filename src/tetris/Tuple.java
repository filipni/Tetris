package tetris;

public class Tuple {
    public int x;
    public int y;
    
    public Tuple(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Tuple(Tuple t)
    {
        x = t.x;
        y = t.y;
    }
}
