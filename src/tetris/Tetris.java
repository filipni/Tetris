package tetris;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import static tetris.Constants.*;

public class Tetris extends Application {
    
    
    @Override
    public void start(Stage theStage) throws Exception
    {       
        // JavaFX setup 
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);
        
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        theStage.setTitle("Tetris");
        
        InputHandler input = new InputHandler(theScene);
        
        // Game loop
        Level board = new Level(input, gc);              
        new AnimationTimer()
        {
            private int animCounter = 0;
            @Override
            public void handle(long now)
            {               
                if (animCounter % FRAMES_PER_UPDATE == 0)
                {
                    board.update();
                    animCounter = 0;
                }
                ++animCounter;
            }
        }.start();  
            
        theStage.show();
    }

    public static void main(String[] args) {
        launch(args);       
    }
    
}
