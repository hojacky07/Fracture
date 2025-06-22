import processing.core.PApplet;
import processing.core.PImage;

public class Background {
    PApplet app;
    PImage bgImage;
    float offsetX = 0;
    float scrollSpeed = 3;
    float playerHitboxX;

    public Background(PApplet app) {
        this.app = app;
        bgImage = app.loadImage("background/background.png");
    }

    public void update(float playerHitboxX, boolean moveLeft, boolean moveRight) {
        this.playerHitboxX = playerHitboxX;
        if (moveRight && playerHitboxX > 319) {
            offsetX += scrollSpeed;
        }
        if (moveLeft) {
            offsetX -= scrollSpeed;
        }
        offsetX = app.constrain(offsetX, 0, bgImage.width - app.width);
    }

    public void display() {
        app.image(bgImage, 320, 180, 640, 360, (int) offsetX, 0, (int) offsetX + app.width, app.height);
    }

    public float getOffset() {
        return offsetX;
    }
}
