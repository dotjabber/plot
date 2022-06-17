package priv.dotjabber.plot.function.complex;

import org.apache.commons.math3.complex.Complex;
import priv.dotjabber.plot.function.PlotComplexFunction;

public class FancyTwoFunction extends PlotComplexFunction {

	@Override
	public Complex getValue(Complex n) {
		Complex a = n.multiply(n).subtract(new Complex(0, 1));
		Complex b = n.subtract(new Complex(1, 0));
		Complex c = n.multiply(n).subtract(new Complex(1, 2));
		return a.add(b.add(b).sin()).add(c);
	}
}
