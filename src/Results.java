import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Results extends JFrame{

	private JFrame f;
	private Window wind;

	public Results(Window wind, int dci, int dii, int adci, int adii, int dciP, int diiP, int adciP, int adiiP) {
		this.wind = wind;
		this.f = new JFrame();

		f.setLayout(new GridLayout(2,5));
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Results");
		JLabel pl = new JLabel("iPlasma");
		JLabel dcil= new JLabel("DCI = " + dci);
		JLabel diil= new JLabel("DII = " + dii);
		JLabel adcil= new JLabel("ADCI = " + adci);
		JLabel adiil= new JLabel("ADII = " + adii);
		JLabel pm = new JLabel("PMD");
		JLabel dcilP= new JLabel("DCI = " + dciP);
		JLabel diilP= new JLabel("DII = " + diiP);
		JLabel adcilP= new JLabel("ADCI = " + adciP);
		JLabel adiilP= new JLabel("ADII = " + adiiP);
		
		f.add(pl);
		f.add(dcil);
		f.add(diil);
		f.add(adcil);
		f.add(adiil);
		f.add(pm);
		f.add(dcilP);
		f.add(diilP);
		f.add(adcilP);
		f.add(adiilP);

		
		


		f.setBounds(400,250,900,100);




	}

	public void open() {

		f.setVisible(true);
	}

}