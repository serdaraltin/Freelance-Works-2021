
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

public class MainMenu extends JFrame {

    private JButton registerButton;
    private JButton loginButton;
    private JButton playButton;
    private JButton scoreButton;
    private JButton exitButton;
    private int buttonWidth = 200;
    private int buttonHeight = 50;
    private boolean gameStarted = false, blank = true;
    private Game game;
    private String username, password, shipName;
    char[] passwordArray;
    BufferedWriter writer;
    PrintWriter printWriter, printWriterHs;
    File f;
    Scanner fileScanner, lineScanner;

    public MainMenu() {
        createGui();

    }

    public void createGui() {
        this.setTitle("Main Menu");
        setLayout(null);

        registerButton = new JButton("Register");
        registerButton.setBounds(50, 50, buttonWidth, buttonHeight);
        registerButton.setFont(new Font("SerifSans", Font.BOLD, 20));
        add(registerButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 120, buttonWidth, buttonHeight);
        loginButton.setFont(new Font("SerifSans", Font.BOLD, 20));
        add(loginButton);

        playButton = new JButton("Play Game");
        playButton.setBounds(50, 190, buttonWidth, buttonHeight);
        playButton.setFont(new Font("SerifSans", Font.BOLD, 20));
        add(playButton);

        scoreButton = new JButton("High Scores");
        scoreButton.setBounds(50, 260, buttonWidth, buttonHeight);
        scoreButton.setFont(new Font("SerifSans", Font.BOLD, 20));
        add(scoreButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(50, 330, buttonWidth, buttonHeight);
        exitButton.setFont(new Font("SerifSans", Font.BOLD, 20));
        add(exitButton);

        f = new File("log.csv");

        registerButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JFrame registerFrame = new JFrame();
                registerFrame.setTitle("Register");
                registerFrame.setLayout(null);
                JTextField usernameField = new JTextField(10);
                JTextField shipNameField = new JTextField(10);
                JPasswordField passwordField = new JPasswordField();
                JLabel usernameLabel = new JLabel("Username");
                JLabel shipNameLabel = new JLabel("Ship Name");
                JLabel passwordLabel = new JLabel("Password");
                JButton registerButton = new JButton("Register");
                registerButton.setBounds(150, 190, 150, 50);
                usernameLabel.setBounds(100, 40, 80, 40);
                shipNameLabel.setBounds(100, 90, 80, 40);
                passwordLabel.setBounds(100, 140, 80, 40);
                usernameField.setBounds(200, 40, 200, 40);
                shipNameField.setBounds(200, 90, 200, 40);
                passwordField.setBounds(200, 140, 200, 40);
                registerFrame.add(usernameField);
                registerFrame.add(shipNameField);
                registerFrame.add(passwordField);
                registerFrame.add(usernameLabel);
                registerFrame.add(shipNameLabel);
                registerFrame.add(passwordLabel);
                registerFrame.add(registerButton);
                registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                registerFrame.setSize(500, 300);
                registerFrame.setResizable(false);
                registerFrame.setVisible(true);
                registerFrame.setLocationRelativeTo(null);
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
                                JOptionPane.showMessageDialog(registerFrame, "Registered successfully", "Register successful", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(registerFrame, "Username or password cannot be empty", "Register failed", JOptionPane.ERROR_MESSAGE);
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
        loginButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JFrame loginFrame = new JFrame();
                loginFrame.setTitle("Login");
                loginFrame.setLayout(null);
                JTextField usernameField = new JTextField(10);
                JPasswordField passwordField = new JPasswordField();
                JLabel usernameLabel = new JLabel("Username");
                JLabel passwordLabel = new JLabel("Password");
                JButton loginButton = new JButton("Login");
                loginButton.setBounds(150, 190, 150, 50);
                usernameLabel.setBounds(100, 40, 80, 40);
                passwordLabel.setBounds(100, 90, 80, 40);
                usernameField.setBounds(200, 40, 200, 40);
                passwordField.setBounds(200, 90, 200, 40);
                loginFrame.add(usernameField);
                loginFrame.add(passwordField);
                loginFrame.add(usernameLabel);
                loginFrame.add(passwordLabel);
                loginFrame.add(loginButton);
                loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                loginFrame.setSize(500, 300);
                loginFrame.setResizable(false);
                loginFrame.setVisible(true);
                loginFrame.setLocationRelativeTo(null);
                loginFrame.getRootPane().setDefaultButton(loginButton);
                loginButton.addActionListener(
                        new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        username = usernameField.getText();
                        passwordArray = passwordField.getPassword();
                        password = new String(passwordArray);
                        Boolean loggedIn = false;
                        try {
                            fileScanner = new Scanner(f);
                        } catch (FileNotFoundException e1) {
                            // TODO Auto-generated catch block
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
                                JOptionPane.showMessageDialog(loginFrame, String.format("Logged in as: %s", username), "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                                setGameStarted(true);

                                loginFrame.dispose();
                                new Thread(new Runnable() {

                                    @Override
                                    public void run() {
                                        Game game = new Game(u, p, sn);
                                        game.run();
                                    }
                                }).start();

                                dispose();
                                break;
                            } else {
                            }
                        }
                        if (!loggedIn) {
                            JOptionPane.showMessageDialog(loginFrame, "Username/password do not match.", "Login failed", JOptionPane.ERROR_MESSAGE);
                            System.out.println("Username/password do not match.");
                        }
                    }

                }
                );
            }

        }
        );
        playButton.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                setGameStarted(true);

                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Game game = new Game();
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
                scoreFrame.setTitle("High Scores");
                scoreFrame.setLayout(null);
                scoreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                scoreFrame.setSize(800, 600);
                scoreFrame.setResizable(false);
                scoreFrame.setVisible(true);
                scoreFrame.setLocationRelativeTo(null);

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
                        //System.out.println(currentLine);
                        lineScanner = new Scanner(currentLine).useDelimiter(",");
                        String u = lineScanner.next();
                        String hs = lineScanner.next();
                        Integer highScore = Integer.parseInt(hs);
                        map.put(u, highScore);

                    }
                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
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

            private <K, V> void printMap(Map<K, V> map) {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    System.out.println("Key : " + entry.getKey()
                            + " Value : " + entry.getValue());
                }
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
                    g.drawString(String.format("Username: %s %20s %d", entry.getKey(), "High Score: ", entry.getValue()), 10, y);
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
