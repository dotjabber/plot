package priv.dotjabber.plot.function;

import java.awt.image.BufferedImage;

import priv.dotjabber.plot.point.IPoint;

public abstract class PlotFunction {
	private double[] parameters;

	public void setParameters(double... parameters) {
		this.parameters = parameters;
	}

	public double[] getParameters() {
		return parameters;
	}
	
	public abstract void doPlot(BufferedImage image, IPoint zeroPoint, double scale);
}
