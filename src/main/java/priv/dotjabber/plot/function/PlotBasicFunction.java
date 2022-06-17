package priv.dotjabber.plot.function;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import priv.dotjabber.plot.point.IPoint;

public abstract class PlotBasicFunction extends PlotFunction {

	@Override
	public void doPlot(BufferedImage image, IPoint zeroPoint, double scale) {
		Graphics2D g = (Graphics2D) image.getGraphics();
		
		Color c = new Color(getColor());
		g.setColor(c);
		
		int pi = Integer.MIN_VALUE;
		int pj = Integer.MIN_VALUE;
		
		for(int i = 0; i < image.getWidth(); i++) {
			double x1 = (i - zeroPoint.x) * scale;
			double y1 = -getValue(x1);
			
			int j = (int)(y1 / scale) + zeroPoint.y;

			if(pi > Integer.MIN_VALUE) {
				g.drawLine(pi, pj, i, j);
			}
			
			pi = i;
			pj = j;
		}
	}
	
	public abstract double getValue(double x);
	
	public abstract int getColor();
}
