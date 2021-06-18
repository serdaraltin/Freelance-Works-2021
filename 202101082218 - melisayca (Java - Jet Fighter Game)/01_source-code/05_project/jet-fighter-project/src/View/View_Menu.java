package View;

import Controller.Controller_Oyun;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class View_Menu extends JFrame {

    private JButton registerButton;
    private JButton loginButton;
    private JButton playButton;
    private JButton scoreButton;
    private JButton exitButton;
    private int buttonWidth = 200;
    private int buttonHeight = 50;
    private boolean gameStarted = false, blank = true;
    private Controller_Oyun game;
    private String username, password, shipName;
    char[] passwordArray;
    BufferedWriter writer;
    PrintWriter printWriter, printWriterHs;
    File f;
    Scanner fileScanner, lineScanner;

    public View_Menu() {
       generateView();

    }

    public void generateView() {
        this.setTitle("Menü");
        setLayout(null);

        registerButton = new JButton("Kayt Oluştur");
        registerButton.setBounds(50, 50, buttonWidth, buttonHeight);
        registerButton.setFont(new Font("SerifSans", Font.BOLD, 20));
        add(registerButton);

        loginButton = new JButton("Giriş");
        loginButton.setBounds(50, 120, buttonWidth, buttonHeight);
        loginButton.setFont(new Font("SerifSans", Font.BOLD, 20));
        add(loginButton);

        playButton = new JButton("Başlat");
        playButton.setBounds(50, 190, buttonWidth, buttonHeight);
        playButton.setFont(new Font("SerifSans", Font.BOLD, 20));
        add(playButton);

        scoreButton = new JButton("Puanlar");
        scoreButton.setBounds(50, 260, buttonWidth, buttonHeight);
        scoreButton.setFont(new Font("SerifSans", Font.BOLD, 20));
        add(scoreButton);

        exitButton = new JButton("Çıkış");
        exitButton.setBounds(50, 330, buttonWidth, buttonHeight);
        exitButton.setFont(new Font("SerifSans", Font.BOLD, 20));
        add(exitButton);

        f = new File("log.csv");

        registerButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JFrame registerFrame = new JFrame();
                registerFrame.setTitle("Oluştur");
                registerFrame.setLayout(null);
                JTextField usernameField = new JTextField(10);
                JTextField shipNameField = new JTextField(10);
                JPasswordField passwordField = new JPasswordField();
                JLabel usernameLabel = new JLabel("Kullanici Adı");
                JLabel shipNameLabel = new JLabel("Araç Adı");
                JLabel passwordLabel = new JLabel("Parola");
                JButton registerButton = new JButton("Kaydet");
                registerButton.setBounds(70, 150, 300, 50);
                usernameLabel.setBounds(70, 40, 80, 25);
                shipNameLabel.setBounds(70, 70, 80, 25);
                passwordLabel.setBounds(70, 100, 80, 25);
                usernameField.setBounds(160, 40, 200, 25);
                shipNameField.setBounds(160, 70, 200, 25);
                passwordField.setBounds(160, 100, 200, 25);

                registerFrame.add(usernameField);
                registerFrame.add(shipNameField);
                registerFrame.add(passwordField);
                registerFrame.add(usernameLabel);
                registerFrame.add(shipNameLabel);
                registerFrame.add(passwordLabel);
                registerFrame.add(registerButton);
                registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                registerFrame.setSize(450, 250);
                registerFrame.setResizable(false);

                registerFrame.setLocationRelativeTo(null);
                registerFrame.setVisible(true);
                registerFrame.getRootPane().setDefaultButton(registerButton);
                registerButton.addActionListener(
                        new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        try {
                            username = usernameField.getText();
                            passwordArray = passwordField.getPassword();
                            shipName = shipNameField.getText();
                            password = new String(passwordArray);
                            if (!(username.equals("")) && !(password.equals(""))) {
                                printWriterHs = new PrintWriter(new FileWriter("highscore.csv", true));
                                printWriter = new PrintWriter(new FileWriter("log.csv", true));
                                printWriter.printf("%s,%s,%s", username, password, shipName);
                                printWriterHs.printf("%s,0", username);
                                printWriter.println();
                                printWriterHs.println();
                                passwordArray = null;
                                printWriterHs.flush();
                                printWriter.close();
                                printWriterHs.close();
                                JOptionPane.showMessageDialog(registerFrame, "Kayıt başarılı", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(registerFrame, "Kullanıcı adı veya parola boş olamaz", "Başarısız", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                );

            }

        }
        );
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JFrame loginFrame = new JFrame();
                loginFrame.setTitle("Giriş");
                loginFrame.setLayout(null);
                JTextField usernameField = new JTextField(10);
                JPasswordField passwordField = new JPasswordField();
                JLabel usernameLabel = new JLabel("Kullanıcı Adı");
                JLabel passwordLabel = new JLabel("Parola");
                JButton loginButton = new JButton("Giriş");
                loginButton.setBounds(100, 100, 300, 50);
                usernameLabel.setBounds(100, 25, 80, 25);
                passwordLabel.setBounds(100, 60, 80, 25);
                usernameField.setBounds(200, 25, 200, 25);
                passwordField.setBounds(200, 60, 200, 25);
                loginFrame.add(usernameField);
                loginFrame.add(passwordField);
                loginFrame.add(usernameLabel);
                loginFrame.add(passwordLabel);
                loginFrame.add(loginButton);
                loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                loginFrame.setSize(500, 220);
                loginFrame.setResizable(false);
                loginFrame.setVisible(true);
                loginFrame.setLocationRelativeTo(null);
                loginFrame.getRootPane().setDefaultButton(loginButton);
                loginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        username = usernameField.getText();
                        passwordArray = passwordField.getPassword();
                        password = new String(passwordArray);
                        Boolean loggedIn = false;
                        try {
                            fileScanner = new Scanner(f);
                        } catch (FileNotFoundException e1) {

                            e1.printStackTrace();
                        }
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            lineScanner = new Scanner(line).useDelimiter(",");
                            String u = lineScanner.next();
                            String p = lineScanner.next();
                            String sn = lineScanner.next();
                            if (u.equals(username) && p.equals(password)) {
                                loggedIn = true;
                                JOptionPane.showMessageDialog(loginFrame, String.format("Giriş yapıldı: %s", username), "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                                setGameStarted(true);

                                loginFrame.dispose();
                                new Thread(new Runnable() {

                                    @Override
                                    public void run() {
                                        Controller_Oyun game = new Controller_Oyun(u, p, sn);
                                        game.run();
                                    }
                                }).start();

                                dispose();
                                break;
                            } else {
                            }
                        }
                        if (!loggedIn) {
                            JOptionPane.showMessageDialog(loginFrame, "Kullanıcı adı veya parola hatalı.", "Başarısız", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
                );
            }

        }
        );
        playButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                setGameStarted(true);

                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Controller_Oyun game = new Controller_Oyun();
                        game.run();

                    }
                }).start();

                dispose();
            }

        });
        scoreButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFrame scoreFrame = new JFrame();
           
                scoreFrame.setTitle("Puanlar");
                scoreFrame.setLayout(null);
                scoreFrame.setSize(800, 600);    
                scoreFrame.setResizable(false);
             

                scoreFrame.setLocationRelativeTo(null);
                scoreFrame.setVisible(true);

                String currentLine = "";
                BufferedReader bf = null;
                try {
                    bf = new BufferedReader(new FileReader("highscore.csv"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Map<String, Integer> map = new HashMap<String, Integer>();
                try {
                    while ((currentLine = bf.readLine()) != null) {

                        lineScanner = new Scanner(currentLine).useDelimiter(",");
                        String u = lineScanner.next();
                        String hs = lineScanner.next();
                        Integer highScore = Integer.parseInt(hs);
                        map.put(u, highScore);

                    }
                } catch (NumberFormatException e) {

                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                }

                Map<String, Integer> sortedMap = sortByValue(map);
                ScorePanel panel = new ScorePanel(sortedMap);
                scoreFrame.add(panel);
                panel.setBounds(10, 10, 700, 500);

            }

            private Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

                ArrayList<Map.Entry<String, Integer>> list
                        = new ArrayList<Map.Entry<String, Integer>>(unsortMap.entrySet());

                Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                    public int compare(Map.Entry<String, Integer> o1,
                            Map.Entry<String, Integer> o2) {
                        return (o2.getValue()).compareTo(o1.getValue());
                    }
                });

                Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
                for (Map.Entry<String, Integer> entry : list) {
                    sortedMap.put(entry.getKey(), entry.getValue());
                }

                return sortedMap;
            }

          
        }
        );
        exitButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }

        }
        );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 450);
        this.setResizable(false);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    class ScorePanel extends JPanel {

        Map<String, Integer> map;

        public ScorePanel(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public void paintComponent(Graphics g) {
            int y = 50;
            g.setFont(new Font("SerifSans", Font.BOLD, 32));
            for (Entry<String, Integer> entry : map.entrySet()) {
                if (y < 700) {
                    g.drawString(String.format("Kullanıcı Adı: %s %20s %d", entry.getKey(), "Puan: ", entry.getValue()), 10, y);
                    y += 50;
                }
            }
        }
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public Controller_Oyun getGame() {
        return game;
    }

    public void setGame(Controller_Oyun game) {
        this.game = game;
    }

}
