package GameObjects;

public class GameObjectSize {
    private int width, height;
    public GameObjectSize(int width, int height){
        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
