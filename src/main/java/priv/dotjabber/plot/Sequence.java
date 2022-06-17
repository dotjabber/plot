package priv.dotjabber.plot;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import priv.dotjabber.plot.common.Config;
import priv.dotjabber.plot.function.complex.JuliaSet;
import priv.dotjabber.plot.panel.SequencePanel;

public class Sequence extends JFrame {
	public static void main(String[] args) {
		JFrame main = new Sequence();

		main.getContentPane().add(
				new SequencePanel(JuliaSet.class, -1.0, 0.01)
		);
		
		main.setVisible(true);
		main.setPreferredSize(new Dimension(Config.WIDTH, Config.HEIGHT));
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		main.pack();
	}
}
