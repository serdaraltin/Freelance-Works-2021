import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Launcher extends JFrame implements ActionListener{

	
public static void main(String[] args) {
	
		JFrame frame = new JFrame("Jet Fighter");
		JButton play,exit,rules,scoreboard;
		play = new JButton("Start");
		exit = new JButton("Exit");
		rules= new JButton("Rules");
		scoreboard = new JButton("scoreboard");
	
		
		BufferedImage img = null;
		img = Assets.mbc;
		ImageIcon icon = new ImageIcon(Launcher.class.getResource("mbc.jpg"));
		Image scaleImage = icon.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
		
		ImageIcon imageIcon = new ImageIcon(scaleImage);
		frame.setContentPane(new JLabel(imageIcon));
		frame.add(play);
		frame.add(rules);
		frame.add(scoreboard);
		frame.add(exit);
		frame.setLayout(new FlowLayout());
		frame.setSize(400,400);  
		frame.setVisible(true);  
		frame.setLocationRelativeTo(null);
	
		play.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent b)
			{
				Game game = new Game("Game!",1280,720);
				game.start();
			}	
		});
		
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}	
		});
		
		scoreboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int[] top= {0,0,0,0,0};
				File f = null;
				Scanner scan = null;
				try{
				   f = new File("Scoreboard.txt");
				   scan = new Scanner(f);
				}
				catch(Exception a){
				   System.exit(0);
				}
				ArrayList<Integer> x = new ArrayList<Integer>();
				while(scan.hasNext()) {
				   x.add(scan.nextInt());}
				
				for(int d=0;d<5;d++){
					int temp= Collections.max(x);
					top[d]=temp;
					int temp2= x.indexOf(temp);
					x.remove(temp2);
					
				}
				JOptionPane.showMessageDialog(null,"1-)"+top[0]+"\n"+"2-)"+top[1]+"\n"+"3-)"+top[2]+"\n"+"4-)"+top[3]+"\n"+"5-)"+top[4]+"\n","Top 5 Score",JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		rules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Every enemy ufo you hunted gives you 3 points, every ufo you missed will decrease 1 point","Rules",JOptionPane.PLAIN_MESSAGE);
			}
		});
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}