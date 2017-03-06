// TODO: comment this program

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class Neuron extends GraphicsProgram {

	private ArrayList<Double> weights = null;

	public Neuron(String fileName, int n) {
		loadWeightsFromFile(fileName, n);
	}

	public double activate(ArrayList<Double> inputs) {
		double weightedSum = 0.0;
		for(int i = 0; i < inputs.size(); i++) {
			weightedSum += inputs.get(i) * weights.get(i);
		}
		return sigmoid(weightedSum);
	}

	private double sigmoid(double x) {
		return 1.0 / (1.0 + Math.exp(-x));
	}

	private void loadWeightsFromFile(String fileName, int n) {
		weights = new ArrayList<Double>();
		try {
			BufferedReader rd = new BufferedReader(new FileReader(fileName));
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				weights.add(Double.parseDouble(line));
			}
			rd.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
