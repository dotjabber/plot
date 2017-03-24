package priv.dotjabber.plot.panel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import priv.dotjabber.plot.function.PlotFunction;
import priv.dotjabber.plot.point.IPoint;

public class SequencePanel extends JPanel {
	private static final long serialVersionUID = -4845236115290637699L;

	private static final double SCALE_FACTOR_DEFAULT = 0.0027968216246636525;
	private double scale = SCALE_FACTOR_DEFAULT;
	
	private BufferedImage bufferedPlot;
	private PlotFunction plotFunction;
	
	private double currentParam;

	private IPoint zeroPoint;
	private int height;
	private int width;
	
	public SequencePanel(final Class<? extends PlotFunction> plotClass, double start, 
			final double step) {
		
		zeroPoint = new IPoint();
		currentParam = start;
		try {
			plotFunction = plotClass.newInstance();
			plotFunction.setParameters(start);
			
		} catch (SecurityException e) {
			e.printStackTrace();
			
		} catch (InstantiationException e) {
			e.printStackTrace();
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UP");
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DOWN");
		
		getActionMap().put("UP", new AbstractAction("UP") {
			private static final long serialVersionUID = 8365708838544624242L;

			@Override
			public void actionPerformed(ActionEvent evt) {
				currentParam += step;
				update();
			}
		});
		
		getActionMap().put("DOWN", new AbstractAction("DOWN") {
			private static final long serialVersionUID = 8365708838544624242L;

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