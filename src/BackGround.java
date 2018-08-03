import java.awt.*;

public class BackGround {
    public Vector2D position;
    public Renderer renderer;
    public BackGround(){
        this.position = new Vector2D();
        this.position.set(0, 0);
        this.renderer = new BackgroundRenderer(Color.BLACK, 1024, 600);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}