import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


/*
 * ejercicio 7.1
 * 
 * escriba unprograma para mostrar un numero aleatorio cade vez que se oprima un boton etiquetado como siguiente
 * 
 * mostrar
 * 
 * numero aleatori obtenifo al invocar Math.random
 * entero aleatorio el e rngo del 1 al 10
 * entero aleatorio en el rango de 0 1 100
 * un valor booleano aleatorio
 */

/*
 * ejrecicio 7.2
 * 
 * crear un applet que genere un naipe al azar
 * 
 * crear el boton
 * generar el tipo de naipe
 * generar el numero del naipe
 * imprimir numeo y tipo de naipe
 */

/*
 * ejercicio 7.3 introducir tres numeros mediante tres barras de desplazamiento
 * ordenarlos de menor a mayor
 * imprimir los numeros en pantalla
 */

/*
 * ejercicio 7.4
 * 
 * escriba un provrama para averguar cuanto paga una persona por ir al cine el programa debe introducir una edad mediante unabarra de desplazamiento o un campo de texto y luego decivir en vase a lo siguiente
 * 
 * menor de 5 gratis
 * de 5 a 12 paga la mitad
 * de 13 a 54 precio normal
 * de 55 o mayor gratis
 */

/*
 * ejercicio 7.5
 * 
 * apostando en baso a los numeros obtenidos al tirar tres veces el dado, una persona apuesta 1 para predecir el resultado de los tres tiros.
 * escriba el programa que utilice el metodo de numeros aleatorios para simular los tres tiros del dado y mostrar las ganancias
 * de acuerdo con las siguientes reglas
 * 
 * si los tres tiros son seis gana 20 por cada peso apostado
 * si los tres tiros son iguales pero no seis gana 10 por cada peso apostado
 * si dos de los tres tiros son iguales gana 5
 */

public class Decisiones7EjerciciosFinal extends Applet implements ActionListener,AdjustmentListener {
	
	// ejercicio 7.1
	
	private Button randomNumber;
	private double randomNumberValue1;
	private int randomNumberValue3;
	private int randomNumberValue4;
	
	// ejercicio 7.2
	
	private Button naipe;
	private String naipeType;
	private char naipeNumber;
	private int naipeTypeChoice;
	private int naipeNumberChoice;
	
	// ejercicio 7.2
	
	private Scrollbar num1;
	private Scrollbar num2;
	private Scrollbar num3;
	
	private Button reiniciarNum;
	
	private TextField num1Field;
	private TextField num2Field;
	private TextField num3Field;
	
	private int num1Value;
	private int num2Value;
	private int num3Value;
	
	private int firstValue;
	private int secondValue;
	private int thirdValue;
	
	private Label num1Label;
	private Label num2Label;
	private Label num3Label;
	
	// 
	
	private Button reiniciarTodo;
	
	// ejercicio 7.4
	
	private Scrollbar edadEntradaCine;
	private Label edadEntradaCineLabel;
	private TextField edadEntradaCineField;
	private int edadEntradaCineValue;
	private TextField precioBoleta;
	private int precioBoletaValue;
	private Button edadEntradaCineReiniciar;
	
	// ejercicio 7.5
	
	private Button tirarDados;
	private TextField apuesta;
	private Scrollbar apuestaBar;
	private int dado1Value;
	private int dado2Value;
	private int dado3Value;
	private int apuestaValue;
	private int ganancia;
	

	
	public void init() {
		
		// ejercicio 7.1
		
		randomNumber = new Button("Siguiente");
		randomNumber.addActionListener(this);
		add(randomNumber);
		
		// ejercicio 7.2
		
		naipe = new Button("Generar Naipe");
		naipe.addActionListener(this);
		add(naipe);
		
		// ejercicio 7.3
		
		num1 = new Scrollbar(Scrollbar.VERTICAL,0,1,0,100);
		num2 = new Scrollbar(Scrollbar.VERTICAL,0,1,0,100);
		num3 = new Scrollbar(Scrollbar.VERTICAL,0,1,0,100);
		
		reiniciarNum = new Button("Reiniciar Numeros");
		
		num1Field = new TextField(10);
		num2Field = new TextField(10);
		num3Field = new TextField(10);
		
		num1Label = new Label("Numero 1");
		num2Label = new Label("Numero 2");
		num3Label = new Label("Numero 3");
		
		num1.addAdjustmentListener(this);
		num2.addAdjustmentListener(this);
		num3.addAdjustmentListener(this);
		
		num1Field.addActionListener(this);
		num2Field.addActionListener(this);
		num3Field.addActionListener(this);
		
		reiniciarNum.addActionListener(this);
		
		add(num1Label);
		add(num1);
		add(num2Label);
		add(num2);
		add(num3Label);
		add(num3);
		
		add(num1Field);
		add(num2Field);
		add(num3Field);
		
		add(reiniciarNum);
		
		// ejercicio 7.4
		
		edadEntradaCineLabel = new Label("Edad");
		add(edadEntradaCineLabel);
		
		edadEntradaCine = new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,100);
		edadEntradaCine.addAdjustmentListener(this);
		add(edadEntradaCine);
		
		edadEntradaCineField = new TextField(10);
		edadEntradaCineField.addActionListener(this);
		add(edadEntradaCineField);
		
		precioBoleta = new TextField(10);
		precioBoleta.addActionListener(this);
		add(precioBoleta);
		
		edadEntradaCineReiniciar = new Button("Reiniciar Edad");
		edadEntradaCineReiniciar.addActionListener(this);
		add(edadEntradaCineReiniciar);
		
		// ejercicio 7.5
		
		
		
		// general
		
		reiniciarTodo = new Button("Reiniciar Todo");
		reiniciarTodo.addActionListener(this);
		add(reiniciarTodo);
		
	}
	
	public void paint(Graphics g) {
		
		// ejercicio 7.1
		
		g.drawString("El numero aleatorio obtenido de Math.random es: " + randomNumberValue1,50,200);
		g.drawString("El numero entero aleatorio obtenido en el rango del 1 al 10 es: " + randomNumberValue3,50,215);
		g.drawString("El numero entero aleatorio obtenido en el rango del 0 al 100 es: " + randomNumberValue4,50,230);
		
		if((randomNumberValue4 % 2) == 0) {
			g.drawString("El valor booleano obtenido es: " + true,50,260);			
		}else {
			g.drawString("El valor booleano obtenido es: " + false,50,260);
		}
		
		// ejercicio 7.2
		
		g.drawString("El Naipe Obtenido es un < " + naipeNumber + " > de < " + naipeType + " >",50,290);
		
		// ejercicio 7.3 			
		
		if(num1Value < num2Value && num1Value < num3Value) {
			firstValue = num1Value;
			if(num2Value < num3Value) {
				secondValue = num2Value;
				thirdValue = num3Value;
			}else if(num3Value < num2Value) {	
				secondValue = num3Value;
				thirdValue = num2Value;
			}
		}else if(num2Value < num1Value && num2Value < num3Value) { 
			firstValue = num2Value;
			if (num1Value < num3Value) {
				secondValue = num1Value;
				thirdValue = num3Value;
			}else if(num3Value < num1Value) {
				secondValue = num3Value;
				thirdValue = num1Value;
			}else if(num1Value == num3Value) {
				secondValue = num1Value;
				thirdValue = num3Value;
			}
		}else if(num3Value < num1Value && num3Value < num2Value) { 
			firstValue = num3Value;
			if(num1Value < num2Value) {
				secondValue = num1Value;
				thirdValue = num2Value;
			}else if(num2Value < num1Value) {
				secondValue = num2Value;
				thirdValue = num1Value;
			}else if(num1Value == num2Value) {
				secondValue = num1Value;
				thirdValue = num2Value;
			}
		}else if(num1Value == num2Value && num1Value == num3Value) {
			firstValue = num1Value;
			secondValue = num2Value;
			thirdValue = num3Value;
		}else if(num1Value == num2Value) {
			if (num1Value < num3Value && num2Value < num3Value) {
				firstValue = num1Value;
				secondValue = num2Value;
				thirdValue = num3Value;
			}else if(num3Value < num1Value && num3Value < num2Value) {
				firstValue = num3Value;
				secondValue = num1Value;
				thirdValue = num2Value;
			}
		}else if(num2Value == num3Value) {
			if(num1Value < num2Value && num1Value < num3Value) {
				firstValue = num1Value;
				secondValue = num2Value;
				thirdValue = num3Value;
			}else if(num2Value < num1Value && num3Value < num1Value) {
				firstValue = num2Value;
				secondValue = num3Value;
				thirdValue = num1Value;
			}
		}
		
		g.drawString("The value of the Number 1 is: " + num1Value,50,320);
		g.drawString("The value of the Number 2 is: " + num2Value,50,335);
		g.drawString("The value of the Number 3 is: " + num3Value,50,350);
		g.drawString("The Three Values organized are: " + firstValue + " , " + secondValue + " , " + thirdValue,50,365);
		
		// ejercicio 7.4
		
		g.drawString("La edad ingresada es: " + edadEntradaCineValue,50,395);
		
		if(edadEntradaCineValue < 5) {
			g.setColor(Color.green);
			g.drawString("Puede entrar Gratis",50,410);
			g.setColor(Color.black);
			g.drawString("Debe Pagar RD$ " + (double)(precioBoletaValue * 0),50,425);
		}else if(edadEntradaCineValue >= 5 && edadEntradaCineValue <= 12) {
			g.setColor(Color.blue);
			g.drawString("Paga solo la Mitad de Precio",50,410);
			g.setColor(Color.black);
			g.drawString("Debe Pagar RD$ " + precioBoletaValue / 2,50,425);
		}else if(edadEntradaCineValue >= 13 && edadEntradaCineValue <= 54) {
			g.setColor(Color.black);
			g.drawString("Paga el precio Normal",50,410);
			g.setColor(Color.black);
			g.drawString("Debe Pagar RD$ " + (double)(precioBoletaValue * 1),50,425);
		}else if(edadEntradaCineValue >= 55) {
			g.setColor(Color.green);
			g.drawString("Puede entrar Gratis",50,410);
			g.setColor(Color.black);
			g.drawString("Debe Pagar RD$ " + (double)(precioBoletaValue * 0),50,425);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// ejercicio 7.1
		
		if(e.getSource() == randomNumber) {
		
			randomNumberValue1 = Math.random();
			randomNumberValue3 = (int)(randomNumberValue1 * 10) + 1;
			randomNumberValue4 = (int)(randomNumberValue1 * 100) + 1;

		}
		
		// ejercicio 7.2
		
		if(e.getSource() == naipe) {
			
			naipeTypeChoice = (int)(Math.random() * 4) + 1;
			naipeNumberChoice = (int)(Math.random() * 13) + 1;
			
			switch(naipeTypeChoice) {
			
				case 1 : naipeType = "Corazon"; break;
				case 2 : naipeType = "Diamante"; break;
				case 3 : naipeType = "Basto"; break;
				case 4 : naipeType = "Espada"; break;
			
			}
			
			switch(naipeNumberChoice) {
			
				case 1 :  naipeNumber = 'A'; break;
				case 11 : naipeNumber = 'J'; break;
				case 12 : naipeNumber = 'Q'; break;
				case 13 : naipeNumber = 'K'; break;
				
				case 2 : naipeNumber = '2'; break;
				case 3 : naipeNumber = '3'; break;
				case 4 : naipeNumber = '4'; break;
				case 5 : naipeNumber = '5'; break;
				case 6 : naipeNumber = '6'; break;
				case 7 : naipeNumber = '7'; break;
				case 8 : naipeNumber = '8'; break;
				case 9 : naipeNumber = '9'; break;
				case 10 : naipeNumber = 'T'; break;
				
			}		
		}
		
		// ejercicio 7.3
		
		if(e.getSource() == reiniciarNum) {
			num1Value = 0;
			num2Value = 0;
			num3Value = 0;
		}else if(e.getSource() == num1Field) {
			num1Value = Integer.parseInt(num1Field.getText());
			num1.setValue(num1Value);
		}else if(e.getSource() == num2Field) {
			num2Value = Integer.parseInt(num2Field.getText());
			num2.setValue(num2Value);
		}else if(e.getSource() == num3Field) {
			num3Value = Integer.parseInt(num3Field.getText());
			num3.setValue(num3Value);
		}
		
		// general
		
		if(e.getSource() == reiniciarTodo) {
			num1Value = 0;
			num2Value = 0;
			num3Value = 0;
			
			naipeType = " ";
			naipeNumber = 0;
			
			randomNumberValue1 = 0;
			randomNumberValue3 = 0;
			randomNumberValue4 = 0;
			
			edadEntradaCineValue = 0;
		}
		
		if(e.getSource() == edadEntradaCineField) {
			edadEntradaCineValue = Integer.parseInt(edadEntradaCineField.getText());
			edadEntradaCine.setValue(edadEntradaCineValue);
		}else if(e.getSource() == edadEntradaCineReiniciar) {
			edadEntradaCineValue = 0;
			edadEntradaCine.setValue(edadEntradaCineValue);
			edadEntradaCineField.setText("" + 0);
		}else if(e.getSource() == precioBoleta) {
			precioBoletaValue = Integer.parseInt(precioBoleta.getText());
		}
		
		repaint();
		
	}
	
	public void adjustmentValueChanged(AdjustmentEvent r) {
		
		num1Value = num1.getValue();
		num2Value = num2.getValue();
		num3Value = num3.getValue();
		
		if(r.getSource() == edadEntradaCine ) {
			edadEntradaCineValue = edadEntradaCine.getValue();
			edadEntradaCineField.setText("" + edadEntradaCineValue);
		}
		
		repaint();
		
	}

}
