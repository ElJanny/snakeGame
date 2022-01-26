package Core;

import GameObjects.GameObject;

public class SecondThread extends Thread{

    private boolean isPlaying;
    private GameHandler gameHandler;
    public SecondThread(GameHandler gameHandler){
        this.gameHandler = gameHandler;
    }

    public void setIsPlaying(boolean isPlaying){
        this.isPlaying = isPlaying;
    }


    public void run() {
        while(this.isPlaying)
        {
            this.gameHandler.combineLists();
            this.gameHandler.clearTmpList();
            //Updatek
            for (GameObject gameObject : this.gameHandler.getGameObjectList())
            {
                gameObject.Update();
            }

            //Collision detection
            for (GameObject gameObject : this.gameHandler.getGameObjectList())
            {
                gameObject.CheckCollision();
            }

            //Fixed Update
            for (GameObject gameObject : this.gameHandler.getGameObjectList())
            {
                gameObject.FixedUpdate();
            }
            this.gameHandler.repaint();
            try {
                sleep(Math.round(1000/20));
            } catch (InterruptedException e) {
                this.isPlaying = false;
            }
        }
    }
}
