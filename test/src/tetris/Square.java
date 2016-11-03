package tetris;

import javafx.scene.paint.Color;

public class Square extends Block 
{   
    public Square()
    {
        super(new char[][][] 
        {
            {
                {'*', '*','_','_'}, 
                {'*', '*','_','_'},
                {'_', '_','_','_'},
                {'_', '_','_','_'}
            }
        }
                , Color.YELLOW);
    }
}
