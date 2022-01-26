package GameObjects;
import java.awt.*;
import java.util.LinkedList;

public class Player extends GameObject {

    private final int SPEED = 16;
    private int[] direction = {0,0};
    private LinkedList<GameObject> tails = new LinkedList<>();
    private Playground playground = Playground.getInstance();
    public Player(Position position,GameObjectSize gameObjectSize,Type type){

        super(position,gameObjectSize,type);
        tails.add(this);
    }

    @Override
    public void KeyPress(char keyCode) {
        switch (keyCode) {
            case 'a':
                if (this.tails.size()<2 || this.direction[0] != 1)
                    this.setDirection(-1,0);
                break;
            case 'd':
                if (this.tails.size()<2 || this.direction[0] != -1)
                    this.setDirection(1,0);
                break;
            case 'w':
                if (this.tails.size()<2 || this.direction[1] != 1)
                    this.setDirection(0,-1);
                break;
            case 's':
                if (this.tails.size()<2 || this.direction[1] != -1)
                    this.setDirection(0,1);
                break;
        }
    }

    @Override
    public void Update() {
        this.moving(this.getPosition());
    }

    @Override
    public void CheckCollision() {
        GameObject gameObject = this.playground.detectObjectOnMap(this.getPosition().getX(),this.getPosition().getY());
        if (gameObject == null){
            this.playground.moveObjectOnMap(this, this.getPosition().getX(), this.getPosition().getY());
        }else {
            DetectCollision(gameObject);
        }
    }

    @Override
    public void DetectCollision(GameObject gameObject) {

        if(gameObject.getType() == Type.Score){
            this.grow();
            gameObject.DetectCollision(this);
        }
    }

    @Override
    public void FixedUpdate() {
        this.playground.moveObjectOnMap(this, this.getPosition().getX(), this.getPosition().getY());
    }

    @Override
    public void DrawObject(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(this.getPosition().getX(),this.getPosition().getY(), getGameObjectSize().getWidth(), getGameObjectSize().getHeight());
    }

    private void setDirection(int horizontal, int vertical){
        this.direction[0]=horizontal;
        this.direction[1]=vertical;
    }

    private void moving(Position position){
        position.setX(position.getX()+(this.direction[0]*this.SPEED));
        position.setY(position.getY()+(this.direction[1]*this.SPEED));
    }

    private void grow(){
      GameObject last = this.tails.getLast();

       Position tmpPosition = new Position(900,900);
       Tail tmpTail = new Tail(tmpPosition,new GameObjectSize(16,16),Type.BodyPart);
       tmpTail.setBefore(last);
       tmpTail.setAfter(null);
       this.tails.add(tmpTail);
       this.gameHandler.addTmpList(tmpTail);
    }
}
