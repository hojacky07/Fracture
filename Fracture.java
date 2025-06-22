import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Fracture extends PApplet{

    Player player;
    PlayerHitbox playerHitbox;
    HashMap<String, PImage[]> playerAnimations = new HashMap<>();
    PImage background;
    PImage[] playerIdle = new PImage[1];
    PImage[] playerJump = new PImage[1]; 
    PImage[] playerAttack = new PImage[4];
    PImage[] playerRun = new PImage[4];

    public void settings() {
        size(640, 360);
        noSmooth();
    }

    public void setup() {
        playerHitbox = new PlayerHitbox(width / 2f, height / 2f, this);
        player = new Player(width / 2f, height / 2f, this, playerAnimations, playerHitbox);

        background = loadImage("background/background.png");

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
        playerHitbox.update();
        playerHitbox.display();
        background(background);
        player.update();
        player.display();
    }

    public void keyPressed() {
        playerHitbox.keyPressed(key, keyCode);
    }

    public void keyReleased() {
        playerHitbox.keyReleased(key, keyCode);
    }
}
