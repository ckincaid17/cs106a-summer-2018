
import java.awt.Color;
import java.util.*;

import acm.graphics.GOval;
import acm.program.*;
import acm.util.RandomGenerator;

public class BuggyBouncing extends GraphicsProgram {

	private static final int N_BALLS = 5;
	private static final int DELAY = 3;
	private static final int BALL_SIZE = 20;
	
	ArrayList<GOval> balls = new ArrayList<GOval>();
		
	public void run() {
		
		for(int i = 0; i < N_BALLS; i++) {
			GOval oval = makeBall();
			balls.add(oval);
		}
		double dx = 1;
		double dy = 1;
		while(true) {
			for(GOval ball : balls) {
				ball.move(dx, dy);
			}
			pause(DELAY);
		}
	}

	private GOval makeBall() {
		RandomGenerator rg = RandomGenerator.getInstance();
		int x = rg.nextInt(getWidth() - BALL_SIZE);
		int y = rg.nextInt(getHeight() - BALL_SIZE);
		GOval oval = new GOval(BALL_SIZE, BALL_SIZE);
		oval.setFilled(true);
		oval.setColor(Color.BLUE);
		add(oval, x, y);
		return oval;
	}
	
	/**
	 * Colision detection
		if(ball.getX() < 0) {
			dx *= -1;
		}
		if(ball.getY() < 0) {
			dy *= -1;
		}
		if(ball.getX() > getWidth()) {
			dx *= -1;
		}
		if(ball.getY() > getHeight()) {
			dy *= -1;
		}
	 */
	
	

}