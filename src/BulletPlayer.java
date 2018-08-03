//import java.awt.*;
//import java.awt.image.BufferedImage;
//
//public class BulletPlayer {
//    public BufferedImage image;
//    public Vector2D position;
//    public Vector2D velocity;
//
//    public BulletPlayer() {
//        this.position = new Vector2D();
//        this.velocity = new Vector2D();
//    }
//
//    public void run() {
//        this.position.addUp(this.velocity);
//    }
//
//    public void render(Graphics graphics) {
//        graphics.fillOval((int)this.position.x,(int)this.position.y,4,4);
//    }
//}
import java.awt.*;

public class BulletPlayer {

    public Vector2D position;
    public Vector2D velocity;
    public Renderer renderer;

    public BulletPlayer() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer( 5, 5, "resources/images/circle.png");
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }

}