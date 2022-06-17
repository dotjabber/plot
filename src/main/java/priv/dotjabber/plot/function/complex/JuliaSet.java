package priv.dotjabber.plot.function.complex;

import org.apache.commons.math3.complex.Complex;

import priv.dotjabber.plot.function.PlotComplexFunction;

public class JuliaSet extends PlotComplexFunction {
	private static final int ITERATIONS = 50;
	private final Complex c = new Complex(-0.1, 0.65);

	@Override
	public Complex getValue(Complex n) {
		for(int i = 0; i < ITERATIONS; i++) {
			n = n.multiply(n).subtract(c);
		}
		
		return n;
	}
}
