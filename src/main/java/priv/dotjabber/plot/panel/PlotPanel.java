package priv.dotjabber.plot.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.text.MessageFormat;

import javax.swing.JPanel;

import priv.dotjabber.plot.function.PlotFunction;
import priv.dotjabber.plot.point.DPoint;
import priv.dotjabber.plot.point.IPoint;

public class PlotPanel extends JPanel implements ComponentListener, MouseListener, MouseMotionListener, KeyListener, MouseWheelListener {
	private static final int PLOT_STRING_MARGIN = 15;
	
	private static final double SCALE_FACTOR_STEP = 0.2;
	private static final double SCALE_FACTOR_DEFAULT = 0.0027968216246636525;
	
	private BufferedImage bufferedPlot;
	private final PlotFunction[] plotFunctions;
	
	private final DPoint centerPoint;
	private final IPoint zeroPoint;
	
	private final DPoint mousePoint;
	private final IPoint mousePressPoint;
	
	private int height;
	private int width;
	
	private double scale = SCALE_FACTOR_DEFAULT;
	
	private boolean infoPresent;
	
	public PlotPanel(PlotFunction... functions) {
		mousePressPoint = new IPoint();
		mousePoint = new DPoint();
		
		centerPoint = new DPoint();
		zeroPoint = new IPoint();

		addComponentListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
		addKeyListener(this);
		
		setLayout(null);
		setFocusable(true);
		
		plotFunctions = functions;
		componentResized(null);
	}

	@Override
	public void componentHidden(ComponentEvent evt) {
	}

	@Override
	public void componentMoved(ComponentEvent evt) {
	}

	@Override
	public void componentResized(ComponentEvent evt) {
		
		// check the size of component and set buffered image parameters
		height = getHeight();
		if(height == 0) height = 1;
		
		width = getWidth();
		if(width == 0) width = 1;
		
		// set zero point if resized
		if(evt != null) {
			zeroPoint.x = width / 2;
			zeroPoint.y = height / 2;
		}

		// create new image
		bufferedPlot = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		// plot given function
		for(PlotFunction plotFunction : plotFunctions) {
			plotFunction.doPlot(bufferedPlot, zeroPoint, scale);
		}
		
		repaint();
	}

	@Override
	public void componentShown(ComponentEvent evt) {
		componentResized(evt);
	}

	@Override
	public void mouseClicked(MouseEvent evt) {
	}

	@Override
	public void mouseEntered(MouseEvent evt) {
	}

	@Override
	public void mouseExited(MouseEvent evt) {
	}

	@Override
	public void mousePressed(MouseEvent evt) {
		mousePressPoint.x = evt.getX();
		mousePressPoint.y = evt.getY();
	}

	@Override
	public void mouseReleased(MouseEvent evt) {
	}

	@Override
	public void mouseDragged(MouseEvent evt) {
		zeroPoint.x += (evt.getX() - mousePressPoint.x); 
		zeroPoint.y += (evt.getY() - mousePressPoint.y); 

		mousePressed(evt);
		mouseMoved(evt);
		componentResized(null);
		
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent evt) {
		mousePoint.x = (evt.getX() - zeroPoint.x) * scale;
		mousePoint.y = (zeroPoint.y - evt.getY()) * scale;
		
		repaint();
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent evt) {
		if(evt.getWheelRotation() > 0) {
			scale += scale * SCALE_FACTOR_STEP;
			
		} else {
			scale -= scale * SCALE_FACTOR_STEP;
		}
		
		componentResized(null);
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
			scale = SCALE_FACTOR_DEFAULT;
			
			zeroPoint.x = width / 2;
			zeroPoint.y = height / 2;
			
			centerPoint.x = 0.0;
			centerPoint.y = 0.0;
		}
		
		// debug mode
		else if(evt.getKeyCode() == KeyEvent.VK_D && evt.getModifiers() == KeyEvent.CTRL_MASK) {
			infoPresent = !infoPresent;
		}
		
		componentResized(null);
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent evt) {
	}

	@Override
	public void keyTyped(KeyEvent evt) {
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(bufferedPlot, 0, 0, width, height, this);
		
		if(infoPresent) {
			g.setColor(Color.WHITE);
			
			// TODO: axis
			
			// mouse point
			String mousePointLabel = MessageFormat.format("mouse: ({0}; {1})", mousePoint.x, mousePoint.y);
			g.drawString(mousePointLabel, PLOT_STRING_MARGIN, height - 2 * PLOT_STRING_MARGIN);
			
			// scale factors
			String scaleXLabel = MessageFormat.format("scale: {0}", scale);
			g.drawString(scaleXLabel, PLOT_STRING_MARGIN, height - 1 * PLOT_STRING_MARGIN);
			
			// center point
			String point = MessageFormat.format("({0}; {1})", centerPoint.x, centerPoint.y);
			g.drawString(point, width / 2 + PLOT_STRING_MARGIN , height / 2 - PLOT_STRING_MARGIN);
		}
	}
}
