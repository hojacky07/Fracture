import java.util.HashMap;
import processing.core.PApplet;
import processing.core.PImage;

public class Player {
    float x, y;
    float speed = 5;
    boolean up, down, left, right;

    PApplet player;

    HashMap<String, PImage[]> playerAnimations;
    String currentState = "idle";
    int frame = 0;
    int frameDelay = 5;
    int frameCounter = 0;

    public Player(float x, float y, PApplet player, HashMap<String, PImage[]> playerAnimations) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.playerAnimations = playerAnimations;
    }

    public void update() {
        if (up == true) {
            y -= speed;
        }
        if (down == true) {
            y += speed;
        }
        if (left == true) {
            x -= speed;
        }
        if (right == true) {
            x += speed;
        }

        x = player.constrain(x, 19 / 2, player.width - 19 / 2);
        y = player.constrain(y, 13 / 2, player.height - 13 / 2);

        if (up || down || left || right) {
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
        player.imageMode(PApplet.CENTER);
        PImage currentFrame = playerAnimations.get(currentState)[frame];

        player.pushMatrix();
        player.translate(x, y);

        if (left && !right) {
            player.translate(-64, 0);
            player.scale(-1, 1); 
            player.image(currentFrame, 0, 0);
        } else {
            player.image(currentFrame, 0, 0);
        }

        player.popMatrix();
    }

    public void keyPressed(char key, int keyCode) {
        if (key == PApplet.CODED) {
            if (keyCode == PApplet.UP) {
                up = true;
            }
            if (keyCode == PApplet.DOWN) {
                down = true;
            }
            if (keyCode == PApplet.LEFT) {
                left = true;
            }
            if (keyCode == PApplet.RIGHT) {
                right = true;
            }
        } else {
            if (key == 'w' || key == 'W') {
                up = true;
            }
            if (key == 's' || key == 'S') {
                down = true;
            }
            if (key == 'a' || key == 'A') {
                left = true;
            }
            if (key == 'd' || key == 'D') {
                right = true;
            }
        }
    }

    public void keyReleased(char key, int keyCode) {
        if (key == PApplet.CODED) {
            if (keyCode == PApplet.UP) {
                up = false;
            }
            if (keyCode == PApplet.DOWN) {
                down = false;
            }
            if (keyCode == PApplet.LEFT) {
                left = false;
            }
            if (keyCode == PApplet.RIGHT) {
                right = false;
            }
        } else {
            if (key == 'w' || key == 'W') {
                up = false;
            }
            if (key == 's' || key == 'S') {
                down = false;
            }
            if (key == 'a' || key == 'A') {
                left = false;
            }
            if (key == 'd' || key == 'D') {
                right = false;
            }
        }
    }

    public void setState(String state) {
        if (!currentState.equals(state)) {
            currentState = state;
            frame = 0;
            frameCounter = 0;
        }
    }
}
