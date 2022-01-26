package GameObjects;

import java.awt.*;
import java.util.Random;

public class Coin extends GameObject{

    private Playground playground = Playground.getInstance();

    public Coin(Position position, GameObjectSize gameObjectSize, Type type){
        super(position, gameObjectSize, type);
    }

    @Override
    public void KeyPress(char keyCode) {}

    @Override
    public void Update() {}

    @Override
    public void CheckCollision() {
        GameObject gameObject = this.playground.detectObjectOnMap(this.getPosition().getX(),this.getPosition().getY());
        if (gameObject == null){
            this.playground.moveObjectOnMap(this, this.getPosition().getX(), this.getPosition().getY());
        }else{
            DetectCollision(gameObject);
        }
    }

    @Override
    public void DetectCollision(GameObject gameObject) {
       if(gameObject.getType() == Type.Head) respawn();
    }

    @Override
    public void FixedUpdate() {
        this.playground.moveObjectOnMap(this, this.getPosition().getX(), this.getPosition().getY());
    }

    @Override
    public void DrawObject(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.getPosition().getX(),this.getPosition().getY(),this.getGameObjectSize().getWidth(),this.getGameObjectSize().getHeight());
    }

    private void respawn(){
        Random random = new Random();
        int x = (random.nextInt(10)+1)*16;
        int y = (random.nextInt(10)+1)*16;
        this.getPosition().setX(x);
        this.getPosition().setY(y);
    }
}
