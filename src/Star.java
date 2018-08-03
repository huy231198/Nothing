import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public Vector2D position;

    public Renderer renderer;
    public Vector2D velocity;

    public Star(){
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer(5, 5, "resources/images/star.png");
    }


    public void run() {
        this.position.subtractBy(this.velocity);

    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
