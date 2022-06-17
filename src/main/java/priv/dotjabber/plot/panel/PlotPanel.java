package priv.dotjabber.plot.panel;

import java.awt.*;
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

import lombok.extern.log4j.Log4j2;
import priv.dotjabber.plot.function.PlotFunction;
import priv.dotjabber.plot.point.DPoint;
import priv.dotjabber.plot.point.IPoint;

@Log4j2
public class PlotPanel extends JPanel implements ComponentListener, MouseListener, MouseMotionListener, KeyListener, MouseWheelListener {
	private static final int PLOT_STRING_MARGIN = 15;
	
	private static final double SCALE_FACTOR_STEP = 0.2;
	private static final double SCALE_FACTOR_DEFAULT = 0.0027968216246636525;

	private static final int CENTER_DOT_SIZE = 6;
	
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
		log.debug("PlotPanel()");

		plotFunctions = functions;

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

		componentResized(null);
	}

	@Override
	public void componentHidden(ComponentEvent evt) {
		log.debug("componentHidden(evt)");

		componentResized(null);
	}

	@Override
	public void componentMoved(ComponentEvent evt) {
		log.debug("componentMoved(evt)");

		componentResized(null);
	}

	@Override
	public void componentResized(ComponentEvent evt) {
		log.debug("componentResized(evt)");
		
		// check the size of component and set buffered image parameters
		height = getHeight();
		if(height == 0) height = 1;

		width = getWidth();
		if(width == 0) width = 1;

		// init position
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
		log.debug("componentShown(evt)");

		componentResized(null);
	}

	@Override
	public void mouseClicked(MouseEvent evt) {
		log.debug("mouseClicked(evt)");
	}

	@Override
	public void mouseEntered(MouseEvent evt) {
		log.debug("mouseEntered(evt)");
	}

	@Override
	public void mouseExited(MouseEvent evt) {
		log.debug("mouseExited(evt)");
	}

	@Override
	public void mousePressed(MouseEvent evt) {
		log.debug("mousePressed(evt)");

		mousePressPoint.x = evt.getX();
		mousePressPoint.y = evt.getY();
	}

	@Override
	public void mouseReleased(MouseEvent evt) {
		log.debug("mouseReleased(evt)");
	}

	@Override
	public void mouseDragged(MouseEvent evt) {
		log.debug("mouseDragged(evt)");

		zeroPoint.x += (evt.getX() - mousePressPoint.x); 
		zeroPoint.y += (evt.getY() - mousePressPoint.y); 

		centerPoint.x = (zeroPoint.x - getWidth() / 2.0) * scale;
		centerPoint.y = (zeroPoint.y - getHeight() / 2.0) * scale;

		mousePressed(evt);
		mouseMoved(evt);
		componentResized(null);
		
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent evt) {
		log.debug("mouseMoved(evt)");

		mousePoint.x = (evt.getX() - zeroPoint.x) * scale;
		mousePoint.y = (zeroPoint.y - evt.getY()) * scale;

		repaint();
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent evt) {
		log.debug("mouseWheelMoved(evt)");

		if(evt.getWheelRotation() > 0) {
			scale += scale * SCALE_FACTOR_STEP;
			
		} else {
			scale -= scale * SCALE_FACTOR_STEP;
		}

		zeroPoint.x = (int) (centerPoint.x / scale) + getWidth() / 2;
		zeroPoint.y = (int) (centerPoint.y / scale) + getHeight() / 2;

		componentResized(null);
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		log.debug("keyPressed(evt)");

		if(evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
			scale = SCALE_FACTOR_DEFAULT;
			
			zeroPoint.x = width / 2;
			zeroPoint.y = height / 2;
			
			centerPoint.x = 0;
			centerPoint.y = 0;
		}
		
		// debug mode
		else if(evt.getKeyCode() == KeyEvent.VK_D && evt.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK) {
			infoPresent = !infoPresent;
		}
		
		componentResized(null);
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent evt) {
		log.debug("keyReleased(evt)");
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		log.debug("keyTyped(evt)");
	}
	
	@Override
	public void paint(Graphics g) {
		log.debug("paint(g)");

		Graphics2D g2d = (Graphics2D) g;

		super.paint(g2d);

		//Set  anti-alias!
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// Set anti-alias for text
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		g2d.drawImage(bufferedPlot, 0, 0, width, height, this);
		
		if(infoPresent) {
			g2d.setColor(Color.WHITE);

			// mouse point
			g2d.drawString(
					MessageFormat.format("mouse: ({0,number,#.####}; {1,number,#.####})", mousePoint.x, mousePoint.y),
					PLOT_STRING_MARGIN, height - 3 * PLOT_STRING_MARGIN
			);
			
			// scale factors
			g2d.drawString(
					MessageFormat.format("scale: {0,number,#.####}", scale),
					PLOT_STRING_MARGIN, height - 2 * PLOT_STRING_MARGIN
			);

			// zero point
			g2d.drawString(
					MessageFormat.format("zero: ({0}; {1})", zeroPoint.x, zeroPoint.y),
					PLOT_STRING_MARGIN, height - PLOT_STRING_MARGIN
			);
			
			// center point
			g2d.drawString(
					MessageFormat.format("({0,number,#.####}; {1,number,#.####})", centerPoint.x, centerPoint.y),
					width / 2 + PLOT_STRING_MARGIN , height / 2 - PLOT_STRING_MARGIN
			);

			// center point dot
			g2d.drawOval(width / 2, height / 2, CENTER_DOT_SIZE, CENTER_DOT_SIZE);
		}
	}
}
