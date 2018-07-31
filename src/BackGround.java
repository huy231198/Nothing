import java.awt.*;

public class BackGround {
    public Vector2D position;
    public int width;
    public int height;
    public BackGround(){
        this.position = new Vector2D();
        width = 1024;
        height = 600;
    }
    public void render (Graphics graphics){
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0, width, height);
    }

}
