package Controller;


import View.View_Menu;
import Model.Abstract_Dusman;
import Model.Model_Oyuncu;
import Model.Model_Arkaplan;
import Model.Model_Dusman1;
import Model.Model_Mermi;
import Model.Model_Dusman2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Controller_Oyun extends JFrame implements KeyListener, Runnable {

    final int FRAMES_PER_SECOND = 60;
    final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
    final int MAX_FRAMESKIP = 10;
    private Model_Arkaplan backgroundPanel;
    private Model_Arkaplan foreground;
    private Model_Oyuncu player;
    private ArrayList<Model_Mermi> bullets = new ArrayList<Model_Mermi>();
    private ArrayList<Abstract_Dusman> enemyShips = new ArrayList<Abstract_Dusman>();
    public JLabel hiz;
    private int screenx = 800;
    private int screeny = 600;
    private Integer score;
    private boolean game_is_running = true;
    private boolean explosion = false;
    private boolean mPressed = false, ePressed = false, inputWaiting = true;
    private String username = "Misafir", shipName = "", password = "";

    Random enemyLoc;
    BufferedImage backgroundImage, playerImageIdle, playerImageLeft, playerImageRight, boosterImage, bulletImage, bulletImage2, bulletImage3, enemyImageS, enemyImageM;
    BufferedImage explosionImage1, explosionImage2, explosionImage3, explosionImage4, explosionImage5, explosionImage6;
    BufferedImage healthBar1, healthBar2;
    Image backbuffer;
    Graphics2D g2d;
    int frame = 0, frame1, frame2, frame3, frame4, frame5, explosionx, explosiony, loop;
    int sec = 0;

    public Controller_Oyun() {
       generateView();

    }

    public Controller_Oyun(String username, String password, String shipName) {
        this.username = username;
        this.shipName = shipName;
        this.password = password;
       generateView();

    }

    public void generateView() {
        this.setTitle("melisayca jet-fighter");
        setLayout(null);

        screenx = 800;
        screeny = 600;
        score = 0;

        backgroundPanel = new Model_Arkaplan();
        backgroundPanel.setBounds(0, 0, screenx, screeny);
        this.add(backgroundPanel);

        foreground = new Model_Arkaplan();
        foreground.setBounds(0, 0, screenx, screeny);
        this.add(foreground);

        enemyLoc = new Random();

        player = new Model_Oyuncu();

        try {
            backgroundImage = ImageIO.read(new File("arkaplan3.png").getAbsoluteFile());
            playerImageIdle = ImageIO.read(new File("ucak1.png").getAbsoluteFile());
            playerImageLeft = ImageIO.read(new File("ucak2.png").getAbsoluteFile());
            playerImageRight = ImageIO.read(new File("ucak3.png").getAbsoluteFile());
            boosterImage = ImageIO.read(new File("hiz.png").getAbsoluteFile());
            bulletImage = ImageIO.read(new File("lazer.png").getAbsoluteFile());
            bulletImage2 = ImageIO.read(new File("devmermiler.png").getAbsoluteFile());
            bulletImage3 = ImageIO.read(new File("atestopu.png").getAbsoluteFile());
            enemyImageS = ImageIO.read(new File("enemyShip.png").getAbsoluteFile());
            enemyImageM = ImageIO.read(new File("enemy2.png").getAbsoluteFile());
            explosionImage1 = ImageIO.read(new File("yildiz1.png").getAbsoluteFile());
            explosionImage2 = ImageIO.read(new File("yildiz2.png").getAbsoluteFile());
            explosionImage3 = ImageIO.read(new File("yildiz3.png").getAbsoluteFile());
            explosionImage4 = ImageIO.read(new File("yildiz4.png").getAbsoluteFile());
            explosionImage5 = ImageIO.read(new File("yildiz5.png").getAbsoluteFile());
            explosionImage6 = ImageIO.read(new File("yildiz6.png").getAbsoluteFile());
            healthBar1 = ImageIO.read(new File("canbari1.png").getAbsoluteFile());
            healthBar2 = ImageIO.read(new File("canbari2.png").getAbsoluteFile());

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenx, screeny);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(this);

        backbuffer = createImage(getSize().width, getSize().height);
        g2d = (Graphics2D) backbuffer.getGraphics();
        g2d.setFont(new Font("SerifSans", Font.BOLD, 14));
        g2d.setColor(Color.WHITE);

    }

    public void run() {
        double next_game_tick = System.currentTimeMillis();
        int sleepTime = 0;
        while (game_is_running) {
            update();
            render();
            next_game_tick += SKIP_TICKS;
            sleepTime = (int) (next_game_tick - System.currentTimeMillis());
            if (sleepTime >= 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
            }
            frame++;
            if (frame == 61) {
                frame = 1;
                sec++;
            } else {
            }
            if (sec == 61) {
                sec = 1;
            } else {
            }
        }
        while (inputWaiting) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (mPressed) {
                dispose();
                View_Menu menu = new View_Menu();
                inputWaiting = false;
            } else if (ePressed) {
                System.exit(0);
            } else {
            }
        }
    }

    public void update() {																							//Updating Game
        player.updateComponent();

        if (frame == 10 || frame == 40) {																			//Bullet patterns
            Model_Mermi bullet = new Model_Mermi(player.getPlayerLocx() - 3, player.getPlayerLocy() - 45);
            bullets.add(bullet);

        } else if (frame == 30) {
            for (Abstract_Dusman e : enemyShips) {
                if (e instanceof Model_Dusman1) {
                    Model_Mermi enemyBullet = new Model_Mermi(e.getEnemyX() - 3, e.getEnemyY() + 50);
                    enemyBullet.setSpeed(enemyBullet.getSpeed() * -1);
                    enemyBullet.setPlayerBullet(false);
                    enemyBullet.setSource(3);
                    bullets.add(enemyBullet);
                }
            }
        } else if (sec % 2 == 1 && (frame == 5 || frame == 25 || frame == 45)) {
            for (Abstract_Dusman e : enemyShips) {
                if (e instanceof Model_Dusman2) {
                    Model_Mermi enemyBullet = new Model_Mermi(e.getEnemyX() + 20, e.getEnemyY() + 150);
                    enemyBullet.setSpeed(enemyBullet.getSpeed() * -1);
                    enemyBullet.setPlayerBullet(false);
                    enemyBullet.setSource(2);
                    bullets.add(enemyBullet);
                }
            }
        } else {
        }
        if (sec % 3 == 0 && frame == 1) {																			//Ship patterns
            Model_Dusman1 e = new Model_Dusman1();

            e.setEnemyX(player.getPlayerLocx());
            e.setEnemyY(-50);
            enemyShips.add(e);
        } else {
        }
        if (sec % 10 == 0 && frame == 1) {
            Model_Dusman2 e = new Model_Dusman2();
            e.setEnemyX(player.getPlayerLocx());
            e.setEnemyY(-175);
            enemyShips.add(e);
        } else {
        }

        Iterator<Model_Mermi> iterBullet = bullets.iterator();																//if bullet out of screen then remove
        while (iterBullet.hasNext()) {
            Model_Mermi b = iterBullet.next();
            b.updateComponent();
            if (b.isOutOfScreen()) {
                iterBullet.remove();
                b = null;
            } else {
            }
        }

        Iterator<Abstract_Dusman> iterShip = enemyShips.iterator(); 															//if enemy ship out of screen then remove
        while (iterShip.hasNext()) {
            Abstract_Dusman e = iterShip.next();
            e.updateComponent();
            if (e.isOutOfScreen()) {
                score -= 50;
                iterShip.remove();
                e = null;
            } else {
            }
        }

        iterBullet = bullets.iterator();																				//Collisions
        iterShip = enemyShips.iterator();
        Rectangle r3 = new Rectangle(player.getPlayerLocx(), player.getPlayerLocy(), player.getPlayerWidth(), player.getPlayerHeight());

        while (iterBullet.hasNext()) {
            Model_Mermi b = iterBullet.next();
            Rectangle r1 = new Rectangle(b.getBulletLocx(), b.getBulletLocy(), b.getBulletWidth(), b.getBulletHeight());
            if ((r1.intersects(r3) || r3.intersects(r1)) && !b.isPlayerBullet()) {
                player.setHealth(player.getHealth() - 5);
                iterBullet.remove();
                b = null;
            }
        }
        while (iterShip.hasNext()) {
            Abstract_Dusman e = iterShip.next();
            Rectangle r2 = null;
            if (e instanceof Model_Dusman1) {
                r2 = new Rectangle(e.getEnemyX(), e.getEnemyY(), ((Model_Dusman1) e).getShipWidth(), ((Model_Dusman1) e).getShipHeight());
            } else if (e instanceof Model_Dusman2) {
                r2 = new Rectangle(e.getEnemyX(), e.getEnemyY(), ((Model_Dusman2) e).getShipWidth(), ((Model_Dusman2) e).getShipHeight());
            } else {
            }
            if (r2.intersects(r3) || r3.intersects(r2)) {

                player.setHealth(player.getHealth() - 20);
                e.setHealth(0);
            } else {
            }
            if (!e.isAlive()) {

                if (e instanceof Model_Dusman2) {
                    score += 300;
                } else {
                    score += 100;
                }
                explosion = true;
                frame1 = frame;
                frame2 = (frame + 12) % 60;
                frame3 = (frame + 24) % 60;
                frame4 = (frame + 36) % 60;
                frame5 = (frame + 48) % 60;
                explosionx = e.getEnemyX();
                explosiony = e.getEnemyY();
                iterShip.remove();
                e = null;
            } else {
            }
        }
        iterBullet = bullets.iterator();
        iterShip = enemyShips.iterator();
        while (iterBullet.hasNext()) {
            Model_Mermi b = iterBullet.next();
            Rectangle r1 = new Rectangle(b.getBulletLocx(), b.getBulletLocy(), b.getBulletWidth(), b.getBulletHeight());
            while (iterShip.hasNext()) {
                Abstract_Dusman e = iterShip.next();
                Rectangle r2 = null;
                if (e instanceof Model_Dusman1) {
                    r2 = new Rectangle(e.getEnemyX(), e.getEnemyY(), ((Model_Dusman1) e).getShipWidth(), ((Model_Dusman1) e).getShipHeight());
                } else if (e instanceof Model_Dusman2) {
                    r2 = new Rectangle(e.getEnemyX(), e.getEnemyY(), ((Model_Dusman2) e).getShipWidth(), ((Model_Dusman2) e).getShipHeight());
                } else {
                }
                if ((r1.intersects(r2) || r2.intersects(r1)) && b.isPlayerBullet()) {
                    e.setHealth(e.getHealth() - 1);
                    iterBullet.remove();
                    b = null;
                    break;
                } else {
                }
                if (!e.isAlive()) {

                    score += 100;
                    explosion = true;
                    frame1 = frame;
                    frame2 = (frame + 12) % 60;
                    frame3 = (frame + 24) % 60;
                    frame4 = (frame + 36) % 60;
                    frame5 = (frame + 48) % 60;
                    explosionx = e.getEnemyX();
                    explosiony = e.getEnemyY();
                    iterShip.remove();
                    e = null;
                } else {
                }
            }
        }

        backgroundPanel.updateComponent();
        if (player.getHealth() <= 0) {

            game_is_running = false;
            Scanner fileScanner = null, lineScanner;
            BufferedReader bf = null;
            BufferedWriter writer = null;
            File f = new File("highscore.csv");
            try {
                bf = new BufferedReader(new FileReader("highscore.csv"));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            try {
                writer = new BufferedWriter(new FileWriter("highscore.csv", true));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (!f.exists()) {
              
            }
            String currentLine = "";
            String lineAdded = "";
            ArrayList<String> lines = new ArrayList<String>();
            try {
                while ((currentLine = bf.readLine()) != null) {
                    
                    lineScanner = new Scanner(currentLine).useDelimiter(",");
                    String u = lineScanner.next();
                    String hs = lineScanner.next();
                    int highScore = Integer.parseInt(hs);
                    if (u.equals(username) && score > highScore) {
                        lineAdded = String.format("%s,%s", u, score.toString());
                        lines.add(lineAdded);
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (String s : lines) {
                
                try {
                    writer.write(s);
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void render() {																					//Painting updated version of the game

        g2d.drawImage(backgroundImage, 0, 0, 800, 600, 0, backgroundPanel.getPositiony() - 600, 800, backgroundPanel.getPositiony(), null);

        if (loop < 10 && explosion) //Explosion
        {
            g2d.drawImage(explosionImage1, explosionx, explosiony, null);
            loop++;
        } else if (loop >= 10 && loop < 20 && explosion) {
            g2d.drawImage(explosionImage2, explosionx, explosiony, null);
            loop++;
        } else if (loop >= 20 && loop < 30 && explosion) {
            g2d.drawImage(explosionImage3, explosionx, explosiony, null);
            loop++;
        } else if (loop >= 30 && loop < 40 && explosion) {
            g2d.drawImage(explosionImage4, explosionx, explosiony, null);
            loop++;
        } else if (loop >= 40 && loop < 50 && explosion) {
            g2d.drawImage(explosionImage5, explosionx, explosiony, null);
            loop++;
        } else if (loop >= 50 && loop < 60 && explosion) {
            g2d.drawImage(explosionImage5, explosionx, explosiony, null);
            loop++;
            if (loop == 60) {
                explosion = false;
                loop = 0;
            }
        } else {
        }

        if (player.isMovingLeft() && player.isMovingRight()) {
            g2d.drawImage(playerImageIdle, player.getPlayerLocx(), player.getPlayerLocy(), null);
        } else if (player.isMovingDown() && player.isMovingUp()) {
            g2d.drawImage(playerImageIdle, player.getPlayerLocx(), player.getPlayerLocy(), null);
        } else if (player.isMovingLeft()) {
            g2d.drawImage(playerImageLeft, player.getPlayerLocx(), player.getPlayerLocy(), null);
        } else if (player.isMovingRight()) {
            g2d.drawImage(playerImageRight, player.getPlayerLocx(), player.getPlayerLocy(), null);
        } else {
            g2d.drawImage(playerImageIdle, player.getPlayerLocx(), player.getPlayerLocy(), null);
        }

        if (!shipName.equals("")) {
            g2d.drawString(shipName, player.getPlayerLocx(), player.getPlayerLocy() + 100);
        } else {
        }

        g2d.drawString(String.format("Score: %s", score), 650, 75);
        g2d.drawImage(healthBar1, 550, 500, null);
        if (player.getHealth() > 0) {
            g2d.drawImage(healthBar2, 550, 500, 550 + player.getHealth() * 2, 541, 0, 0, player.getHealth() * 2, 41, null);
        } else {
        }

        if (player.moving()) {
            g2d.drawImage(boosterImage, player.getPlayerLocx() + 17, player.getPlayerLocy() + 55, null);
        } else {
        }
        for (Model_Mermi b : bullets) {
            if (b.getSource() == 2) {
                g2d.drawImage(bulletImage2, b.getBulletLocx(), b.getBulletLocy(), null);
            } else if (b.getSource() == 3) {
                g2d.drawImage(bulletImage3, b.getBulletLocx(), b.getBulletLocy(), null);
            } else {
                g2d.drawImage(bulletImage, b.getBulletLocx(), b.getBulletLocy(), null);
            }
        }
        for (Abstract_Dusman e : enemyShips) {																	//Ships
            if (e instanceof Model_Dusman1) {
                g2d.drawImage(enemyImageS, e.getEnemyX(), e.getEnemyY(), ((Model_Dusman1) e).getShipWidth(), ((Model_Dusman1) e).getShipHeight(), null);
            } else if (e instanceof Model_Dusman2) {
                g2d.drawImage(enemyImageM, e.getEnemyX(), e.getEnemyY(), ((Model_Dusman2) e).getShipWidth(), ((Model_Dusman2) e).getShipHeight(), null);
            } else {
            }
        }
        if (!game_is_running) {
            g2d.setFont(new Font("SerifSans", Font.BOLD, 72));
            g2d.drawString("OYUN BİTTİ", 150, 300);
            g2d.drawString("M:MENÜ    E:ÇIKIŞ", 100, 450);
        }
        this.getGraphics().drawImage(backbuffer, 0, 0, null);

    }

    public Model_Arkaplan getBackgroundPanel() {
        return backgroundPanel;
    }

    public void setBackgroundPanel(Model_Arkaplan backgroundPanel) {
        this.backgroundPanel = backgroundPanel;
    }

    @Override
    public void keyPressed(KeyEvent event) {

        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                player.setMovingUp(true);
                break;
            case KeyEvent.VK_DOWN:
                player.setMovingDown(true);
                break;
            case KeyEvent.VK_LEFT:
                player.setMovingLeft(true);
                break;
            case KeyEvent.VK_RIGHT:
                player.setMovingRight(true);
                break;
            case KeyEvent.VK_ESCAPE:
                View_Menu menu = new View_Menu();
                dispose();
                break;
            case KeyEvent.VK_M:
                mPressed = true;
                break;
            case KeyEvent.VK_E:
                ePressed = true;
                break;
            default:
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent event) {

        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                player.setMovingUp(false);
                break;
            case KeyEvent.VK_DOWN:
                player.setMovingDown(false);
                break;
            case KeyEvent.VK_LEFT:
                player.setMovingLeft(false);
                break;
            case KeyEvent.VK_RIGHT:
                player.setMovingRight(false);
                break;
            case KeyEvent.VK_M:
                mPressed = false;
                break;
            case KeyEvent.VK_E:
                ePressed = false;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }

    public boolean isGame_is_running() {
        return game_is_running;
    }

    public void setGame_is_running(boolean game_is_running) {
        this.game_is_running = game_is_running;
    }
}
