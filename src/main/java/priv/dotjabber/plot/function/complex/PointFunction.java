package priv.dotjabber.plot.function.complex;

import org.apache.commons.math3.complex.Complex;

import priv.dotjabber.plot.function.PlotComplexFunction;

public class PointFunction extends PlotComplexFunction {

	@Override
	public Complex getValue(Complex n) {
		return n;
	}
}
