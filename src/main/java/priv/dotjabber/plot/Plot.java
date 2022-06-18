package priv.dotjabber.plot;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import priv.dotjabber.plot.common.Config;
import priv.dotjabber.plot.function.basic.*;
import priv.dotjabber.plot.function.complex.*;
import priv.dotjabber.plot.function.fractal.*;
import priv.dotjabber.plot.generator.IntSeqGenerator;
import priv.dotjabber.plot.panel.PlotPanel;

public class Plot extends JFrame {

	public static void main(String[] args) {
		JFrame main = new Plot();

		main.getContentPane().add(
				new PlotPanel(new MandelbrotSet(new IntSeqGenerator(0, 1, 80)))
		);
		
		main.setVisible(true);
		main.setPreferredSize(new Dimension(Config.WIDTH, Config.HEIGHT));
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		main.pack();
	}
}
