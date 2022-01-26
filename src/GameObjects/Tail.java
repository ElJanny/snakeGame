package GameObjects;

import java.awt.*;

public class Tail extends GameObject implements GameObjectMethods{

    // 0 előtte, 1 mögötte
    private GameObject[] neighbors = new GameObject[2];
    private int nextX, nextY;
    public Tail(Position position, GameObjectSize gameObjectSize, Type type) {
        super(position, gameObjectSize, type);
    }

    public void setBefore(GameObject gameObject){
        this.neighbors[0] = gameObject;
    }

    public void setAfter(GameObject gameObject){
        this.neighbors[1] = gameObject;
    }

    private void setNextPosition(){
        if(neighbors[0]!=null){
            this.nextX = neighbors[0].getPosition().getX();
            this.nextY = neighbors[0].getPosition().getY();
        }
    }

    @Override
    public void KeyPress(char keyCode) {}

    @Override
    public void Update() {
        this.getPosition().setY(this.nextY);
        this.getPosition().setX(this.nextX);
    }

    @Override
    public void CheckCollision() {}

    @Override
    public void DetectCollision(GameObject gameObject) {}

    @Override
    public void FixedUpdate() {
        this.setNextPosition();
    }

    @Override
    public void DrawObject(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(this.getPosition().getX(),this.getPosition().getY(),this.getGameObjectSize().getWidth(),this.getGameObjectSize().getHeight());
    }
}
