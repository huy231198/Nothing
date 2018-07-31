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
    public Enemy enemy;
    public Star star;
    private Graphics graphics;
    private Random random = new Random();
    private int timeIntervalStar = 0;
    private int timeIntervalEnemy   = 0;


    public GameCanvas() {

        this.setSize(1024, 600);
        setupBackBuffered();
        setupEnemy();
        setupStar();
        setupCharacter();
        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.setupStar();
        this.setupEnemy();
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
        this.renderBackground();
        this.stars.forEach(star -> star.render(graphics));
        this.player.render(this.graphics);
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.repaint();
    }

    public void runAll() {
        createStar();
        this.stars.forEach(star -> star.run());
        createEnemy();
        this.enemies.forEach(enemy -> enemy.run());
        this.player.run();
    }

    private void createStar() {
        if (this.timeIntervalStar == 30) {
            this.star = new Star();
            this.star.position.set(1024, this.random.nextInt(600));
            this.star.image = this.loadImage("resources/images/star.png");
            this.star.width = 5;
            this.star.height = 5;
            this.star.velocity.set(this.random.nextInt(3) + 1, 0);
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else {
            timeIntervalStar += 1;
        }

    }

    private void createEnemy() {
        if (this.timeIntervalEnemy == 300) {
            this.enemy = new Enemy();
            this.enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            this.enemy.width = 15;
            this.enemy.height = 15;
            this.enemy.image = this.loadImage("resources/images/circle.png");
            this.enemy.velocity.set(random.nextInt(3) + 1, random.nextInt(3) + 1);
            this.enemies.add(enemy);
            this.timeIntervalEnemy = 0;
        } else {
            timeIntervalEnemy += 1;
        }
    }

    private void renderBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}