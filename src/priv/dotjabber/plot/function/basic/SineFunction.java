package priv.dotjabber.plot.function.basic;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotBasicFunction;

public class SineFunction extends PlotBasicFunction {

	@Override
	public double getValue(double x) {
		return Math.sin(x);
	}

	@Override
	public int getColor() {
		return Color.YELLOW.getRGB();
	}
}
