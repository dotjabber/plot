package priv.dotjabber.plot.function.basic;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotBasicFunction;

public class ParaboleFunction extends PlotBasicFunction {

	@Override
	public double getValue(double x) {
		return x * x;
	}

	@Override
	public int getColor() {
		return Color.MAGENTA.getRGB();
	}
}
