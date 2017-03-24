package priv.dotjabber.plot;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import priv.dotjabber.plot.function.fractal.PentagramFunction;
import priv.dotjabber.plot.panel.PlotPanel;

public class Plot extends JFrame {
	private static final long serialVersionUID = -1574576231541237645L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public static void main(String[] args) {
		JFrame main = new Plot();

		main.getContentPane().add(
				new PlotPanel(new PentagramFunction())
		);
		
		main.setVisible(true);
		main.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		main.pack();
	}
}
