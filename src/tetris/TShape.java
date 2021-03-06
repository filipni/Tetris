package tetris;

import javafx.scene.paint.Color;

public class TShape extends Block 
{
    public TShape()
    {
        super(new char[][][] 
        {
            {
                {'_', '*', '_', '_'},
                {'*', '*', '*', '_'}, 
                {'_', '_', '_', '_'},
                {'_', '_', '_', '_'}
            },
            {
                {'_', '*', '_', '_'},
                {'_', '*', '*', '_'}, 
                {'_', '*', '_', '_'},
                {'_', '_', '_', '_'}
            },
            {
                {'_', '_', '_', '_'},
                {'*', '*', '*', '_'}, 
                {'_', '*', '_', '_'},
                {'_', '_', '_', '_'}
            },
            {
                {'_', '*', '_', '_'},
                {'*', '*', '_', '_'}, 
                {'_', '*', '_', '_'},
                {'_', '_', '_', '_'}
            }
        }
                , Color.DARKORCHID);
    }
}
