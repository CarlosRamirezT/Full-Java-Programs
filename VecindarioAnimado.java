import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

/*
 * implementar un metodo que dibuje una casa
 * implemetar el cierre de las ventanas
 */

public class VecindarioAnimado extends Applet implements AdjustmentListener{
	
	
	
	public void drawHouse(Graphics g, int x, int y, int width, int height) {
		
		// estructure
		
		g.drawRect(x,y + height / 2, width,height / 2);
		g.drawLine(x,y + height / 2, x + width / 2, y);
		g.drawLine(x + width, y + height / 2, x + width / 2, y);
		
		// windows
		
		g.drawRect(x + width / 5, y + height / 2 + width / 4, width / 4, width / 4);
		g.drawRect(x + width / 5 * 3, y + height / 2 + width / 4, width / 4, width / 4);
		
		g.fillRect(x + width / 5, y + height / 2 + width / 4, width / 4, barraValor);
		g.fillRect(x + width / 5 * 3, y + height / 2 + width / 4, width / 4, barraValor);
	}
	
	private Scrollbar barra;
	private Scrollbar barrax;
	private Scrollbar barray;
	private Scrollbar barraWidth;

	
	private int barraValor;
	private int barraValorx = 10;
	private int barraValory = 10;
	private int barraValorWidth = 200;

	
	public void init() {
		
		barra = new Scrollbar(Scrollbar.VERTICAL,0,1,0,100);
		barrax = new Scrollbar(Scrollbar.HORIZONTAL,0,1,100,1000);
		barray = new Scrollbar(Scrollbar.VERTICAL,0,1,100,1000);
		barraWidth = new Scrollbar(Scrollbar.HORIZONTAL,0,1,100,1000);	
		
		add(barra);
		add(barrax);
		add(barray);
		add(barraWidth);
		
		barra.addAdjustmentListener(this);
		barrax.addAdjustmentListener(this);
		barray.addAdjustmentListener(this);
		barraWidth.addAdjustmentListener(this);
		
	}
	
	public void paint(Graphics g) {
		
		drawHouse(g,barraValorx,barraValory,barraValorWidth,barraValorWidth);
		
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e) {
		
		barraValor = barra.getValue();
		barraValorx = barrax.getValue();
		barraValory = barray.getValue();
		barraValorWidth = barraWidth.getValue();
		repaint();
		
	}

}
