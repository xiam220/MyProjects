package java_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JavaGame extends JFrame{
	int x, y, xDirection, yDirection;
	private Image dbImage; //double buffering creates an off screen image and then displays it to the image we see
	private Graphics dbG;
	Image face;
	//Font(<Font Family>, <Style>, 
	Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	
	public void move() {
		x += xDirection;
		y += yDirection;
	}
	
	public void setXDirection(int xdir) {
		xDirection = xdir;
		
	}
	
	public void setYDirection(int ydir) {
		yDirection = ydir;
	}
	
	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
/*			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_LEFT) {
				if(x <= 0) {
					x = 0;
				} else {
					x -= 5;
				}
			}
			if(keyCode == e.VK_RIGHT) {
				if(x >= 230) {
					x = 230;
				} else {
					x += 5;
				}	
			}
			//x and y starts in the top left corner
			if(keyCode == e.VK_UP) {
				if(y <= 20) {
					y = 20;
				} else {
					y -= 5;
				}
			}
			if(keyCode == e.VK_DOWN) {
				if( y >= 230) {
					y = 230;
				} else {
					y += 5;
				}
			} */
		} 
		
		public void keyReleased(KeyEvent e) {
			
		}
	}
	
	//Set basic options for the JFrame
	public JavaGame() {
		//Load images
		ImageIcon ii = new ImageIcon("src/java_game/smiley_face.png");
		face = ii.getImage().getScaledInstance(50, 30, Image.SCALE_DEFAULT);
		addKeyListener(new AL());
		//Default methods within JFrame
		setTitle("Java Game");
		setSize(250, 250);
		setResizable(false);
		setVisible(true); //To see game window
		setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Game stops running in the background when exited
	
		x = 150;
		y = 150;
	}
	
	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight()); //creates an image of the current screen
		dbG = dbImage.getGraphics(); //gets the graphics on the screen of the image
		paintComponent(dbG);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paintComponent(Graphics g) {
		//g.drawString("Hello World", 75, 75);
		//g.setFont(font);
		//g.setColor(Color.MAGENTA);
		//g.drawString("Hello World", 50, 50);
		//g.setColor(Color.red);
		g.drawImage(face, x, y, this);
		//g.fillOval(x, y, 15, 15);
		repaint();
	}
	
	//JFrame to put the java application in
	public static void main(String[] args) {
		new JavaGame();
	}
}
