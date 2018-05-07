import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

/*
crear un metodo que dibuje un arco recibiendo como parametros la posicion de x,la posicion de y, el ancho y la altura

crear una barra que devuelva el valor de x y width y height y que esta llame al metodo de dibujar el arco
*/

public class TiroAlBlanco extends Applet implements AdjustmentListener{

	public void drawTiroAlBlanco (Graphics g ,int x,int y,int width){

		// measures for the arc itself
		
		// <<<<<<< change these values to produce the arc >>>>>>>
		
		int xArc = x;
		int yArc = y;
		int widthArc = width;
		int heightArc = width;
		
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		int widthGrowth = widthArc / 4; //100
		int heightGrowth = heightArc / 4;
		
		int distancex = widthArc / 8;
		int distancey = heightArc / 8;
		
		int distanceMiddlex = (distancex / 2) - 5;
		int distanceMiddley = (distancey / 2) + 5;
		
		int distanceMovementx = widthArc / 8;
		int distanceMovementy = heightArc / 8;
		
		// measures for the first arc
		
		
		int xo1 = xArc;
		int yo1 = yArc;
		int widtho1 = widthArc;
		int heighto1 = heightArc;
		
		g.setColor(Color.blue);
		g.fillOval(xo1,yo1,widtho1,heighto1);
		
		// measures for the second arc
		
		int xo2 = xArc + distanceMovementx;
		int yo2 = yArc + distanceMovementy;
		int widtho2 = widthArc - widthGrowth;
		int heighto2 = heightArc - heightGrowth;
		
		g.setColor(Color.yellow);
		g.fillOval(xo2,yo2,widtho2,heighto2);
		
		// measures for the third arc
		
		int xo3 = xArc + distanceMovementx * 2;
		int yo3 = yArc + distanceMovementx * 2;
		int widtho3 = widthArc - (widthGrowth * 2);
		int heighto3 = heightArc - (heightGrowth * 2);
		
		g.setColor(Color.red);
		g.fillOval(xo3,yo3,widtho3,heighto3);
		
		// measures for the fourth arc
		
		int xo4 = xArc + distanceMovementx * 3;
		int yo4 = yArc + distanceMovementx * 3;
		int widtho4 = widthArc - (widthGrowth *3);
		int heighto4 = heightArc - (heightGrowth * 3);
		
		g.setColor(Color.black);
		g.fillOval(xo4,yo4,widtho4,heighto4);
		
		// numbers coordinates		
		
		// horizontal and vertical line position
		
		int yNum100 = (heightArc / 2 + 4) + yArc;
		
		// center
		
		int xNum100Center = (widthArc / 2 - 10) + xArc;
		
		// from the center to the left
		
		int xNum50Left = xArc + (distancex * 2) + distanceMiddlex;
		int xNum25Left = xArc + (distancex) + distanceMiddlex;
		int xNum10Left = xArc + distanceMiddlex;
		
		// from the center to the right
		
		int xNum50Right = xArc + (distancex * 5) + distanceMiddlex;
		int xNum25Right = xArc + (distancex *6) + distanceMiddlex;
		int xNum10Right = xArc + (distancex * 7) + distanceMiddlex;
		
		// from the center to the top
		
		int yNum50Top = yArc + (distancey * 2) + distanceMiddley;
		int yNum25Top = yArc + (distancey) + distanceMiddley;
		int yNum10Top = yArc + distanceMiddley;
		
		// from the center to the bottom
		
		int yNum50Bottom = yArc + (distancey * 5) + distanceMiddley;
		int yNum25Bottom = yArc + (distancey *6) + distanceMiddley;
		int yNum10Bottom = yArc + (distancey  * 7) + distanceMiddley;
		
		// drawing the Strings
		
		g.setColor(Color.white);
		
		// center
		
		g.drawString("100",xNum100Center,yNum100);
		
		// from the center to the left
		
		g.drawString("50",xNum50Left,yNum100);
		g.drawString("10",xNum10Left,yNum100);
		
		// from the center to the right
		
		g.drawString("50",xNum50Right,yNum100);
		g.drawString("10",xNum10Right,yNum100);
		
		// from the center to the top
		
		g.drawString("50",xNum100Center,yNum50Top);
		g.drawString("10",xNum100Center,yNum10Top);
		
		// from the center to the bottom
		
		g.drawString("50",xNum100Center,yNum50Bottom);
		g.drawString("10",xNum100Center,yNum10Bottom);
		
		// drawing on the yellow area with black color
		
		g.setColor(Color.black);
		g.drawString("25",xNum25Left,yNum100);
		g.drawString("25",xNum25Right,yNum100);
		g.drawString("25",xNum100Center,yNum25Top);
		g.drawString("25",xNum100Center,yNum25Bottom);
		

	}

	private Scrollbar barrax;
	private Scrollbar barray;
	private Scrollbar barraWidth;
	

	private int barraxValue = 0;
	private int barrayValue = 25;
	private int barraWidthValue = 50;
	

	public void init(){
		barrax = new Scrollbar(Scrollbar.HORIZONTAL,0,1,50,800);
		barray = new Scrollbar(Scrollbar.HORIZONTAL,40,1,50,800);
		barraWidth = new Scrollbar(Scrollbar.HORIZONTAL,80,1,50,800);
		

		add(barrax);
		add(barray);
		add(barraWidth);
		

		barrax.addAdjustmentListener(this);
		barray.addAdjustmentListener(this);
		barraWidth.addAdjustmentListener(this);;
		

	}

	public void paint(Graphics g){
		g.drawString("x = " + barraxValue, 0, 15);
		g.drawString("y = " + barrayValue, 60, 15);
		g.drawString("Width = " + barraWidthValue, 120, 15);
		

		drawTiroAlBlanco(g,barraxValue,barrayValue,barraWidthValue);
	}

	public void adjustmentValueChanged(AdjustmentEvent e){
		barraxValue = barrax.getValue();
		barrayValue = barray.getValue();
		barraWidthValue = barraWidth.getValue();
		

		repaint();
	}


}