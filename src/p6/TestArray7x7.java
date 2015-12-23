package p6;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * Klassen representerar en grafisk miljö
 * bestående av en 7x7 array, och en 
 * 7x1 vertikal-, samt horisontell array
 * Men även 6 knappar med lyssnare 
 * @author ansambassamabdulhamid
 *
 */
public class TestArray7x7 extends JFrame {
	private JButton btnLasRad = new JButton("Läs rad"); 
	private JButton btnSkrivRad = new JButton("Skriv rad");
	private JButton btnInputRadNr = new JButton("Input rad nr");
	private JButton btnLasKol = new JButton("Läs kol");
	private JButton btnSkrivKol = new JButton("Skriv kol");
	private JButton btnInputKolNr = new JButton("Input kol nr");
	private TextField tfHorisont[] = new TextField[7]; // fördel med array är att samma referens kan användas
	private TextField textfield [] = new TextField[7];
	private  Array7x7 array7x7;
	
	
	/**
	 * Konstruktorn innehåller knappar med lyssnare 
	 * Vi skickar klassen Array7x7 i parametern
	 * för att nå dess metoder, och för 
	 * att sedan kunna lyssna på knappar
	 * @param array7x7 referens till Array7x7 klassen
	 */
	public TestArray7x7(Array7x7 array7x7) { 
		this.array7x7 = array7x7;
		AL listener = new AL();  // lyssnare - för man ska kunna lyssna (trycka) på knappar
		btnLasRad.addActionListener(listener);
		btnSkrivRad.addActionListener(listener);
		btnInputRadNr.addActionListener(listener);
		btnLasKol.addActionListener(listener);
		btnSkrivKol.addActionListener(listener);
		btnInputKolNr.addActionListener(listener);
	}
	/**
	 * Metoden består av fyra paneler som är alla 
	 * samlade på en BorderLayout
	 * I 1:a panelen skapas de 49 elementen
	 * I 2:a skapas 7x1 (vertikal) array med textfält
	 * I 3:e skapas 1x7 (horisontell) array med textfält
	 * I 4:e skapas 6 knappar med varsin label, & lyssnare
	 */
	public void TestArray7() { 
		
		/*
		 * panel7x7 representerar den stora arrayen med de 49 elementen
		 * Till detta ändamål användes en 2D- array för lagring av knapparna 
		 * En nestlad for loop användes för att gå igenom alla rader och kolumner
		 */
		JPanel panel7x7 = new JPanel();
		panel7x7.setLayout(new GridLayout(7,7));    
		JButton [] [] btn = new JButton [7] [7]; // 2D array för lagring av knapparna
		for( int i = 0; i<7; i++) { // för alla rader
			for( int j=0; j<7; j++) {   // för alla kolumner
				btn[i][j] = new JButton();   // skapa en knapp
				btn[i][j].setPreferredSize( new Dimension(50,50)); // ge knapparna en storlek			
				panel7x7.add(btn[i][j]);  // lägg knapparna på panelen 
				panel7x7.setBorder(new EmptyBorder(0,10,10,30));//Skapar utrymme mellan 
				                                                 //fönstrets kanter och panelerna
				add(panel7x7, BorderLayout.CENTER); // panelen placeras i center på fönstret
			}
	}
		/*
		 * vertikalP representerar den vertikala arrayen med de 7 elementen
		 * Arrayen är editerbar 
		 * består av 7 rader och 1 kolumn
		 * 
		 */
		JPanel vertikalP = new JPanel();
		vertikalP.setLayout(new BoxLayout( vertikalP, BoxLayout.Y_AXIS));
		for( int element = 0; element < 7; element++) {
			JButton btnV = new JButton();  
			btnV.setPreferredSize( new Dimension(55,55));
			textfield[0] = new TextField();
			textfield[1] = new TextField();
			textfield[2] = new TextField(); 
			textfield[3] = new TextField();
			textfield[4] = new TextField();
			textfield[5] = new TextField();
			textfield[6] = new TextField();
			
			btnV.add(textfield[0]);
			btnV.add(textfield[1]);
			btnV.add(textfield[2]);
			btnV.add(textfield[3]);
			btnV.add(textfield[4]);
			btnV.add(textfield[5]);
			btnV.add(textfield[6]);
			vertikalP.add(btnV);
			vertikalP.setBorder(new EmptyBorder(0,0,20,20));
			add(vertikalP, BorderLayout.WEST);
	}
		/*
		 * horisontellP representerar den horisontella arrayen med de 7 elementen 
		 * Arrayen är editerbar 
		 * består av 7 rader, 1 kolumn
		 */
		JPanel horisontellP = new JPanel(); 
		horisontellP.setLayout( new BoxLayout( horisontellP, BoxLayout.X_AXIS));
		for( int element = 0; element < 7; element++) {
			JButton btnH = new JButton();
			btnH.setPreferredSize( new Dimension(10,40));
			tfHorisont[0] = new TextField();
			tfHorisont[1] = new TextField();
			tfHorisont[2] = new TextField(); 
			tfHorisont[3] = new TextField();
			tfHorisont[4] = new TextField();
			tfHorisont[5] = new TextField();
			tfHorisont[6] = new TextField();

			btnH.add(tfHorisont[0]);
			btnH.add(tfHorisont[1]);
			btnH.add(tfHorisont[2]);
			btnH.add(tfHorisont[3]);
			btnH.add(tfHorisont[4]);
			btnH.add(tfHorisont[5]);
			btnH.add(tfHorisont[6]);
			horisontellP.add(btnH);
			horisontellP.setBorder(new EmptyBorder(30,35,0,30));
			add(horisontellP, BorderLayout.SOUTH);   
	  }
		/*
		 * greenP representerar 6 knappar med varsin label 
		 * består av 6 rader, och 1 kolumn
		 * Dessa knappar är "tryckbara" - har lyssnare
		 */
		JPanel greenP = new JPanel(); 
		greenP.setLayout(new GridLayout(7,0));
	    for( int i = 0; i<7; i++) { 
	    	btnLasRad.setForeground(new Color(0xFF00FF00)); // green color
	    	greenP.add(btnLasRad);
	    	btnSkrivRad.setForeground(new Color(0xFF00FF00));  
	    	greenP.add(btnSkrivRad);
	    	btnInputRadNr.setForeground(new Color(0xFF00FF00));
	    	greenP.add(btnInputRadNr); 
	    	btnLasKol.setForeground(new Color(0xFF00FF00));
	    	greenP.add(btnLasKol);
	    	btnSkrivKol.setForeground(new Color(0xFF00FF00));
	    	greenP.add(btnSkrivKol);
	    	btnInputKolNr.setForeground(new Color(0xFF00FF00));
	    	greenP.add(btnInputKolNr);
	    	greenP.setBorder(new EmptyBorder(0,20,20,0));
	    	add(greenP, BorderLayout.EAST);
	    }  
	    	pack();						 
	    	setResizable(false);	     // gör att man ej kan ändra storlek på det skapade fönstret	
		    setVisible(true);	         // gör fönstret synligt
 		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // gör fönstret stängbart	
     }
	/**
	 * Inre klass som implementerar ActionListener
	 * @author ansambassamabdulhamid
	 *
	 */
	private class AL implements ActionListener {  
		
		/**
		 * Vi trycker på en knapp
		 * För att det ska gå, skickar vi ett värde till
		 * klassen som innehåller alla metoder som ska anropas, 
		 * genom dess referens, och metodNamn
		 */
		public void actionPerformed(ActionEvent e)  {  
//			if(e.getSource() == btnLasRad){
//				array7x7.getRow(); 
//		}
//			else if(e.getSource() == btnSkrivRad){
//					array7x7.setRow(); 
//			}
//			else if(e.getSource() == btnInputRadNr){ 
//					array7x7.getVilkenMetod?();
//			}
//			else if(e.getSource() == btnLasKol){ 
//					array7x7.getCol();
//			}
//			else if(e.getSource() == btnSkrivKol){
//					array7x7.setCol(); 
//			}
//			else if(e.getSource() == btnInputKolNr){
//					array7x7.getVilkenMetod?(); 
//			}
		}
	}
	
	/**
	 * Körprogrammet
	 * @param args
	 */
	public static void main( String [] args) { 
		Array7x7 array7x7 = new Array7x7();
		TestArray7x7 t7x7 = new TestArray7x7(array7x7);
		t7x7.TestArray7();
	
}
	
	}