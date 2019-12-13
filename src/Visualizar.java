import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Date: 13-12-2019
 * Projecto de ES1
 * @author Pedro Santos, João Atalho, Guilherme Mendonça, Pedro Brites, José Ramalho,
 * António César, Pedro Nogueira
 *
 */

public class Visualizar extends JFrame {

	
	/**
	 * atributos
	 */
	private Window wind;
	JFrame f;
	
	/**
	 * Construtor
	 * @param wind
	 */
	public Visualizar(Window wind) {
		this.wind = wind;
		this.f = new JFrame();
		
		f.setLayout(new GridLayout(1,2));
		f.setTitle("Visualizar");

		JTextField locT = new JTextField();
		JTextField cycloT = new JTextField();
		JTextField atfdT = new JTextField();
		JTextField laaT = new JTextField();
		JButton rul = new JButton("rules");
		

		JButton c1 = new JButton("change");
		
		JButton op = new JButton("go");


		f.add(new JLabel("LOC"));

		locT.setText(Integer.toString(wind.getLoc_Referencia()));
		f.add(locT);

		f.add(new JLabel("CYCLO"));

		cycloT.setText(Integer.toString(wind.getCyclo_Referencia()));
		f.add(cycloT);


		f.add(new JLabel("ATFD"));

		atfdT.setText(Integer.toString(wind.getAtfd_Referencia()));
		f.add(atfdT);

		f.add(new JLabel("LAA"));

		laaT.setText(Double.toString(wind.getLaa_Referencia()));
		f.add(laaT);
		f.add(c1);
		f.add(rul);
		f.add(op);

		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				wind.writeOnFile("LOC = " + locT.getText() + "\n" + "CYCLO = " + cycloT.getText() + "\n" + "ATFD = " + atfdT.getText() + "\n" + "LAA = " +laaT.getText());
				
				wind.setLoc( Integer.parseInt(locT.getText()));
				wind.setCyclo( Integer.parseInt(cycloT.getText()));
				wind.setAtfd( Integer.parseInt(atfdT.getText()));
				wind.setLaa(Double.parseDouble(laaT.getText()));
			}

		});
		
		op.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wind.correrExcel();
			}
		});
		
		rul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("As regras predefinidas utilizadas são: \nfeature envy: "
						+ "SE ( ATFD > 4 E LAA < 0.42 ) ENTÃO is_feature_envy = TRUE SENÃO is_feature_envy "
						+ "= FALSE" + "\n" + "long method: SE (LOC > 80 E CYCLO >10) ENTÃO is_long_method = TRUE SENÃO is_long_method = FALSE");
			}
		});

		
		
		
		f.setBounds(400,250,900,100);


		

	}
	
	/**
	 * Método que "abre" a frame
	 */
	public void open() {
		
		f.setVisible(true);
	}

}

