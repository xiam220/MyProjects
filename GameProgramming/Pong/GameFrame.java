import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

// GameFrame is the frame around the GamePanel; minimize/maximize, exit buttons
public class GameFrame extends JFrame{

    GamePanel panel;

    GameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); // Wrap around the panel and adjust accordingly
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}

