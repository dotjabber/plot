package priv.dotjabber.plot.function.complex;

import org.apache.commons.math3.complex.Complex;

import priv.dotjabber.plot.function.PlotComplexFunction;

public class MandelbrotSet extends PlotComplexFunction {
	private static final int ITERATIONS = 10;

	@Override
	public Complex getValue(Complex n) {
		Complex z = new Complex(0, 0);
		for(int i = 0; i < ITERATIONS; i++) {
			if(i > 0) {
				z = z.multiply(z).add(n);
			}
		}
		
		return z;
	}
}
