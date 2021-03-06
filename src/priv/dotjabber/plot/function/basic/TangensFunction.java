package priv.dotjabber.plot.function.basic;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotBasicFunction;

public class TangensFunction extends PlotBasicFunction {

	@Override
	public double getValue(double x) {
		return Math.tan(x);
	}

	@Override
	public int getColor() {
		return Color.ORANGE.getRGB();
	}
}
