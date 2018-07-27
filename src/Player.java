import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    public int x[] = {0, 0, 0};
    public int y[] = {900, 900, 900};

    public int velocity;

    public void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawPolygon(this.x, this.y, 3);
    }
}
