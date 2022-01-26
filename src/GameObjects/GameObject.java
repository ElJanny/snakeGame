package GameObjects;

import Core.GameHandler;

public abstract class GameObject implements GameObjectMethods {
    private Position position;
    private GameObjectSize gameObjectSize;
    protected GameHandler gameHandler = GameHandler.getInstance();
    private Type type;
    public GameObject(Position position, GameObjectSize gameObjectSize,Type type) {
        this.type = type;
        this.gameObjectSize = gameObjectSize;
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position,GameObjectSize gameObjectSize) {
        this.position = position;
        this.gameObjectSize = gameObjectSize;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public GameObjectSize getGameObjectSize() {
        return gameObjectSize;
    }

    public void setGameObjectSize(GameObjectSize gameObjectSize) {
        this.gameObjectSize = gameObjectSize;
    }
}
