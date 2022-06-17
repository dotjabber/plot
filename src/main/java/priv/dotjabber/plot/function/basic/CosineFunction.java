package priv.dotjabber.plot.function.basic;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotBasicFunction;
import priv.dotjabber.plot.generator.ConstGenerator;

public class CosineFunction extends PlotBasicFunction {

	public CosineFunction() {
		super(new ConstGenerator(0));
	}

	@Override
	public double getValue(double x) {
		return Math.cos(x);
	}

	@Override
	public int getColor() {
		return Color.RED.getRGB();
	}
}
