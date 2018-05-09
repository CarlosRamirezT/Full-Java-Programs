import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

/*
 * ejercicios sobre el manejo de eventos
 * 
 * 6.1 hacer un applet que convierta los grados Celcius(Centigrados) introducidos con una barra de desplazamiento en grados farenheit
 * 
 * 6.2 
 * 
 * 
 */
public class Eventos6Ejercicios extends Applet implements AdjustmentListener{
	
	// ejercicio 6.1
	
	private Scrollbar barraCentigrados;
	private Label barraCentigradosTitulo;
	private int barraCentigradosValor;
	
	// ejercicio 6.2
	
	private Scrollbar pocoProfunda;
	private Scrollbar muyProfunda;
	private Label pocoProfundaTitle;
	private Label muyProfundaTitle;
	private int pocoProfundaValue;
	private int muyProfundaValue;
	
	// ejercicio 6.3
	
	private Scrollbar xMessage;
	private Scrollbar yMessage;
	
	private int xMessageValue;
	private int yMessageValue;
	
	private Label xMessageTitle;
	private Label yMessageTitle;
	
	// ejercicio 6.4
	
	private Scrollbar ovalWidth;
	private Scrollbar ovalHeight;
	
	private Label ovalWidthTitle;
	private Label ovalHeightTitle;
	
	private int ovalWidthValue;
	private int ovalHeightValue;
	
	// ejercicio 6.5
	
	public void drawTriangle(Graphics g,int x, int y, int width, int height) {
		
		// se dibuja de izquierda a derecha y de arriba hacia abajo
				
		g.drawLine(x , y + height, x + width, y + height);
		g.drawLine(x + width, y, x + width, y + height);
		g.drawLine(x, y + height, x + width, y);
		
		// shown data
		
		double inclinationTriangleValue = height / width;
		
		g.drawString("Tangente " + inclinationTriangleValue, x, y + height  /3);
		g.drawString("Horizontal = " + width, x + width / 3, y + height + 15);
		g.drawString("Vertical = " + height, x + width + 15, y + height / 2);
		
	}
	
	private Scrollbar xTriangle;
	private Scrollbar yTriangle;
	private Scrollbar widthTriangle;
	private Scrollbar heightTriangle;
	
	private Label xTriangleTitle;
	private Label yTriangleTitle;
	private Label widthTriangleTitle;
	private Label heightTriangleTitle;
	
	private int xTriangleValue;
	private int yTriangleValue;
	private int widthTriangleValue;
	private int heightTriangleValue;
	
	// ejercicio 6.6
	
	private Scrollbar circunferencia;
	private int circunferenciaValue;
	private Label circunferenciaLabel;
	
	
	public void init() {
		
		// ejercicio 6.1
		
		barraCentigrados = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
		barraCentigrados.addAdjustmentListener(this);
		add(barraCentigrados);
		
		barraCentigradosTitulo = new Label("Grados Centigrados");
		add(barraCentigradosTitulo);
		
		// ejercicio 6.2
		
		pocoProfunda = new Scrollbar(Scrollbar.VERTICAL, 0,1,0,2);
		pocoProfunda.addAdjustmentListener(this);
		add(pocoProfunda);
		
		pocoProfundaTitle = new Label("Area Poco Profunda");
		add(pocoProfundaTitle);
		
		muyProfunda = new Scrollbar(Scrollbar.VERTICAL, 0,1,0,4);
		muyProfunda.addAdjustmentListener(this);
		add(muyProfunda);
		
		muyProfundaTitle = new Label("Area Muy Profunda");
		add(muyProfundaTitle);
		
		// ejercicio 6.3
		
		xMessage = new Scrollbar(Scrollbar.HORIZONTAL, 15,1,0,1000);
		xMessage.addAdjustmentListener(this);
		add(xMessage);
		
		xMessageTitle = new Label("X Position");
		add(xMessageTitle);
		
		yMessage = new Scrollbar(Scrollbar.VERTICAL, 200,1,0,1000);
		yMessage.addAdjustmentListener(this);
		add(yMessage);
		
		yMessageTitle = new Label("Y Position");
		add(yMessageTitle);
		
		// ejercicio 6.4
		
		ovalWidth = new Scrollbar(Scrollbar.HORIZONTAL, 100,10,0,1000);
		ovalWidth.addAdjustmentListener(this);
		add(ovalWidth);
		
		ovalWidthTitle = new Label("Oval Width");
		add(ovalWidthTitle);
		
		ovalHeight = new Scrollbar(Scrollbar.VERTICAL, 100,10,0,1000);
		ovalHeight.addAdjustmentListener(this);
		add(ovalHeight);
		
		ovalHeightTitle = new Label("Oval Height");
		add(ovalHeightTitle);
		
		// ejercicio 6.5
		
		xTriangle = new Scrollbar(Scrollbar.HORIZONTAL,150,2,0,1000);
		yTriangle = new Scrollbar(Scrollbar.VERTICAL,150,2,0,1000);
		widthTriangle = new Scrollbar(Scrollbar.HORIZONTAL,150,2,0,1000);
		heightTriangle = new Scrollbar(Scrollbar.VERTICAL,150,2,0,1000);
		
		xTriangle.addAdjustmentListener(this);
		yTriangle.addAdjustmentListener(this);
		widthTriangle.addAdjustmentListener(this);
		heightTriangle.addAdjustmentListener(this);
		
		xTriangleTitle = new Label("X Triangle");
		yTriangleTitle = new Label("Y Triangle");
		widthTriangleTitle = new Label("Width Triangle");
		heightTriangleTitle = new Label("Height Triangle");
		
		add(xTriangle);
		add(xTriangleTitle);
		add(yTriangle);
		add(yTriangleTitle);
		add(widthTriangle);
		add(widthTriangleTitle);
		add(heightTriangle);
		add(heightTriangleTitle);
		
		// ejercicio 6.6
		
		circunferencia = new Scrollbar(Scrollbar.HORIZONTAL, 100,10,100,1000);
		circunferencia.addAdjustmentListener(this);
		add(circunferencia);
		
		circunferenciaLabel = new Label("Circunferencia");
		add(circunferenciaLabel);
		
		
	}
	
	public void paint(Graphics g) {
		
		// ejercicio 6.1
		
		g.drawString(barraCentigradosValor + " Grados Centigrados equivalen a " + ((barraCentigradosValor * 9/5) + 32) + " Grados Farenheit", 15,50);
		
		// ejercicio 6.2
		
		g.drawString(pocoProfundaValue + " Mts",30,95);
		g.drawString(muyProfundaValue + " Mts",130,95);
		g.drawString("Volumen " + ((pocoProfundaValue + muyProfundaValue)/2 * 5 * 20) + " Mts3",15,160);
		
		g.drawRect(15,80,200,50);
		
		// ejercicio 6.3
		
		g.drawString("ahora me encuentro en " + xMessageValue + " , " + yMessageValue, xMessageValue, yMessageValue);
		
		// ejercicio 6.4
		
		g.setColor(Color.blue);
		g.fillOval(15, 300, ovalWidthValue, ovalHeightValue);
		g.setColor(Color.black);
		g.drawString(ovalWidthValue + " , " + ovalHeightValue, 15 + ovalWidthValue / 3, 300 + ovalHeightValue / 2);
		
		// ejercicio 6.5
		
		drawTriangle(g,xTriangleValue,yTriangleValue,widthTriangleValue,heightTriangleValue);
		
		// ejercicio 6.6
		
		g.setColor(Color.green);
		g.fillOval(15,400,circunferenciaValue,circunferenciaValue);
		g.setColor(Color.black);
		g.drawString("Circunferencia " + circunferenciaValue + " Diametro " + (circunferenciaValue / (float)Math.PI), 15 + (circunferenciaValue / 2), 400 + (circunferenciaValue / 2));
		
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e) {
		
		// ejercicio 6.1
		
		barraCentigradosValor = barraCentigrados.getValue();
		
		// ejercicio 6.2
		
		pocoProfundaValue = pocoProfunda.getValue();
		muyProfundaValue = muyProfunda.getValue();
		
		// ejercicio 6.3
		
		xMessageValue = xMessage.getValue();
		yMessageValue = yMessage.getValue();
		
		// ejercicio 6.4
		
		ovalWidthValue = ovalWidth.getValue();
		ovalHeightValue = ovalHeight.getValue();
		
		// ejercicio 6.5
		
		xTriangleValue = xTriangle.getValue();
		yTriangleValue = yTriangle.getValue();
		widthTriangleValue = widthTriangle.getValue();
		heightTriangleValue = heightTriangle.getValue();
		
		// ejercicio 6.6
		
		circunferenciaValue = circunferencia.getValue();
		
		// general repaint call
		
		repaint();
		
	}


}
