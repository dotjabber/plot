package priv.dotjabber.plot.function.complex;

import org.apache.commons.math3.complex.Complex;
import priv.dotjabber.plot.function.PlotComplexFunction;
import priv.dotjabber.plot.generator.ConstGenerator;
import priv.dotjabber.plot.generator.Generator;

public class FancyTwoFunction extends PlotComplexFunction {

	public FancyTwoFunction() {
		super(new ConstGenerator(0));
	}

	@Override
	public Complex getValue(Complex n) {
		Complex a = n.multiply(n).subtract(new Complex(0, 1));
		Complex b = n.subtract(new Complex(1, 0));
		Complex c = n.multiply(n).subtract(new Complex(1, 2));
		return a.add(b.add(b).sin()).add(c);
	}
}
