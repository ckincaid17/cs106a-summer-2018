// TODO: comment this program

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.*;
import acm.program.*;

public class NeuronGraphics extends GraphicsProgram {
	
	private GLabel outputNum = new GLabel("0.0");
	private GLabel inputNum = new GLabel("0.0");
	
	private ArrayList<Double> weights = new ArrayList<Double>();

	public void run() {
		weights.add(2.5);
		weights.add(1.0);
		weights.add(7.0);
		weights.add(-9.0);

		drawNeuron();
		calculateOutput();
		addMouseListeners();
	}

	private void calculateOutput() {
		double inputSum = 0;
		for(int i = 0; i < weights.size(); i++) {
			double weight = weights.get(i);
			double input = getInputValue(i);
			double product = input * weight;
			inputSum = inputSum + product;
		}
		double output = sigmoidFunction(inputSum);
		
		// update the input str
		String inputStr = format(inputSum);
		inputNum.setLabel(inputStr);
		
		// update the output str
		String outputStr = format(output);
		outputNum.setLabel(outputStr);
		colorLabel(outputNum, output);
	}

	private void drawNeuron() {
		drawInput("input1", 100, 100, weights.get(0));
		drawInput("input2", 100, 200, weights.get(1));
		drawInput("input3", 100, 300, weights.get(2));
		drawInput("input4", 100, 400, weights.get(3));
		drawOutput();
		drawNode();
		drawTitle();
	}
	
	public void mouseClicked(MouseEvent e) {
		GObject obj = getElementAt(e.getX(), e.getY());
		if(obj != null) {
			if(obj.getColor() == Color.BLACK) {
				obj.setColor(Color.LIGHT_GRAY);
			} else {
				obj.setColor(Color.BLACK);
			}
		}
		calculateOutput();
	}
	
	private double sigmoidFunction(double x) {
		return 1.0 / (1.0 + Math.exp(-x));
	}
	
	//--------------- Lower Level Methods-------------//

	private void drawTitle() {
		GLabel title = new GLabel("Artificial Neuron");
		title.setFont("courier-30");
		title.setColor(Color.BLUE);
		add(title, (getWidth() - title.getWidth())/2,30);
	}

	private void drawNode() {
		int nodeSize = 100;
		GOval oval = new GOval(nodeSize, nodeSize);
		oval.setFilled(true);
		oval.setColor(new Color(102, 204, 255));
		add(oval, (getWidth() - nodeSize)/2, (getHeight() - nodeSize)/2);

		inputNum.setFont("courier-24");
		add(inputNum, 
				(getWidth() - inputNum.getWidth())/2, 
				getHeight()/2 + 8);
	}

	private void drawOutput() {
		GLine output = new GLine(getWidth()/2, getHeight()/2,
				getWidth() * .76, getHeight()/2);
		add(output);
		outputNum.setFont("courier-24");
		add(outputNum, getWidth() * .78, getHeight()/2 + 8);
	}

	private void drawInput(String name, int x, int y, double weight) {
		GRect input = new GRect(30, 30);
		input.setFilled(true);
		input.setColor(Color.LIGHT_GRAY);
		add(input, x, y);

		GLabel label = new GLabel(name);
		label.setFont("courier-18");
		add(label, x - 10, y - 10);
		
		

		GLine line = new GLine(x + 30, y + 15, getWidth()/2, getHeight()/2);
		add(line);
		
		double midX = (line.getStartPoint().getX()*1.5 + line.getEndPoint().getX()*.5) / 2;
		double midY = (line.getStartPoint().getY()*1.5 + line.getEndPoint().getY()*.5) / 2;
		
		GLabel weightLabel = new GLabel(weight + "");
		weightLabel.setFont("courier-18");
		add(weightLabel, midX, midY);
		
	}
	
	private String format(double output) {
		int hundred = (int) (output * 1000);
		double decimal = hundred / 1000.0;
		return decimal + "";
	}

	private double getInputValue(int i) {
		double x = 110;
		double y = (i + 1) * 100 + 10;
		GObject obj = getElementAt(x, y);
		if(obj.getColor() == Color.BLACK) {
			return 1.0;
		}
		return 0.0;
	}
	
	private void colorLabel(GLabel label, double value) {
		if(value > 0.7) {
			label.setColor(new Color(0, 150, 0));
		} else if(value < 0.2) {
			label.setColor(new Color(150, 0, 0));
		} else {
			label.setColor(Color.BLACK);
		}
	}
	
	public static final int APPLICATION_WIDTH = 700;
	public static final int APPLICATION_HEIGHT = 500;
}
