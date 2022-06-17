package priv.dotjabber.plot.function.fractal;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotFractalFunction;
import priv.dotjabber.plot.point.DPoint;

public class LabyrinthsFunction extends PlotFractalFunction {

	@Override
	public DPoint getValue(double rand, DPoint p) {
		DPoint v = new DPoint();
		rand *= 3;
		
		if(rand < 1) {
			v.x = 0.333 * p.x;
			v.y = 0.333 * p.y + 0.333;
		
		} else if(rand < 2) {
			v.x = -0.333 * p.y - 0.3333;
			v.y = p.x;
			
		} else {
			v.x = 0.333 * p.y + 0.333;
			v.y = -1.0 * p.x;
		}
		
		return v;
	}

	@Override
	public int getColor() {
		return Color.WHITE.getRGB();
	}
}
