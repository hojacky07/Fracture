import java.util.HashMap;
import processing.core.PApplet;
import processing.core.PImage;

public class Player {
    float x, y;
    boolean left, right;
    String direction = "";


    float vy = 0;
    float gravity = 0.5f;
    boolean onGround = false;

    PApplet player;

    HashMap<String, PImage[]> playerAnimations;
    String currentState = "idle";
    int frame = 0;
    int frameDelay = 5;
    int frameCounter = 0;

    PlayerHitbox playerHitbox;
    

    public Player(float x, float y, PApplet player, HashMap<String, PImage[]> playerAnimations, PlayerHitbox playerHitbox) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.playerAnimations = playerAnimations;
        this.playerHitbox = playerHitbox;
    }

    public void update() {

        if (!onGround) {
            setState("jump");
        } else if ((left || right) && onGround) {
            setState("run");
        } else {
            setState("idle");
        }

        PImage[] frames = playerAnimations.get(currentState);
        if (frames.length > 1) {
            frameCounter++;
            if (frameCounter >= frameDelay) {
                frameCounter = 0;
                frame = (frame + 1) % frames.length;
            }
        } else {
            frame = 0;
        }
    }

    public void display() {

        x = playerHitbox.x + 22;
        y = playerHitbox.y + 14;
        this.direction = playerHitbox.direction;
        this.onGround = playerHitbox.onGround;
        this.left = playerHitbox.left;
        this.right = playerHitbox.right;

        player.imageMode(PApplet.CENTER);
        PImage currentFrame = playerAnimations.get(currentState)[frame];

        player.pushMatrix();
        player.translate(x, y);

        if (direction == "left") {
            player.translate(-30, 0);
            player.scale(-0.5f, 0.5f); 
            player.image(currentFrame, 0, 0);
        } else {
            player.scale(0.5f);
            player.image(currentFrame, 0, 0);
        }

        player.popMatrix();
    }

    public void setState(String state) {
        if (!currentState.equals(state)) {
            currentState = state;
            frame = 0;
            frameCounter = 0;
        }
    }
}
