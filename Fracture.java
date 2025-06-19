import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

public class Fracture extends PApplet{

    Player player;

    public void settings() {
        size(displayWidth, displayHeight);
    }

    public void setup() {
        player = new Player(width / 2f, height / 2f, 50, this);
    }

    public void draw() {
        background(200);
        player.update();
        player.display();
    }

    public void keyPressed() {
        player.keyPressed(key, keyCode);
    }

    public void keyReleased() {
        player.keyReleased(key, keyCode);
    }
}
