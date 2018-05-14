
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

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

public class Decisiones7EjerciciosFinalApuestas extends Applet implements ActionListener,AdjustmentListener{
	
	private Button tirarDados;
	private TextField apuesta;
	private Scrollbar apuestaBar;
	private Label apuestaLabel;
	private int dado1Value;
	private int dado2Value;
	private int dado3Value;
	private int apuestaValue;
	private int ganancia;
	private int dineroActual;
	private int inversionesTotales;
	private int apuestasTotales;
	private int gananciasTotales;
	private int perdidasTotales;
	private int conteoTiro;
	private int conteoGanadox20;
	private int conteoGanadox10;
	private int conteoGanadox5;
	private int conteoPerdido;
	private int apuestaValue2;
	private boolean ok;
	private Button retirarGanancias;
	private Button reiniciarJuego;

	
	public void init() {
		
		tirarDados = new Button("Tirar Dados");
		tirarDados.addActionListener(this);
		add(tirarDados);
		
		apuestaLabel = new Label("Valor de la apuesta");
		add(apuestaLabel);
		
		apuesta = new TextField(10);
		apuesta.addActionListener(this);
		add(apuesta);
		
		apuestaBar = new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,1000000);
		apuestaBar.addAdjustmentListener(this);
		add(apuestaBar);
		
		dineroActual = 0;
		inversionesTotales = 0;
		apuestasTotales = 0;
		gananciasTotales = 0;
		perdidasTotales = 0;
		conteoTiro = 0;
		conteoGanadox20 = 0;
		conteoGanadox10 = 0;
		conteoGanadox5 = 0;
		conteoPerdido = 0;
		ok = true;
		
		retirarGanancias = new Button("Retirar Ganancias");
		retirarGanancias.addActionListener(this);
		add(retirarGanancias);
		
		reiniciarJuego = new Button("Reiniciar Juego");
		reiniciarJuego.addActionListener(this);
		add(reiniciarJuego);
		
		
	}
	
	public void paint(Graphics g) {
		
		apuestaValue2 = apuestaValue;

		
		if(apuestaValue2 > 0 && ok == true) {
	
		
			if(dado1Value == dado2Value && dado1Value == dado3Value) {
				if((dado1Value == 6 && dado2Value == 6) && dado3Value == 6) {
				
				ganancia = apuestaValue * 20;
				g.setColor(Color.green);
				g.drawString("Los Tres Dados son 6",50,360);
				g.drawString("Usted gana: RD$ " + ganancia ,50,375);
				
				dineroActual = dineroActual + ganancia;
				gananciasTotales = gananciasTotales + ganancia;
				conteoGanadox20++;
				
				}
			}else if(dado1Value == dado2Value && dado1Value == dado3Value) {
				
				ganancia = apuestaValue * 10;
				g.setColor(Color.blue);
				g.drawString("Los Tres Dados son iguales pero no 6",50,360);
				g.drawString("Usted gana: RD$ " + ganancia ,50,375);
				
				dineroActual = dineroActual + ganancia;
				gananciasTotales = gananciasTotales + ganancia;
				conteoGanadox10++;
				
			}else if(dado1Value == dado2Value || dado1Value == dado3Value) {
				
				ganancia = apuestaValue * 5;
				g.setColor(Color.orange);
				g.drawString("Solo dos de los tres Dados son iguales",50,360);
				g.drawString("Usted gana: RD$ " + ganancia ,50,375);
				
				dineroActual = dineroActual + ganancia;
				gananciasTotales = gananciasTotales + ganancia;
				conteoGanadox5++;
				
			}else if(dado2Value == dado3Value) {
				
				ganancia = apuestaValue * 5;
				g.setColor(Color.orange);
				g.drawString("Solo dos de los tres Dados son iguales",50,360);
				g.drawString("Usted gana: RD$ " + ganancia ,50,375);
				
				dineroActual = dineroActual + ganancia;
				gananciasTotales = gananciasTotales + ganancia;
				conteoGanadox5++;
				
			}else {
				
				g.setColor(Color.red);
				g.drawString("Los dados son diferentes",50,360);
				g.drawString("Usted No Gana Nada",50,375);
				
				conteoPerdido++;
				perdidasTotales = perdidasTotales - apuestaValue;
				dineroActual = dineroActual - apuestaValue;
				apuestaValue2 = apuestaValue2 - apuestaValue;
				
			}
			
			conteoTiro++;
			
			if(conteoTiro == 1) {
				inversionesTotales = inversionesTotales + apuestaValue;
				dineroActual = dineroActual + apuestaValue;
			}
			
			if (conteoTiro > 1){
				dineroActual = dineroActual - apuestaValue;
				g.drawString("me estoy ejecutando0",500,500);
			}
			
			g.setColor(Color.black);
			g.drawString("Dado 1: " + dado1Value,50,300);
			g.drawString("Dado 2: " + dado2Value,50,315);
			g.drawString("Dado 3: " + dado3Value,50,330);
			g.drawString("El Valor de la Apuesta fue de: " + apuestaValue,50,345);
			
			g.drawString("Estadisticas",400,50);
			g.drawString("Actualmente tiene RD$ " + dineroActual + " en el sistema",400,65);
			g.drawString("Actualmente ha invertido RD$ " + inversionesTotales + " desde fuera del juego",400,80);
			g.drawString("Actualmente ha apostado RD$ " + apuestasTotales,400,95);
			g.drawString("Actualmente ha ganado RD$ " + gananciasTotales,400,110);
			g.drawString("Actualmente ha perdido RD$ " + perdidasTotales,400,125);
			g.drawString("Actualmente ha Tirado los Dados: " + conteoTiro + " veces",400,140);
			g.drawString("Actualmente ha Ganado con Tres Dados Iguales con Valor de Seis: " + conteoGanadox20 + " veces",400,155);
			g.drawString("Actualmente ha Ganado con Tres Dados Iguales sin Valor de Seis: " + conteoGanadox10 + " veces",400,170);
			g.drawString("Actualmente ha Ganado con Dos Dados Iguales: " + conteoGanadox5 + " veces",400,185);
			g.drawString("Actualmente ha Perdido " + conteoPerdido + " veces",400,200);
			
	
		}else {
			
			if(conteoTiro > 1 && dineroActual <= 0) {
				
				g.setColor(Color.red);
				g.drawString("Lo siento, Actualmente no dispone de Dinero, Reinicie el Juego",50,375);
				
			}else {
				g.drawString("Debe ingresar la cantidad de la apuesta",50,360);
			}
			
		}
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == tirarDados) {
			 dado1Value = (int)(Math.random() * 6) + 1;
			 dado2Value = (int)(Math.random() * 6) + 1;
			 dado3Value = (int)(Math.random() * 6) + 1;
		}else if(e.getSource() == apuesta) {
			apuestaValue = Integer.parseInt(apuesta.getText());
			apuestaBar.setValue(apuestaValue);
			
			dado1Value = (int)(Math.random() * 6) + 1;
			dado2Value = (int)(Math.random() * 6) + 1;
			dado3Value = (int)(Math.random() * 6) + 1;
			
			
			apuestasTotales = apuestasTotales + apuestaValue;

		}else if(e.getSource() == retirarGanancias) {
			
			dineroActual = 0;
			ok = false;
			
		}else if(e.getSource() == reiniciarJuego) {
			
			dado1Value = 0;
			dado2Value = 0;
			dado3Value = 0;
			apuestaValue = 0;
			ganancia = 0;
			dineroActual = 0;
			inversionesTotales = 0;
			apuestasTotales = 0;
			gananciasTotales = 0;
			perdidasTotales = 0;
			conteoTiro = 0;
			conteoGanadox20 = 0;
			conteoGanadox10 = 0;
			conteoGanadox5 = 0;
			conteoPerdido = 0;
			
		}
		
		repaint();
	}
	
	public void adjustmentValueChanged(AdjustmentEvent r) {
		
		if(r.getSource() == apuestaBar) {
			apuestaValue = apuestaBar.getValue();
			apuesta.setText("" + apuestaValue);
			
		}
		
		
	}

}
