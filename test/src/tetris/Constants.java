package tetris;

public class Constants {
    
    // Misc.
    static final int BLOCK_SIDE = 30; // Size of tile side in pixels
    static final int NUM_BLOCKS = 7;   // Number of blocks to choose from
    static final int FRAMES_PER_DROP = 10; // Frames before moving block vertically down
       
    // Define the grid
    static final int SHAPE_SIZE = 4; // Each block is defined in a square box with this side
    static final int BORDER = SHAPE_SIZE;
    static final int GRID_WIDTH = 10;
    static final int GRID_HEIGHT = 20;
    static final int COLUMNS = GRID_WIDTH + BORDER * 2;
    static final int ROWS = GRID_HEIGHT + BORDER * 2;
    
    static final int FIRST_ROW = BORDER;
    static final int LAST_ROW = ROWS - BORDER - 1;
    
    static final int FIRST_COL = BORDER;
    static final int LAST_COL = COLUMNS - BORDER - 1;
    
    // Window dimensions and update frequency
    static final int WIDTH = GRID_WIDTH * BLOCK_SIDE;
    static final int HEIGHT =  GRID_HEIGHT * BLOCK_SIDE;
    static final int FRAMES_PER_UPDATE = 6;
     
}
