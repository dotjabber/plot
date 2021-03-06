package priv.dotjabber.plot.function.basic;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotBasicFunction;

public class CosineFunction extends PlotBasicFunction {

	@Override
	public double getValue(double x) {
		return Math.cos(x);
	}

	@Override
	public int getColor() {
		return Color.RED.getRGB();
	}
}
