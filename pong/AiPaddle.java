package pong;

import java.awt.Color;
import java.awt.Graphics;

public class AiPaddle implements Paddle {

    double y, yVel;
    boolean upAccel, downAccel;
    final double GRAVITY = 0.94;
    int player, x;
    ball b1;


    public AiPaddle(int player, ball b){
        upAccel = false;
        b1=b;
        downAccel = false;
        y = 210;
        yVel = 0;
        if(player ==1)
            x = 20;
        else
            x = 660;

    }




    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int)y, 20, 80);

    }

    @Override
    public void move() {
        y=b1.getY()-40;




        if(y < 0)
            y = 0;
        if(y > 420)
            y = 420;

    }




    @Override
    public int getY() {

        return(int)y;
    }

}
