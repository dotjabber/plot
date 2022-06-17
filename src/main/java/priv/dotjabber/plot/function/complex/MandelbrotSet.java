package priv.dotjabber.plot.function.complex;

import org.apache.commons.math3.complex.Complex;

import priv.dotjabber.plot.function.PlotComplexFunction;
import priv.dotjabber.plot.generator.ConstGenerator;
import priv.dotjabber.plot.generator.Generator;

public class MandelbrotSet extends PlotComplexFunction {

	public MandelbrotSet(Generator generator) {
		super(generator);
	}

	public MandelbrotSet() {
		super(new ConstGenerator(5));
	}

	@Override
	public Complex getValue(Complex n) {
		int iterations = (Integer) getGenerator().get();

		Complex z = new Complex(0, 0);
		for(int i = 0; i < iterations; i++) {
			if(i > 0) {
				z = z.multiply(z).add(n);
			}
		}
		
		return z;
	}
}
