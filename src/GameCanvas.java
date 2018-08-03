import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    private List<Star> stars;
    private List<Enemy> enemies;
    private BackGround background = new BackGround();
    private BufferedImage backBuffered;
    public Player player;
    private CreateEnemy createEnemy = new CreateEnemy();
    public CreateStar createStar = new CreateStar();
    private Graphics graphics;
    private CreateEnemyFollow createEnemyFollow = new CreateEnemyFollow();


    public GameCanvas() {

        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupCharacter();
        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.setupStar();
        this.enemies = new ArrayList<>();
        this.setupPlayer();

    }

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(200, 300);
        this.player.velocity.set(2.5f, 0);
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    private void setupEnemy() {
        this.enemies = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.stars.forEach(star -> star.render(graphics));
        this.player.render(this.graphics);
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.createEnemy.render(this.graphics);
        this.createEnemyFollow.render(this.graphics);
        this.repaint();
    }

    public void runAll() {
        this.createStar.run();
        this.stars.forEach(star -> star.run());
        this.createEnemy.run();
        this.createEnemyFollow.run();
        this.enemies.forEach(enemy -> enemy.run());
        this.player.run();

    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}