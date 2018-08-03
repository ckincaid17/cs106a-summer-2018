import acm.program.*;
import acm.graphics.*;
import java.awt.*;

// A sample animation program
public class MyAnimation extends GraphicsProgram {
	public void run() {
		setBackground(Color.YELLOW);
		
		GRect rect = new GRect(50, 50, 100, 100);
		rect.setFilled(true);
		rect.setColor(Color.BLUE);
		add(rect);
		
		// animate rect to the right until it hits the right edge of the screen
		
		
		// animate rect to the left until it hits the left edge of the screen
		
	}
}
