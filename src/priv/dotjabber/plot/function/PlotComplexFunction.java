package priv.dotjabber.plot.function;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.apache.commons.math3.complex.Complex;

import priv.dotjabber.plot.point.IPoint;

public abstract class PlotComplexFunction extends PlotFunction {

	@Override
	public void doPlot(BufferedImage image, IPoint zeroPoint, double scale) {
		for(int i = 0; i < image.getWidth(); i++) {
			for(int j = 0; j < image.getHeight(); j++) {
				double re = (i - zeroPoint.x) * scale;
				double im = (j - zeroPoint.y) * scale;
				
				Complex v = getValue(new Complex(re, im));
				image.setRGB(i, j, getColor(v));
			}
		}
	}
	
	public abstract Complex getValue(Complex n);

	public int getColor(Complex n) {
		float h = (float) (n.getArgument() / (Math.PI * 2));
		float s = (float) Math.abs(Math.sin((n.abs() * 10))); //

		return Color.HSBtoRGB(h, 1, s);
	}
}
