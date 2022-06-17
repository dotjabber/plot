package priv.dotjabber.plot.function.complex;

import org.apache.commons.math3.complex.Complex;

import priv.dotjabber.plot.function.PlotComplexFunction;
import priv.dotjabber.plot.generator.ConstGenerator;

public class PointFunction extends PlotComplexFunction {

	public PointFunction() {
		super(new ConstGenerator(0));
	}

	@Override
	public Complex getValue(Complex n) {
		return n;
	}
}
