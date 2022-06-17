package priv.dotjabber.plot.function.complex;

import org.apache.commons.math3.complex.Complex;

import priv.dotjabber.plot.function.PlotComplexFunction;
import priv.dotjabber.plot.generator.ConstGenerator;

public class FancyOneFunction extends PlotComplexFunction {

	public FancyOneFunction() {
		super(new ConstGenerator(0));
	}

	@Override
	public Complex getValue(Complex n) {
		Complex a = n.multiply(n).subtract(new Complex(1, 0));
		Complex b = n.subtract(new Complex(2, 1));
		Complex c = n.multiply(n).subtract(new Complex(2, 2));
		return a.multiply(b.multiply(b).multiply(b)).divide(c);
	}
}
