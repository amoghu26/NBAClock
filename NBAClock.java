
import java.util.Scanner;
import java.util.Date;
import java.text.*;
import java.awt.*;   // for classes Graphics, Color, Font, Image
import java.awt.event.* ; // for classes KeyListener, MouseListener
import javax.swing.* ; // for classes JFrame, JPanel, JLabel
import java.io.*  ; // for classes File, IOException, ImageIO

public class NBAClock extends JFrame
{      
	public NBAClock()
	{  
		super ("NBAClock.java");
		setSize( 600, 600);    
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
		setLocation(200,100);
		setResizable(true);
		Panel pan = new Panel();   
		setContentPane(pan);  
		setVisible(true);   
	} 


	public static void main (String [] args)   
	{  
		NBAClock obj = new NBAClock(); 
	}

}

class Panel extends JPanel	
{
	Image lebron = new ImageIcon("01_Lebron_james.png").getImage();
	Image kobe = new ImageIcon("09_Kobe_Bryant.jpg").getImage();
	Image patrik = new ImageIcon("34_Patrik_Ewing.jpg").getImage();
	Image kidd = new ImageIcon("38_Jason_Kidd.jpg").getImage();
	int gridWidth;

	final int[][] ZERO = new int[][] {{1,1,1},{1,0,1},{1,0,1},{1,0,1},{1,1,1}};
	final int[][] ONE = new int[][] {{0,0,1},{0,0,1},{0,0,1},{0,0,1},{0,0,1}};
	final int[][] TWO = new int[][] {{1,1,1},{0,0,1},{1,1,1},{1,0,0},{1,1,1}};
	final int[][] THREE= new int[][] {{1,1,1},{0,0,1},{1,1,1},{0,0,1},{1,1,1}};
	final int[][] FOUR= new int[][] {{1,0,1},{1,0,1},{1,1,1},{0,0,1},{0,0,1}};
	final int[][] FIVE= new int[][] {{1,1,1},{1,0,0},{1,1,1},{0,0,1},{1,1,1}};
	final int[][] SIX= new int[][] {{1,1,1},{1,0,0},{1,1,1},{1,0,1},{1,1,1}};
	final int[][] SEVEN= new int[][] {{1,1,1},{0,0,1},{0,0,1},{0,0,1},{0,0,1}};
	final int[][] EIGHT= new int[][] {{1,1,1},{1,0,1},{1,1,1},{1,0,1},{1,1,1}};
	final int[][] NINE= new int[][] {{1,1,1},{1,0,1},{1,1,1},{0,0,1},{0,0,1}};

	public Panel()
	{
		gridWidth = 30;
		setBackground(Color.WHITE);
	}
	public void paintComponent(Graphics g)
	{	

		super.paintComponent(g);
		for(int i = 0; i<600;i+=30) 
		{
			g.setColor(Color.BLACK);    
			g.drawLine(i, 0, i, 600); 
			g.drawLine(0, i, 600, i);   
		}
		g.drawImage(kobe, 6*gridWidth, 4*gridWidth, gridWidth, gridWidth, null);
		g.drawImage(kobe, 6*gridWidth, 6*gridWidth, gridWidth, gridWidth, null);
		draw(g);
	}


	public void draw(Graphics g)
	{
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a");
		String date2 = ft.format (dNow);
		int [] digits = new int [4];
		digits[0] = Integer.parseInt(date2.substring(0,1));
		digits[1] = Integer.parseInt(date2.substring(1,2));
		digits[2] = Integer.parseInt(date2.substring(3,4));
		digits[3] = Integer.parseInt(date2.substring(4,5));

	
		if ( digits [0] == 1)
		{
			if ( digits[1] == 2)
			{
				helper (-2*gridWidth, 3*gridWidth, digits[0], lebron, g);
			}
			else
			{
				helper (-1*gridWidth, 3*gridWidth, digits[0], lebron, g);
			}
		}
		helper (2*gridWidth, 3*gridWidth, digits[1], kobe, g);
		helper (8*gridWidth, 3*gridWidth, digits[2], patrik, g);
		helper (12*gridWidth, 3*gridWidth, digits[3], kidd, g);
	} 



	public void helper(int x, int y, int number, Image player, Graphics g)
	{
		int [][] test = null;
		if ( number == 0 )
		{
			test = ZERO;
		}
		if (number == 1 )
		{
			test = ONE;
		}
		if (number == 2 )
		{
			test = TWO;
		}
		if (number == 3 )
		{
			test = THREE;
		}
		if (number == 4 )
		{
			test = FOUR;
		}
		if (number == 5 )
		{
			test = FIVE;
		}
		if (number == 6 )
		{
			test = SIX;
		}
		if (  number == 7)
		{
			test = SEVEN;
		}
		if ( number == 8 )
		{
			test = EIGHT;
		}
		if (  number == 9)
		{
			test = NINE;
		}		
		for( int rows = 0; rows< test.length; rows++)
		{
			for ( int columns = 0; columns< test[0].length; columns++)
			{
				if ( test [rows][columns] ==1)
				{
					g.drawImage(player, columns*gridWidth+x, rows*gridWidth+y, gridWidth, gridWidth, null);
				}
			}
		}
		}
	}







