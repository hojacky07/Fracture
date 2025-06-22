import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Fracture extends PApplet{

    Player player;
    PlayerHitbox playerHitbox;
    HashMap<String, PImage[]> playerAnimations = new HashMap<>();
    Background background;
    PImage[] playerIdle = new PImage[1];
    PImage[] playerJump = new PImage[1]; 
    PImage[] playerAttack = new PImage[4];
    PImage[] playerRun = new PImage[4];

    public void settings() {
        size(640, 360);
        noSmooth();
    }

    public void setup() {
        playerHitbox = new PlayerHitbox(23 - 22, height / 2f, this);
        player = new Player(23, height / 2f, this, playerAnimations, playerHitbox);

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

        background = new Background(this);
    }

    public void draw() {
        playerHitbox.update(background.offsetX);
        playerHitbox.display();
        background.update(playerHitbox.x,playerHitbox.leftScroll, playerHitbox.rightScroll);
        background.display();
        player.update();
        player.display();
    }

    public void keyPressed() {
        playerHitbox.keyPressed(key, keyCode);
        if (key == 'q' || key == 'Q') {
           System.out.println(background.offsetX);
        }
    }

    public void keyReleased() {
        playerHitbox.keyReleased(key, keyCode);
    }
}
