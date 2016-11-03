package tetris;

import java.util.Random;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import static tetris.Constants.*;

abstract public class Block {  
    
    Tuple pos;
    Tuple prevPos;
    
    Color color;
    
    final char[][][] shapes;
    char[][] shape;
    char[][] prevShape;
    int currentShape;
        
    public Block(char[][][] shapes, Color c)
    {
        Random randomGen = new Random();
        
        this.shapes = shapes;
        currentShape = 0; 
        shape = shapes[currentShape];
        
        color = c;
        
        int x = randomGen.nextInt((COLUMNS - 2 * BORDER - SHAPE_SIZE + 1)) + FIRST_COL; 
        int y = FIRST_ROW;     
        pos = new Tuple(x, y);   
    }
    
    public void move(KeyCode code)
    {
        prevPos = new Tuple(pos);
        prevShape = shape;
        
        if (null != code)
            switch (code)
        {
            case UP:
                // Rotate
                currentShape = (currentShape + 1) % shapes.length;
                shape = shapes[currentShape];
                break;
            case DOWN:
                ++pos.y;
                break;
            case LEFT:
                --pos.x;
                break;
            case RIGHT:
                ++pos.x;
                break;
        }
    }
    
    public void moveVertically()
    {
        move(KeyCode.DOWN);
    }
    
    public void moveBack()
    {
        pos = new Tuple(prevPos);
        shape = prevShape;
    }
       
}
