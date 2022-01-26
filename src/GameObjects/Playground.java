package GameObjects;

import Core.GameHandler;

public class Playground {
    private GameObject[][] map = new GameObject[16][16];
    private GameHandler gameHandler = GameHandler.getInstance();
    private static Playground playGround;
    private Playground(){}

    public static Playground getInstance(){
        if(playGround == null) {
            playGround = new Playground();
        }
        return playGround;
    }

    public GameObject detectObjectOnMap(int x, int y){
        if((x/16 <16 && y/16 <16) && (x/16>=0 && y/16>=0)){
            return map[x/16][y/16];
        }else{
            return null;
        }
    }

    public void moveObjectOnMap(GameObject gameObject, int x, int y) {
        if((x/16 <16 && y/16 <16) && (x/16>=0 && y/16>=0)){
            this.map[x/16][y/16]= gameObject;
        }

    }

}
