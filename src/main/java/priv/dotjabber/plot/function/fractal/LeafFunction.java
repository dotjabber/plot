package priv.dotjabber.plot.function.fractal;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotFractalFunction;
import priv.dotjabber.plot.generator.ConstGenerator;
import priv.dotjabber.plot.point.DPoint;

public class LeafFunction extends PlotFractalFunction {

	public LeafFunction() {
		super(new ConstGenerator(0));
	}

	@Override
	public DPoint getValue(double rand, DPoint p) {
		DPoint v = new DPoint();
		rand *= 26213;

        if(rand < 6553) {
            v.x = 0.0D;
            v.y = (0.20000000000000001 * p.x + 0.16D * p.y) - 0.040000000000000001;

        } else if(rand < 13106) {
        	v.x = 0.20000000000000001 * p.x - 0.26000000000000001 * p.y;
        	v.y = 0.23000000000000001 * p.x + 0.22D * p.y + 0.10000000000000001;
        	
        } else if(rand < 19659) {
        	v.x = -0.14999999999999999 * p.x + 0.28000000000000003 * p.y;
        	v.y = 0.26000000000000001 * p.x + 0.23999999999999999 * p.y + 0.10000000000000001;
        	
        } else {
        	v.x = 0.84999999999999998 * p.x + 0.040000000000000001 * p.y;
        	v.y = -0.040000000000000001 * p.x + 0.83999999999999997 * p.y + 0.10000000000000001;
        }
        
		return v;
	}

	@Override
	public int getColor() {
		return Color.WHITE.getRGB();
	}
}
