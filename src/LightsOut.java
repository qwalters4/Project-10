import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LightsOut extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		
		GameBoard gb = new GameBoard();
		ControlPanel control = new ControlPanel();
		
		
		JFrame f = new JFrame();
		
		f.setLayout(new BorderLayout());
		f.add(gb, BorderLayout.CENTER);
		f.add(control, BorderLayout.EAST);
		f.setSize(800, 750);
		f.setResizable(false);;
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
}
