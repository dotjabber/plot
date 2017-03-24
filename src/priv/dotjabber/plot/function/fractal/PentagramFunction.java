package priv.dotjabber.plot.function.fractal;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotFractalFunction;
import priv.dotjabber.plot.point.DPoint;

public class PentagramFunction extends PlotFractalFunction {

	@Override
	public DPoint getValue(double rand, DPoint p) {
		DPoint v = new DPoint();
		rand *= 32765;
		
        if(rand < 6553) {
        	v.x = 0.38 * p.x + 0.23499999999999999;
        	v.y = 0.38 * p.y - 0.32300000000000001;
        	
        } else if(rand < 13106) {
        	v.x = 0.38 * p.x - 0.23499999999999999;
        	v.y = 0.38 * p.y - 0.32300000000000001;
        	
        } else if(rand < 19659) {
        	v.x = 0.38 * p.x;
        	v.y = 0.38 * p.y + 0.40000000000000002;
        	
        } else if(rand < 26212) {
        	v.x = 0.38 * p.x + 0.38;
        	v.y = 0.38 * p.y + 0.123;
        	
        } else {
        	v.x = 0.38 * p.x - 0.38;
        	v.y = 0.38 * p.y + 0.123;
        }
				
		return v;
	}

	@Override
	public int getColor() {
		return Color.WHITE.getRGB();
	}
}
