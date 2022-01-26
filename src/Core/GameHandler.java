package Core;

import GameObjects.*;
import Graphics.WindowComponent;

import java.util.LinkedList;

public class GameHandler {

    private static GameHandler INSTANCE;
    private String info = "Initial info class";
    private WindowComponent windowComponent;
    private SecondThread secondThread;
    private Controller controller;
    private LinkedList<GameObject> gameObjectList;
    private LinkedList<GameObject> tmpList;

    private GameHandler() {}

    public static GameHandler getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new GameHandler();
        }
        return INSTANCE;
    }

    public void startGame(){
        this.setStartingInstances();
        this.declareController();
        this.declareWindow();
        this.declareSecondThread();
    }

    public void endGame(){

    }

    private void setStartingInstances(){
        this.gameObjectList = new LinkedList<>();
        this.tmpList = new LinkedList<>();
        this.addObjectToObjectList(new Player(new Position(0,0), new GameObjectSize(16,16), Type.Head));
        this.addObjectToObjectList(new Coin(new Position(32,32), new GameObjectSize(16,16), Type.Score));
    }

    private void declareWindow(){
        this.windowComponent = new WindowComponent(INSTANCE);
        this.windowComponent.addController(this.controller);
    }

    private void declareSecondThread(){
        this.secondThread = new SecondThread(INSTANCE);
        this.secondThread.setIsPlaying(true);
        this.secondThread.start();
    }

    private void declareController(){
        this.controller = new Controller(INSTANCE);
    }

    public void repaint(){
        this.windowComponent.repaint();
    }

    public LinkedList<GameObject> getGameObjectList() {
        return gameObjectList;
    }

    public void addObjectToObjectList(GameObject gameObject){
        this.gameObjectList.add(gameObject);
    }

    public void setGameObjectList(LinkedList<GameObject> gameObjectList) {
        this.gameObjectList = gameObjectList;
    }

    public void combineLists() {
        this.gameObjectList.addAll(this.tmpList);
    }

    public void clearTmpList() {
        this.tmpList.clear();
    }

    public void addTmpList(GameObject gameObject){
        this.tmpList.add(gameObject);
    }
}
