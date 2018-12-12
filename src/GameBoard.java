
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoard extends JPanel
{
	private static final long serialVersionUID = 1L;
	LightsOutCircle[][] grid;
	
	public GameBoard()
	{
		 //Creates 2D array of LightsOutCircle objects and sets layout to 8x8 grid
		 grid = new LightsOutCircle[8][8];
		 this.setLayout(new GridLayout(8,8));
		 
		 //creates a new lightsoutcircle at each grid location
		 for (int i=0; i < grid.length; i++)
		 {
			    for (int j=0; j < grid[i].length; j++)
			    {
			        grid[i][j] = new LightsOutCircle(i,j);
			    }
		 }
		 
		 //adds each L.O.C. to corresponding spot on the panel
		 for (int i=0; i < grid.length; i++)
		 {
			    for (int j=0; j < grid[i].length; j++)
			    {
			        this.add(grid[i][j]);
			    }
		 }
		 
		 //adds action listener to the panel
		 Listener listener = new Listener();
		 this.addActionListener(listener);
		 
		 return;
	}
	
	public void setAllYellow()
	{
		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				grid[x][y].setYellow();
			}
		}
		
		return;
	}
	
	public int countYellow()
	{
		int count = 0;
		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				if(((LightsOutCircle) grid[x][y]).isYellow())
					count++;
			}
		}
		
		return count;
	}
	
	public int getTotal()
	{
		return (64);
	}
	
	public void reset()
	{
		this.setAllYellow();
		
		return;
	}
	
	public boolean checkWin()
	{
		if(this.countYellow() == 0)
			return true;
		else
			return false;
	}
	
	//When a circle is clicked it toggles the surrounding circles
	class Listener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e)
		{
	        LightsOutCircle sourceBtn = (LightsOutCircle) e.getSource();
	        
	        if(checkWin() == true)
	        	return;
	        
	        /////////////////////////ABOVE////////////////////////
	        try
	        {
		        if(((LightsOutCircle) grid[sourceBtn.row-1][sourceBtn.col]).isBlack() == true)
		        	((LightsOutCircle) grid[sourceBtn.row-1][sourceBtn.col]).setYellow();
		        else
		        	((LightsOutCircle) grid[sourceBtn.row-1][sourceBtn.col]).setBlack();
	        }
	        catch(ArrayIndexOutOfBoundsException b)
	        {
	        	
	        }
	        /////////////////////////BELOW////////////////////////
	        try
	        {
		        if(((LightsOutCircle) grid[sourceBtn.row+1][sourceBtn.col]).isBlack() == true)
		        	((LightsOutCircle) grid[sourceBtn.row+1][sourceBtn.col]).setYellow();
		        else
		        	((LightsOutCircle) grid[sourceBtn.row+1][sourceBtn.col]).setBlack();
	        }
	        catch(ArrayIndexOutOfBoundsException b)
	        {
	        	
	        }
	        /////////////////////////RIGHT////////////////////////
	        try
	        {
		        if(((LightsOutCircle) grid[sourceBtn.row][sourceBtn.col+1]).isBlack() == true)
		        	((LightsOutCircle) grid[sourceBtn.row][sourceBtn.col+1]).setYellow();
		        else
		        	((LightsOutCircle) grid[sourceBtn.row][sourceBtn.col+1]).setBlack();
	        }
	        catch(ArrayIndexOutOfBoundsException b)
	        {
	        	
	        }
	        /////////////////////////LEFT/////////////////////////
	        try
	        {
		        if(((LightsOutCircle) grid[sourceBtn.row][sourceBtn.col-1]).isBlack() == true)
		        	((LightsOutCircle) grid[sourceBtn.row][sourceBtn.col-1]).setYellow();
		        else
		        	((LightsOutCircle) grid[sourceBtn.row][sourceBtn.col-1]).setBlack();
	        }
	        catch(ArrayIndexOutOfBoundsException b)
	        {
	        	
	        }	
	        
	    }
	}
	
	//Adds action listener to each circle
	public void addActionListener(ActionListener listener)
	{
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                grid[x][y].addActionListener(listener);
            }
        }
    }
	
}
