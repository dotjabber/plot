package priv.dotjabber.plot.function.basic;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotBasicFunction;

public class LinearFunction extends PlotBasicFunction {

	@Override
	public double getValue(double x) {
		return x;
	}

	@Override
	public int getColor() {
		return Color.CYAN.getRGB();
	}
}
