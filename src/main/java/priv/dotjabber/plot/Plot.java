package priv.dotjabber.plot;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import priv.dotjabber.plot.function.complex.JuliaSet;
import priv.dotjabber.plot.function.complex.MandelbrotSet;
import priv.dotjabber.plot.function.complex.PointFunction;
import priv.dotjabber.plot.function.fractal.PentagramFunction;
import priv.dotjabber.plot.panel.PlotPanel;

public class Plot extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public static void main(String[] args) {
		JFrame main = new Plot();

		main.getContentPane().add(
				new PlotPanel(new PointFunction())
		);
		
		main.setVisible(true);
		main.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		main.pack();
	}
}
