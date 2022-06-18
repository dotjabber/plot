package priv.dotjabber.plot.function;

import java.awt.image.BufferedImage;

import priv.dotjabber.plot.generator.Generator;
import priv.dotjabber.plot.point.IPoint;

public abstract class PlotFunction {
	private final Generator generator;
	public PlotFunction(Generator generator) {
		this.generator = generator;
	}

	public boolean next() {
		generator.next();
		return generator.hasMore();
	}

	public void previous() {
		generator.previous();
	}

	public Generator getGenerator() {
		return generator;
	}

	public abstract void doPlot(BufferedImage image, IPoint zeroPoint, double scale);
}
