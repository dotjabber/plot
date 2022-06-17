package priv.dotjabber.plot.function.fractal;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotFractalFunction;
import priv.dotjabber.plot.generator.ConstGenerator;
import priv.dotjabber.plot.point.DPoint;

public class DragonFunction extends PlotFractalFunction {

	public DragonFunction() {
		super(new ConstGenerator(0));
	}

	@Override
	public DPoint getValue(double rand, DPoint p) {
		DPoint v = new DPoint();
		
		if(rand < 0.5) {
			v.x = 0.5* p.x + 0.5 * p.y - 0.27;
			v.y = -0.5 * p.x + 0.5 * p.y;
			
		} else {
			v.x = -0.5 * p.x + 0.5 * p.y + 0.14;
			v.y = -0.5 * p.x - 0.5 * p.y;
		}
		
		return v;
	}

	@Override
	public int getColor() {
		return Color.WHITE.getRGB();
	}
}
