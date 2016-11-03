package tetris;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputHandler {
    
    private final Scene focus;
    private KeyCode input;
    
    public InputHandler(Scene scene) 
    {
        focus = scene;
        
        focus.setOnKeyPressed((KeyEvent e) ->
        {
            input = e.getCode();
        });
        
        focus.setOnKeyReleased((KeyEvent e) ->
        {
            KeyCode code = e.getCode();
            if (code == KeyCode.LEFT || code == KeyCode.RIGHT || code == KeyCode.DOWN || code == KeyCode.UP)
                input = null;
        });
    }
    
    public KeyCode getInput()
    {
        return input;
    }
}
