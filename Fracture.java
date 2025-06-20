import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Fracture extends PApplet{

    Player player;
    HashMap<String, PImage[]> playerAnimations = new HashMap<>();
    PImage[] playerIdle = new PImage[1];
    PImage[] playerJump = new PImage[1]; 
    PImage[] playerAttack = new PImage[4];
    PImage[] playerRun = new PImage[4];

    public void settings() {
        size(500, 500);
        noSmooth();
    }

    public void setup() {
        player = new Player(width / 2f, height / 2f, this, playerAnimations);

        playerIdle[0] = loadImage("player/idle.png");
        playerAnimations.put("idle", playerIdle);

        playerJump[0] = loadImage("player/jump.png");
        playerAnimations.put("jump", playerJump);

        for (int i = 0; i < playerAttack.length; i++) {
            playerAttack[i] = loadImage("player/attack" + (i + 1) + ".png");
        }
        playerAnimations.put("attack", playerAttack);

        for (int i = 0; i < playerRun.length; i++) {
            playerRun[i] = loadImage("player/run" + (i + 1) + ".png");
        }
        playerAnimations.put("run", playerRun);
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
