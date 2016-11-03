package tetris;

import javafx.scene.canvas.GraphicsContext;
import java.util.Arrays;
import java.util.Random;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import static tetris.Constants.*;

public final class Level {  
    
    /* TODO:
        * Game over when reaching the top
    */
      
    private final InputHandler INPUT;
    private final GraphicsContext GC;
    
    private int frameCounter;
    private boolean activeBlock;
    private Block b;
    
    private Color[][] levelArray;
    private final Color[][] buffer;
    
    public void update()
    {
        ++frameCounter;
        if (!activeBlock)
        {
            b = getBlock();
            activeBlock = true;
        }
        else
        {
            removeCompleteRows();
            KeyCode code = INPUT.getInput();
            
            b.move(code);
            if (notValidBlockPos())
                b.moveBack();
            
            if (frameCounter % FRAMES_PER_DROP == 0)
            {
                frameCounter = 0;
                b.moveVertically();
                if (notValidBlockPos())
                {
                    activeBlock = false;
                    b.moveBack();
                    placeBlock(levelArray);                 
                }
            }
        }        
        copyToBuffer();
        drawLevel();        
    }
    
    private void removeCompleteRows()
    {
        Color[][] updated = getEmptyLevel();
        int index = LAST_ROW; // Begin from the bottom row
        for (int j = LAST_ROW; j >= FIRST_ROW; --j)
        {
            for (int i = FIRST_COL; i <= LAST_COL; ++i)
            {
                if (levelArray[j][i] == null) // See if we have an empty tile in the current row...
                {
                    updated[index--] = levelArray[j]; // ... if so, transfer row to updated array
                    break;
                }
            }
        }
        levelArray = updated;
    }
    
    private boolean notValidBlockPos() 
    {
        for (int i = 0; i < SHAPE_SIZE; ++i)
        {
            for (int j = 0; j < SHAPE_SIZE; ++j)
            {
                if (levelArray[b.pos.y + i][b.pos.x + j] != null
                        && b.shape[i][j] == '*')
                    return true;
            }
        }
        return false;
    }
    
    private void placeBlock(Color[][] board)
    {
        for (int i = 0; i < SHAPE_SIZE; ++i) 
        {
            for (int j = 0; j < SHAPE_SIZE; ++j)
            {
                if (b.shape[i][j] == '*')
                {
                    board[b.pos.y + i][b.pos.x + j] = b.color; 
                }
            }
        }
    }
            
    private void drawLevel() 
    {
        // Clear screen
        GC.setFill(Color.ALICEBLUE);
        GC.fillRect(0, 0, WIDTH, HEIGHT);
        
        // Draw the grid
        for (int i = 0; i < GRID_HEIGHT; ++i) 
        {
            for (int j = 0; j < GRID_WIDTH; ++j)
            {               
                Color currentColor = buffer[i + BORDER][j + BORDER]; // Offset from the border so we only draw the grid
                // Fill the squares where we have a block
                if (currentColor != null)
                {
                    GC.setFill(currentColor);
                    GC.fillRect(j * BLOCK_SIDE, i * BLOCK_SIDE, BLOCK_SIDE, BLOCK_SIDE);         
                }
                
                GC.setStroke(Color.BLACK);
                GC.strokeRect(j * BLOCK_SIDE, i * BLOCK_SIDE, BLOCK_SIDE, BLOCK_SIDE);
            }
        }
    }
    
    private void copyToBuffer()
    {
        for (int i = 0; i < levelArray.length; ++i)
        {
            buffer[i] = Arrays.copyOf(levelArray[i], COLUMNS);
        }
        placeBlock(buffer);     
    }
    
    private Color[][] getEmptyLevel() 
    {
        Color[][] level = new Color[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; ++i)
        {
            for (int j = 0; j < COLUMNS; ++j)
            {
                if (i < FIRST_ROW || j < FIRST_COL || i > LAST_ROW || j > LAST_COL)
                    level[i][j] = Color.BLACK;
            }
        }
        return level;
    }
    
    private Block getBlock()
    {
        Random rand = new Random();
        int blockNum = rand.nextInt(NUM_BLOCKS);
        switch (blockNum)
        {
            case 0:
                return new Line();
            case 1:
                return new Square();
            case 2:
                return new TShape();
            case 3:
                return new LeftSquiggle();
            case 4:
                return new RightSquiggle();               
            case 5:
                return new LeftLBlock();
            default:
                return new RightLBlock();
        }
    }
    
    public Level(InputHandler in,  GraphicsContext gc) 
    {   
        INPUT = in;
        GC = gc;
        buffer = getEmptyLevel();
        levelArray = getEmptyLevel();
    }
    
}
