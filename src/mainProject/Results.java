package mainProject;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Date: 13-12-2019
 * Projecto de ES1
 * @author Pedro Santos, João Atalho, Guilherme Mendonça, Pedro Brites, José Ramalho,
 * António César, Pedro Nogueira
 *
 */
public class Results extends JFrame{

	private static final long serialVersionUID = 1L;

	/**
	 * atributos
	 */
	private JFrame f;
	@SuppressWarnings("unused")
	private Window wind;

	/**
	 * Construtor inicializado com os parametros passados como argumento
	 * @param wind
	 * @param dci
	 * @param dii
	 * @param adci
	 * @param adii
	 * @param dciP
	 * @param diiP
	 * @param adciP
	 * @param adiiP
	 */
	public Results(Window wind, int dci, int dii, int adci, int adii, int dciP, int diiP, int adciP, int adiiP) {
		this.wind = wind;
		this.f = new JFrame();

		f.setLayout(new GridLayout(2,5));
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

	/**
	 * método que "abre" a frame
	 */
	public void open() {
		f.setVisible(true);
	}
}