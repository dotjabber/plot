package priv.dotjabber.plot.function.fractal;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotFractalFunction;
import priv.dotjabber.plot.point.DPoint;

public class MonsterFunction extends PlotFractalFunction {

	@Override
	public DPoint getValue(double rand, DPoint p) {
		DPoint v = new DPoint();
		
		if(rand < 0.5) {
			v.x = 0.824 * p.x + 0.281 * p.y - 1.88;
			v.y = -0.212 * p.x + 0.86 * p.y - 0.11;
			
		} else {
			v.x = 0.088 * p.x + 0.521 * p.y + 0.78;
			v.y = -0.463 * p.x - 0.377 * p.y + 8.09;
		}
		
		return v;
	}

	@Override
	public int getColor() {
		return Color.WHITE.getRGB();
	}
}
