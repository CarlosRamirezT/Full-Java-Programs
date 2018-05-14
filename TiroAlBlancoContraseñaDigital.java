import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
 * ejercicio 7.6 escribir un programa que actue como el candado de combinacion digital de una caja de seguridad. 
 * 
 * crear tres botones que representen los numeros del 0 al 9
 * crear un boton para intentar de nuevo que reinicie los valores ingresados
 * crear un campo de texto para mostrar las cifras ingresadas actualmente e interactuar con el usuario
 * crear un boton para cambiar la combinacion
 * el usuario debe hacer clic en los botones correctos
 * felicitar al usuario con un mensaje apropiado si adivina la combinacion
 * 
 */

public class TiroAlBlancoContraseñaDigital extends Applet implements ActionListener,AdjustmentListener {
	
	/*
	 * 
	 */
	
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
	
	private Button cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,intentarNuevamente,changePassword,ok,delete,lock,actions;
	private TextField screen;
	private int secretPassword, combination;
	private String screenValue;
	private String route;
	private boolean state;

	
	public void init() {
		
		screen = new TextField(25);
		add(screen);
		
		intentarNuevamente = new Button("Intentar Nuevamente");
		intentarNuevamente.addActionListener(this);
		add(intentarNuevamente);
		
		changePassword = new Button("Cambiar Contraseña");
		changePassword.addActionListener(this);
		add(changePassword);
		
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
		
		delete = new Button("Delete");
		delete.addActionListener(this);
		add(delete);
		
		ok = new Button("Ok");
		ok.addActionListener(this);
		add(ok);
		
		lock = new Button("LOCK");
		lock.addActionListener(this);
		add(lock);
		
		actions = new Button("Actions");
		actions.addActionListener(this);
		add(actions);
		
		barrax = new Scrollbar(Scrollbar.HORIZONTAL,0,1,50,800);
		barray = new Scrollbar(Scrollbar.HORIZONTAL,40,1,50,800);
		barraWidth = new Scrollbar(Scrollbar.HORIZONTAL,80,1,50,800);
		
		barrax.addAdjustmentListener(this);
		barray.addAdjustmentListener(this);
		barraWidth.addAdjustmentListener(this);
		
		add(barrax);
		add(barray);
		add(barraWidth);
		
		
		secretPassword = 12345;
		combination = 0;
		screenValue = "Cambie la combination de fabrica: 00000";
		state = false;
		
		screen.setText("Introduzca la Contraseña");
		
	}
	
	public void paint(Graphics g){
		
		g.drawString("x = " + barraxValue, 50, 300);
		g.drawString("y = " + barrayValue, 50, 315);
		g.drawString("Width = " + barraWidthValue, 50, 330);
	
		drawTiroAlBlanco(g,barraxValue,barrayValue,barraWidthValue);
		
	}

	public void adjustmentValueChanged(AdjustmentEvent e){
		
		if(state == true) {
		
		barraxValue = barrax.getValue();
		barrayValue = barray.getValue();
		barraWidthValue = barraWidth.getValue();
		
		}
		
		repaint();
	}
	
	public void actionPerformed(ActionEvent r) {
		
		if(r.getSource() == cero) {
			combination = combination * 10 + 0;
			screen.setText("Ingresando: " + combination);
			
		}else if(r.getSource() == uno) {
			
			combination = combination * 10 + 1;
			screen.setText("Ingresando: " + combination );
			
		}else if(r.getSource() == dos) {
			
			combination = combination * 10 + 2;
			screen.setText("Ingresando: " + combination );
			
		}else if(r.getSource() == tres) {
			
			combination = combination * 10 + 3;
			screen.setText("Ingresando: " + combination );
			
		}else if(r.getSource() == cuatro) {
			
			combination = combination * 10 + 4;
			screen.setText("Ingresando: " + combination );
			
		}else if(r.getSource() == cinco) {
			
			combination = combination * 10 + 5;
			screen.setText("Ingresando: " + combination );
			
		}else if(r.getSource() == seis) {
			
			combination = combination * 10 + 6;
			screen.setText("Ingresando: " + combination );
			
		}else if(r.getSource() == siete) {
			
			combination = combination * 10 + 7;
			screen.setText("Ingresando: " + combination );
			
		}else if(r.getSource() == ocho) {
			
			combination = combination * 10 + 8;
			screen.setText("Ingresando: " + combination );
			
		}else if(r.getSource() == nueve) {
			
			combination = combination * 10 + 9;
			screen.setText("Ingresando: " + combination );
			
		}else if(r.getSource() == intentarNuevamente) {
			
			combination = 0;
			screen.setText("Ingrese la Contraseña");
			screen.setText("Ingresando: " + combination );
		
		}else if(r.getSource() == changePassword) {
				
			if(state == true) {
				
				route = "changePassword";
				combination = 0;
				screen.setText("Introduzca Nueva Contraseña");
				
				
			}else {
				
				screen.setText("Primero Desbloquee");
				
			}
				
				
		}else if(r.getSource() == ok) {
			
			if(route == "changePassword") {
				
				secretPassword = combination;
				route = "nochangePassword";
				state = false;
				combination = 0;
				
				
			}

			if(combination == secretPassword) {
				
				screen.setText("UNLOCK");
				state = true;
				combination = 0;
		
				
			}else {
				
				screen.setText("LOCK");
				state = false;
				combination = 0;
				
			}
				

					
		}else if(r.getSource() == delete) {
			
			combination = combination / 10;
			screen.setText("Ingresando: " + combination );
			
		}else if(r.getSource() == lock) {
			
			state = false;
			combination = 0;
			screen.setText("LOCK");
			
			
		}else if(r.getSource() == actions) {
			
			if(state == true) {
				screen.setText("UNLOCKED --> ACTIONS");
				

				
			}else {
				screen.setText("LOCKED --> NO ACTIONS");
			}
			
			combination = 0;
			
		}
		
		
			
		repaint();
		
		
		
	}
}

