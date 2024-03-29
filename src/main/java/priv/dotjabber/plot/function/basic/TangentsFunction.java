package priv.dotjabber.plot.function.basic;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotBasicFunction;
import priv.dotjabber.plot.generator.ConstGenerator;

public class TangentsFunction extends PlotBasicFunction {

	public TangentsFunction() {
		super(new ConstGenerator(0));
	}

	@Override
	public double getValue(double x) {
		return Math.tan(x);
	}

	@Override
	public int getColor() {
		return Color.ORANGE.getRGB();
	}
}
