package Graphics;

import Core.Controller;
import Core.GameHandler;
import GameObjects.GameObject;

import javax.swing.*;
import java.awt.*;

public class WindowComponent extends JPanel {

    private JFrame window;
    private GameHandler gameHandler;

    public WindowComponent(GameHandler gameHandler){
        this.makeWindow();
        this.gameHandler = gameHandler;
    }

    public void makeWindow(){
        this.window = new JFrame("My Snake Game");
        this.window.setSize(512,512);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setContentPane(this);
        this.window.setVisible(true);
        this.window.setFocusable(true);
    }

    public void addController(Controller controller){
        this.window.addKeyListener(controller);
    }


    public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       for(GameObject gameObject: this.gameHandler.getGameObjectList()){
           gameObject.DrawObject(g);
       }
    }

}
