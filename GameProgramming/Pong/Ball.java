import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle{

    Random random;
    // How fast the ball is going to move between the paddles
    int xVelocity;
    int yVelocity;
    int initialSpeed = 2;

    Ball(int x, int y, int width, int height){
        super(x, y, width, height); // width/height are both BALL_DIAMETER
        random = new Random();
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0){
            randomXDirection--;
        }
        setXDirection(randomXDirection*initialSpeed);

        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0){
            randomYDirection--;
        }
        setYDirection(randomYDirection*initialSpeed);
    }

    public void setXDirection(int randomXDirection){
        xVelocity = randomXDirection;
    }

    public void setYDirection(int randomYDirection){
        yVelocity = randomYDirection;
    }

    public void move(){
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y, width, height);
    }
}