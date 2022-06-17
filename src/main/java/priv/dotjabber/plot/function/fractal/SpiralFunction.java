package priv.dotjabber.plot.function.fractal;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotFractalFunction;
import priv.dotjabber.plot.generator.ConstGenerator;
import priv.dotjabber.plot.point.DPoint;

public class SpiralFunction extends PlotFractalFunction {

	public SpiralFunction() {
		super(new ConstGenerator(0));
	}

	@Override
	public DPoint getValue(double rand, DPoint p) {
		DPoint v = new DPoint();
		
		if(rand < 0.5) {
			v.x = -0.4 * p.x - 1.0;
			v.y = -0.4 * p.y + 0.1;
			
		} else {
			v.x = 0.76 * p.x - 0.4 * p.y;
			v.y = 0.4 * p.x + 0.76 * p.y;
		}
		
		return v;
	}

	@Override
	public int getColor() {
		return Color.WHITE.getRGB();
	}
}
