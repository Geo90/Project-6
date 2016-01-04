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
	private JTextField tfHorisont[] = new JTextField[7]; // fördel med array är att samma referens kan användas
	private JTextField tfVertikal [] = new JTextField[7];
	private Array7x7 array7x7;
	private JTextField tfInputRad = new JTextField();
	private JTextField tfInputKol = new JTextField();
	
	
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
		btnLasKol.addActionListener(listener);
		btnSkrivKol.addActionListener(listener);
		btnInputRadNr.add(tfInputRad);  
		btnInputKolNr.add(tfInputKol);
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
			tfVertikal[0] = new JTextField();
			tfVertikal[1] = new JTextField();
			tfVertikal[2] = new JTextField(); 
			tfVertikal[3] = new JTextField();
			tfVertikal[4] = new JTextField();
			tfVertikal[5] = new JTextField();
			tfVertikal[6] = new JTextField();
			
			btnV.add(tfVertikal[0]);
			btnV.add(tfVertikal[1]);
			btnV.add(tfVertikal[2]);
			btnV.add(tfVertikal[3]);
			btnV.add(tfVertikal[4]);
			btnV.add(tfVertikal[5]);
			btnV.add(tfVertikal[6]);
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
			tfHorisont[0] = new JTextField();
			tfHorisont[1] = new JTextField();
			tfHorisont[2] = new JTextField(); 
			tfHorisont[3] = new JTextField();
			tfHorisont[4] = new JTextField();
			tfHorisont[5] = new JTextField();
			tfHorisont[6] = new JTextField();

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
			if(e.getSource() == btnLasRad){
				int Row = Integer.parseInt(tfInputRad.getText()); // gör om sträng till siffror
				int[] temp = array7x7.getRow(Row); // lagrar det vi matar in i en int array temp
				tfHorisont[0].setText(Integer.toString(temp[0])); 
				tfHorisont[1].setText(Integer.toString(temp[1]));
				tfHorisont[2].setText(Integer.toString(temp[2]));
				tfHorisont[3].setText(Integer.toString(temp[3]));
				tfHorisont[4].setText(Integer.toString(temp[4]));
				tfHorisont[5].setText(Integer.toString(temp[5]));
				tfHorisont[6].setText(Integer.toString(temp[6]));
		    }
			else if(e.getSource() == btnSkrivRad){  //setRow(var, vad)
				int SkrivRad = Integer.parseInt(tfInputRad.getText());
				int[]arr1 = new int[7];
				int [] temp1 = array7x7.setRow( SkrivRad, arr1[7]); //vad ska skickas i parametern om inte detta?
				tfVertikal[0].setText(Integer.toString(temp1[0]));
				tfVertikal[1].setText(Integer.toString(temp1[1]));
				tfVertikal[2].setText(Integer.toString(temp1[2]));
				tfVertikal[3].setText(Integer.toString(temp1[3]));
				tfVertikal[4].setText(Integer.toString(temp1[4]));
				tfVertikal[5].setText(Integer.toString(temp1[5]));
				tfVertikal[6].setText(Integer.toString(temp1[6]));
			}
			else if(e.getSource() == btnLasKol){ 
				int Col = Integer.parseInt(tfInputKol.getText());
				int [] temp2 = array7x7.getCol(Col);
				tfVertikal[0].setText(Integer.toString(temp2[0]));
			}
			else if(e.getSource() == btnSkrivKol){
				int SkrivKol = Integer.parseInt(tfInputKol.getText());
				int [] arr2 = new int[] {0,1,2,3,4,5,6};
				int [] temp3 = array7x7.setCol(SkrivKol, arr2[7]); // vad ska skickas i parameterna om inte detta?
				tfHorisont[0].setText(Integer.toString(temp3[0]));
				tfHorisont[1].setText(Integer.toString(temp3[1]));
				tfHorisont[2].setText(Integer.toString(temp3[2]));
				tfHorisont[3].setText(Integer.toString(temp3[3]));
				tfHorisont[4].setText(Integer.toString(temp3[4]));
				tfHorisont[5].setText(Integer.toString(temp3[5]));
				tfHorisont[6].setText(Integer.toString(temp3[6]));		
			}
		}
	}
	
	/**
	 * Körprogrammet
	 * @param args
	 */
	public static void main(String[] args) { 
		Array7x7 array7x7 = new Array7x7();
		TestArray7x7 t7x7 = new TestArray7x7(array7x7);
		t7x7.TestArray7();
	
	} 
	}
  