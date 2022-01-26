package Core;

import GameObjects.GameObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    private GameHandler gameHandler;
    public Controller(GameHandler gameHandler){
        this.gameHandler = gameHandler;
     }
    @Override
    public void keyTyped(KeyEvent e) {
        for (GameObject gameObject: gameHandler.getGameObjectList()){
            gameObject.KeyPress(e.getKeyChar());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
