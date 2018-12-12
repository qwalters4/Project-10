import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel
{
	
	JLabel yellowNum;
	JLabel blackNum;
	
	public ControlPanel()
	{
		JLabel yellow;
		JLabel blank1;
		JLabel black;
		JLabel winLabel;
		JLabel blank2;
		JButton reset;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		yellow = new JLabel("Yellow Count");
		yellowNum = new JLabel("0");
		blank1 = new JLabel("");
		black = new JLabel("Black Count");
		blackNum = new JLabel("0");
		winLabel = new JLabel("");
		blank2 = new JLabel("");
		reset = new JButton("Reset");
		MyButtonListener listener = new MyButtonListener();
		reset.addActionListener(listener);
		
		this.add(yellow);
		this.add(yellowNum);
		this.add(blank1);
		this.add(black);
		this.add(blackNum);
		this.add(winLabel);
		this.add(blank2);
		this.add(reset);
		
		return;
	}
	
	public void setNums(int num, int total)
	{
		yellowNum.setText(String.valueOf(num));
		blackNum.setText(String.valueOf(total - num));
	}
}

class MyButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //When reset button is clicked, gameboard's reset() method must be called. But reset() can't be made static
    }
}