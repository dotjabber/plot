package priv.dotjabber.plot.function.complex;

import org.apache.commons.math3.complex.Complex;

import priv.dotjabber.plot.function.PlotComplexFunction;
import priv.dotjabber.plot.generator.ConstGenerator;
import priv.dotjabber.plot.generator.Generator;

public class JuliaSet extends PlotComplexFunction {
	private final Complex c;

	public JuliaSet(Complex c, Generator generator) {
		super(generator);
		this.c = c;
	}

	public JuliaSet(Complex c) {
		this(c, new ConstGenerator(80));
	}

	public JuliaSet(Generator generator) {
		this(new Complex(-0.1, 0.65), generator);
	}

	public JuliaSet() {
		this(new Complex(-0.1, 0.65), new ConstGenerator(80));
	}

	@Override
	public Complex getValue(Complex n) {
		int iterations = (Integer) getGenerator().get();

		for(int i = 0; i < iterations; i++) {
			n = n.multiply(n).subtract(c);
		}
		
		return n;
	}
}
