package priv.dotjabber.plot.function.basic;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotBasicFunction;
import priv.dotjabber.plot.generator.ConstGenerator;

public class LinearFunction extends PlotBasicFunction {

	public LinearFunction() {
		super(new ConstGenerator(0));
	}

	@Override
	public double getValue(double x) {
		return x;
	}

	@Override
	public int getColor() {
		return Color.CYAN.getRGB();
	}
}
