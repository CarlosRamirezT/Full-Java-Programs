import java.awt.Graphics;
import java.applet.Applet;

public class drawIsoceles extends Applet {
	
	private void drawIsoceles(Graphics g, int x, int y, int width, int height) {
		
		// MI METODO PARA TRINAGULO ISOCELES
		
		/* argumentos que recive
		
		int x = 500;
		int y = 0;
		int width = 200;
		int height = 200; 
		
		*/
		
		// dibujando un trinagulo isoceles. dos lados iguales con una base plana
		
		// base
		
		int xBase = x;
		int yBase = y + height;
		int xBase2 = x + width;
		int yBase2 = y + height;
		
		// left
		
		int xLeft = xBase;
		int yLeft = yBase;
		int xLeft2 = x + (width / 2);
		int yLeft2 = y + (height / 2);
		
		// right
		
		int xRight = xBase2;
		int yRight = yBase2;
		int xRight2 = xLeft2;
		int yRight2 = yLeft2;
		
		
		// base
		
		g.drawLine(xBase,yBase,xBase2,yBase2);
		
		// left

		
		g.drawLine(xLeft,yLeft,xLeft2,yLeft2);		
		
		// right
		
		g.drawLine(xRight,yRight,xRight2,yRight2);
		
	}
	
	public void paint(Graphics g) {
		
		drawIsoceles(g,10,10,100,100);
	}

}
