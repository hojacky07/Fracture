import java.util.HashMap;

import processing.core.PApplet;
import processing.core.PImage;

public class PlayerHitbox {
    float x, y;
    float speed = 3;
    boolean left, right;
    String direction = "";


    float vy = 0;
    float gravity = 0.5f;
    boolean onGround = false;

    PApplet player;

    public PlayerHitbox(float x, float y, PApplet player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public void update() {

        vy += gravity;
        vy = player.constrain(vy, -10, 5);
        y += vy;

        if (y >= player.height - 30) {
            y = player.height - 30;
            vy = 0;
            onGround = true;
        } else {
            onGround = false;
        }

        if (left == true) {
            x -= speed;
        }
        if (right == true) {
            x += speed;
        }

        x = player.constrain(x, 0, player.width - 21);
        y = player.constrain(y, 30, player.height);

        if (left && !right) {
            direction = "left";
        } else if (right && !left) {
            direction = "right";
        }
    }

    public void display() {
        player.imageMode(PApplet.CENTER);
        player.noStroke();
        player.fill(255, 0, 0);
        player.rect(x, y, 14.5f, 30);
    }

    public void keyPressed(char key, int keyCode) {
        if (key == PApplet.CODED) {
            if (keyCode == PApplet.UP && onGround) {
                vy = -10;
                onGround = false;
            }
            if (keyCode == PApplet.LEFT) {
                direction = "left";
                left = true;
            }
            if (keyCode == PApplet.RIGHT) {
                direction = "right";
                right = true;
            }
        } else {
            if ((key == 'w' || key == 'W') && onGround == true) {
                vy = -10;
                onGround = false;
            }
            if (key == 'a' || key == 'A') {
                direction = "left";
                left = true;
            }
            if (key == 'd' || key == 'D') {
                direction = "right";
                right = true;
            }
        }
    }

    public void keyReleased(char key, int keyCode) {
        if (key == PApplet.CODED) {
            if (keyCode == PApplet.LEFT) {
                left = false;
            }
            if (keyCode == PApplet.RIGHT) {
                right = false;
            }
        } else {
            if (key == 'a' || key == 'A') {
                left = false;
            }
            if (key == 'd' || key == 'D') {
                right = false;
            }
        }
    }
}