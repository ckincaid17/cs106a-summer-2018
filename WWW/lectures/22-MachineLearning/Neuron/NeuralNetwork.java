import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.program.ConsoleProgram;

public class NeuralNetwork extends ConsoleProgram{

	private static final int N_INPUTS = 1024;
	private static final int N_LAYER1 = 20;

	private ArrayList<Neuron> layer1 = null;
	private Neuron prediction = null;

	public void run() {
		loadNeuralNetwork();

		// make predicitons
		GImage birdImage = new GImage("bird6.png");
		GImage planeImage = new GImage("airplane4.png");
		
		makePrediction(birdImage);
		makePrediction(planeImage);
	}

	private void makePrediction(GImage img) {
		// turn the image into inputs
		ArrayList<Double> inputs = new ArrayList<Double>();
		int[][] pixelArray = img.getPixelArray();
		for(int r = 0; r < pixelArray.length; r++) {
			for(int c = 0; c < pixelArray[0].length; c++) {
				Color color = new Color(pixelArray[r][c]);
				double greyScale = getGrey(color);
				inputs.add(greyScale);
			}
		}

		// feed forward into layer 1
		ArrayList<Double> layer1Outputs = new ArrayList<Double>();
		for(int i = 0; i < N_LAYER1; i++) {
			double output = layer1.get(i).activate(inputs);
			layer1Outputs.add(output);
		}

		// feed forward into the prediction layer
		double output = prediction.activate(layer1Outputs);
		
		// slightly biased towards birds
		if(output > 0.4) {
			println("It's a bird!");
		} else {
			println("It's a plane!");
		}
	}

	private double getGrey(Color color) {
		float[] hsv = Color.RGBtoHSB(color.getRed(),
				color.getGreen(),
				color.getBlue(),
				null);
		return hsv[2];
	}

	private void loadNeuralNetwork() {
		layer1 = new ArrayList<Neuron>();
		for(int i = 0; i < N_LAYER1; i++) {
			Neuron hidden = new Neuron("weights/layer1_" + i + ".txt", N_INPUTS);
			layer1.add(hidden);
		}
		prediction = new Neuron("weights/prediction.txt", N_LAYER1);
	}

	public void init() {
		setFont("courier-24");
	}

}
