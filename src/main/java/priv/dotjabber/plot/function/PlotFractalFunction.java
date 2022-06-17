package priv.dotjabber.plot.function;

import java.awt.image.BufferedImage;
import java.util.Random;

import priv.dotjabber.plot.point.DPoint;
import priv.dotjabber.plot.point.IPoint;

public abstract class PlotFractalFunction extends PlotFunction {
	private static final int ITERATIONS = 300000;
	private static final Random RAND = new Random();

	@Override
	public void doPlot(BufferedImage image, IPoint zeroPoint, double scale) {
		DPoint p = new DPoint(0, 0);
		
		for(int n = 0; n < ITERATIONS; n++) {
			p = getValue(RAND.nextDouble(), p);

			int i = (int)(p.x / scale) + zeroPoint.x;
			int j = (int)(-p.y / scale) + zeroPoint.y;
			
			if(i >= 0 && j >= 0 && i < image.getWidth() && j < image.getHeight()) {
				image.setRGB(i, j, getColor());
			}
		}
	}

	public abstract DPoint getValue(double rand, DPoint p);
	
	public abstract int getColor();
}
