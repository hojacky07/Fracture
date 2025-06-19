import processing.core.PApplet;

public class Player {
    float x, y;
    float size;
    float speed = 5;
    PApplet player;
    boolean up, down, left, right;

    public Player(float x, float y, float size, PApplet player) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.player = player;
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

        x = player.constrain(x, size / 2, player.width - size / 2);
        y = player.constrain(y, size / 2, player.height - size / 2);
    }

    public void display() {
        player.fill(255, 0, 0);
        player.noStroke();
        player.rectMode(PApplet.CENTER);
        player.rect(x, y, size, size);
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
}
