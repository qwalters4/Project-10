import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class LightsOutCircle extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color currentColor = Color.yellow;
	public final int row;
	public final int col;
	
	public LightsOutCircle(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		setContentAreaFilled(false);
	}
	public boolean isYellow()
	{
		return currentColor == Color.yellow;
	}
	public boolean isBlack()
	{
		return currentColor == Color.black;
	}
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		// Enable antialiasing for shapes
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Draw a border
		g2d.setBackground(Color.black);
		g2d.setColor(Color.black);
		g2d.fillOval(4,4,getWidth()-8,getHeight()-8);
		
		// draw the current color
		g2d.setBackground(currentColor);
		g2d.setColor(currentColor);
		g2d.fillOval(4,4,getWidth()-10,
				getHeight()-10);
	}
	public void setYellow()
	{
		currentColor = Color.yellow;
		this.setBackground(currentColor);
	}

	public void setBlack()
	{
		currentColor = Color.black;
		this.setBackground(currentColor);

	}
}