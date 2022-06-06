package priv.dotjabber.plot.panel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import priv.dotjabber.plot.function.PlotFunction;
import priv.dotjabber.plot.point.IPoint;

public class SequencePanel extends JPanel {
	private static final double SCALE_FACTOR_DEFAULT = 0.0027968216246636525;
	private static final double scale = SCALE_FACTOR_DEFAULT;
	
	private BufferedImage bufferedPlot;
	private PlotFunction plotFunction;
	
	private double currentParam;

	private final IPoint zeroPoint;
	private int height;
	private int width;
	
	public SequencePanel(final Class<? extends PlotFunction> plotClass, double start, 
			final double step) {
		
		zeroPoint = new IPoint();
		currentParam = start;
		try {
			plotFunction = plotClass.getDeclaredConstructor().newInstance();
			plotFunction.setParameters(start);
			
		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}

		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UP");
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DOWN");
		
		getActionMap().put("UP", new AbstractAction("UP") {

			@Override
			public void actionPerformed(ActionEvent evt) {
				currentParam += step;
				update();
			}
		});
		
		getActionMap().put("DOWN", new AbstractAction("DOWN") {

			@Override
			public void actionPerformed(ActionEvent evt) {
				currentParam -= step;
				update();
			}
		});
		
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent evt) {
				height = getHeight();
				if(height == 0) height = 1;
				
				width = getWidth();
				if(width == 0) width = 1;
				
				zeroPoint.x = width / 2;
				zeroPoint.y = height / 2;
				
				if(width > 0 && height > 0) {
					bufferedPlot = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
					update();
				}
			}
			
			@Override
			public void componentResized(ComponentEvent evt) {
				componentShown(evt);
			}
			
			@Override
			public void componentMoved(ComponentEvent evt) {
				componentShown(evt);
			}
			
			@Override
			public void componentHidden(ComponentEvent evt) {
				componentShown(evt);
			}
			
		});
	}
	
	public void update() {
		plotFunction.setParameters(currentParam);
		plotFunction.doPlot(bufferedPlot, zeroPoint, scale);
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bufferedPlot, 0, 0, width, height, this);
	}
}