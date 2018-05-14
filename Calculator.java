
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
 * crear una calculadora
 */

public class Calculator extends Applet implements ActionListener {
	
	/*
	 * 
	 */
	
	private TextField screen;
	private Button cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,del,ac,multiplicar,dividir,sumar,restar,igual;
	private int num1,num2,result;
	private int screenValue;
	private String operationValue;
		
	public void init() {
		
		screen = new TextField(25);
		add(screen);
		
		cero = new Button("0");
		cero.addActionListener(this);
		add(cero);
		
		uno = new Button("1");
		uno.addActionListener(this);
		add(uno);
		
		dos = new Button("2");
		dos.addActionListener(this);
		add(dos);
		
		tres = new Button("3");
		tres.addActionListener(this);
		add(tres);
		
		cuatro = new Button("4");
		cuatro.addActionListener(this);
		add(cuatro);
		
		cinco = new Button("5");
		cinco.addActionListener(this);
		add(cinco);
		
		seis = new Button("6");
		seis.addActionListener(this);
		add(seis);
		
		siete = new Button("7");
		siete.addActionListener(this);
		add(siete);
		
		ocho = new Button("8");
		ocho.addActionListener(this);
		add(ocho);
		
		nueve = new Button("9");
		nueve.addActionListener(this);
		add(nueve);
		
		del = new Button("DEL");
		del.addActionListener(this);
		add(del);
		
		ac = new Button("AC");
		ac.addActionListener(this);
		add(ac);
		
		multiplicar = new Button("X");
		multiplicar.addActionListener(this);
		add(multiplicar);
		
		dividir = new Button("/");
		dividir.addActionListener(this);
		add(dividir);
		
		sumar = new Button("+");
		sumar.addActionListener(this);
		add(sumar);
		
		restar = new Button("-");
		restar.addActionListener(this);
		add(restar);
		
		igual = new Button("=");
		igual.addActionListener(this);
		add(igual);
		
		operationValue = "";
		screenValue = 0;
		num1 = 0;
		num2 = 0;
		result = 0;		
		
	}
	
	public void paint(Graphics g) {
		
		
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e) {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,del,ac,multiplicar,dividir,sumar,restar,igual
		
		
		if(e.getSource() == uno) {
			
			
			if (operationValue == "") {
				
				num1 = num1 * 10 + 1;
				
			}else if(operationValue != "") {
				
				num2 = num2 * 10 + 1;
				
			}
			
			
		}else if(e.getSource() == dos) {
			
			if (operationValue == "") {
				
				num1 = num1 * 10 + 2;
				
			}else if(operationValue != "") {
				
				num2 = num2 * 10 + 2;
				
			}
		
		}else if(e.getSource() == tres) {
			
			if (operationValue == "") {
				
				num1 = num1 * 10 + 3;
				
			}else if(operationValue != "") {
				
				num2 = num2 * 10 + 3;
				
			}
		
		}else if(e.getSource() == cuatro) {
			
			if (operationValue == "") {
				
				num1 = num1 * 10 + 4;
				
			}else if(operationValue != "") {
				
				num2 = num2 * 10 + 4;
				
			}
		
		}else if(e.getSource() == cinco) {
			
			if (operationValue == "") {
				
				num1 = num1 * 10 + 5;
				
			}else if(operationValue != "") {
				
				num2 = num2 * 10 + 5;
				
			}
		
		}else if(e.getSource() == seis) {
			
			if (operationValue == "") {
				
				num1 = num1 * 10 + 6;
				
			}else if(operationValue != "") {
				
				num2 = num2 * 10 + 6;
				
			}
		
		}else if(e.getSource() == siete) {
			
			if (operationValue == "") {
				
				num1 = num1 * 10 + 7;
				
			}else if(operationValue != "") {
				
				num2 = num2 * 10 + 7;
				
			}
		
		}else if(e.getSource() == ocho) {
			
			if (operationValue == "") {
				
				num1 = num1 * 10 + 8;
				
			}else if(operationValue != "") {
				
				num2 = num2 * 10 + 8;
				
			}
		
		}else if(e.getSource() == nueve) {
			
			if (operationValue == "") {
				
				num1 = num1 * 10 + 9;
				
			}else if(operationValue != "") {
				
				num2 = num2 * 10 + 9;
				
			}
		
		}else if(e.getSource() == del) {
			
			if (operationValue == "") {
				
				num1 = num1 / 10;
				
			}else if(operationValue != "") {
				
				num2 = num2 / 10;
				
			}
			
		}else if(e.getSource() == ac) {
			
			operationValue = "";
			screenValue = 0;
			num1 = 0;
			num2 = 0;
			result = 0;		
			
		}else if(e.getSource() == multiplicar) {
			
			operationValue = "x";
		
			
		}else if(e.getSource() == dividir) {
			
			operationValue = "/";
		
			
		}else if(e.getSource() == sumar) {
			
			operationValue = "+";
		
			
		}else if(e.getSource() == restar) {
			
			operationValue = "-";
	
			
		}
		
		if(operationValue == "") {
			
			screenValue = num1;
			
		}else if(operationValue != "") {
			
			screenValue = num2;
			
		}
		
		if (operationValue == "x") {
			
			result = num1 * num2;
			
		}else if(operationValue == "/") {
			
			result = num1 / num2;
			
		}else if(operationValue == "+") {
			
			result = num1 + num2;
			
		}else if(operationValue == "-") {
			
			result = num1 - num2;
			
		}
		
		if(e.getSource() == igual) {
		
		screenValue = result;
		
		num1 = 0;
		num2 = 0;
		result = 0;
		operationValue = "";
		
		}
				
		screen.setText("" + screenValue);
		
		
		
	}

}
