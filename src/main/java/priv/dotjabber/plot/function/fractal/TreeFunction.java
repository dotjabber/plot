package priv.dotjabber.plot.function.fractal;

import java.awt.Color;

import priv.dotjabber.plot.function.PlotFractalFunction;
import priv.dotjabber.plot.generator.ConstGenerator;
import priv.dotjabber.plot.point.DPoint;

public class TreeFunction extends PlotFractalFunction {

	public TreeFunction() {
		super(new ConstGenerator(0));
	}

	@Override
	public DPoint getValue(double rand, DPoint p) {
		DPoint v = new DPoint();
		rand *= 32768;

        if(rand < 6553) {
            v.x = (0.19500000000000001 * p.x - 0.47999999999999998 * p.y) + 0.443;
            v.y = 0.34000000000000002 * p.x + 0.443 * p.y + 0.245;

        } else if(rand < 13106) {
        	v.x = 0.46200000000000002 * p.x + 0.41399999999999998 * p.y + 0.251;
        	v.y = -0.252 * p.x + 0.36099999999999999 * p.y + 0.56899999999999995;

        } else if(rand < 19659) {
        	v.x = (-0.058000000000000003 * p.x - 0.070000000000000007 * p.y) + 0.58999999999999997;
        	v.y = (0.45300000000000001 * p.x - 0.111 * p.y) + 0.096000000000000002;

        } else if(rand < 26212) {
        	v.x = -0.035000000000000003 * p.x + 0.070000000000000007 * p.y + 0.48799999999999999;
        	v.y = (-0.46899999999999997 * p.x - 0.021999999999999999 * p.y) + 0.50600000000000001;

        } else {
        	v.x = -0.63700000000000001 * p.x + 0.0 * p.y + 0.85599999999999998;
        	v.y = 0.0 * p.x + 0.5 * p.y + 0.25130000000000002;
        }
		
		return v;
	}

	@Override
	public int getColor() {
		return Color.WHITE.getRGB();
	}
}
