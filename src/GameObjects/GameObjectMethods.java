package GameObjects;

import java.awt.*;

public interface GameObjectMethods {
     void KeyPress(char keyCode);
     void Update();
     void CheckCollision();
     void DetectCollision(GameObject gameObject);
     void FixedUpdate();
     void DrawObject(Graphics g);
}
