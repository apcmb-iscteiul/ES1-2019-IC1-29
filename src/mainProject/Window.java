package mainProject;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


/**
 * Date: 13-12-2019
 * Projecto de ES1
 * @author Pedro Santos, João Atalho, Guilherme Mendonça, Pedro Brites, José Ramalho,
 * António César, Pedro Nogueira
 *
 */


public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Atributos
	 */

	//private JPanel contentPane;
	//private File file;

	private String caminho = "Long-Method.xls";
	private int loc_Referencia;
	private int cyclo_Referencia;
	private int atfd_Referencia;
	private double laa_Referencia;

	/**
	 * Main que corre a app
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Window frame = new Window();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construtor, sem argumentos
	 */
	public Window() {
		setLoc(80); setCyclo(10); setAtfd(4); setLaa(0.42);
		JFrame f = new JFrame();

		f.setLayout(new GridLayout(1,3));
		f.setTitle("Quality App");


		JButton btnCriar = new JButton("Criar");
		f.add(btnCriar);
		JButton btnVisualizar = new JButton("Visualizar");
		f.add(btnVisualizar);
		JButton btnImportar = new JButton("Importar");
		f.add(btnImportar);
		JButton btnExit = new JButton("Exit");
		f.add(btnExit);

		Visualizar vis = new Visualizar(this);
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent visualizar) {
				vis.open();
			}
		});


		//evento para btnCriar
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent criar) {
				acaoCriar();
			}
		});

		//evento para btnImportar
		btnImportar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				acaoImportar();
			}
		}
				);

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		f.setBounds(100,200,600,100);

		f.setVisible(true);

	}


	public void acaoImportar() {
		JFileChooser jfc=new JFileChooser(".");
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int returnValue = jfc.showOpenDialog(null);

		if ( returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile=jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			String url = selectedFile.getAbsolutePath();
			setCaminho(url);

			try {	
				ProcessBuilder p = new ProcessBuilder();
				p.command("cmd.exe","/c", url);
				p.start();
			} catch (IOException e1) {
				System.out.println("O ficheiro está danificado ou não se encontra no diretório escolhido!");
			}
		}		
	}

	public void acaoCriar() {
		// guardar caminho para ficheiro de regras a ser criado
		String caminhoParaFicheiroDeRegras = "rules.config.txt";
		// String nova linha
		//String novaLinha = "\\r\\n";
		// criar string com regras predefinidas
		String regrasPredefinidas = "LOC=80" + System.lineSeparator() + "CYCLO=10" + System.lineSeparator() + "ATFD=4" + System.lineSeparator() + "LAA=0.42";
		setLoc(80); setCyclo(10); setAtfd(4); setLaa(0.42);
		// criar stream de escrita para esse caminho
		OutputStream streamDeEscrita = null;
		try {
			// Criar ou apanhar ficheiro
			File file = new File(caminhoParaFicheiroDeRegras);
			// Obter stream de escrita de ficheiros
			streamDeEscrita = new FileOutputStream(file);
			// Escrever em cima do ficheiro, limpa o que estava
			streamDeEscrita.write(regrasPredefinidas.getBytes(), 0, regrasPredefinidas.length());
			System.out.println("Ficheiro rules.config.txt criado/editado com valores default!");
		} catch (IOException e) {
			// retornar erros
			e.printStackTrace();
		}finally{
			try {
				// fechar buffer de escrita
				streamDeEscrita.close();
			} catch (IOException e) {
				// retornar erros
				e.printStackTrace();
			}
		}		
	}

	/**
	 * Método que escreve no ficheiro rules.config.txt (caminho estático, inalterável) o
	 * que for passado em argumento
	 * @param txt
	 */
	public void writeOnFile(String txt) {
		try {
			BufferedWriter wr = new BufferedWriter(new FileWriter("rules.config.txt"));
			wr.write(txt);

			wr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * setter
	 * @param loc_Referencia
	 */
	public void setLoc(int loc_Referencia) {
		this.loc_Referencia = loc_Referencia;
	}

	/**
	 * setter
	 * @param cyclo_Referencia
	 */
	public void setCyclo(int cyclo_Referencia) {
		this.cyclo_Referencia = cyclo_Referencia;
	}

	/**
	 * setter
	 * @param atfd_Referencia
	 */
	public void setAtfd(int atfd_Referencia) {
		this.atfd_Referencia = atfd_Referencia;
	}

	/**
	 * setter
	 * @param laa_Referencia
	 */
	public void setLaa(double laa_Referencia) {
		this.laa_Referencia = laa_Referencia;
	}

	/**
	 * getter
	 * @return
	 */
	public int getLoc_Referencia() {
		return loc_Referencia;
	}

	/**
	 * getter
	 * @return
	 */
	public int getCyclo_Referencia() {
		return cyclo_Referencia;
	}

	/**
	 * getter
	 * @return
	 */
	public int getAtfd_Referencia() {
		return atfd_Referencia;
	}

	/**
	 * getter
	 * @return
	 */
	public double getLaa_Referencia() {
		return laa_Referencia;
	}

	/**
	 * setter
	 * @param url
	 */
	public void setCaminho(String url) {
		this.caminho = url;
	}

	/**
	 * Método que corre o ficheiro Excel que se encontra no atributo caminho
	 * onde estão implementados os algoritmos
	 * 
	 */
	public void correrExcel() {
		File inputWorkbook = new File(caminho);
		Workbook w;

		try {
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(0);


			//posicoes no Excel
			int cycloPos = 0;
			int locPos = 0;
			int iPlasmaPos = 0;
			int pmdPos = 0;

			//Algoritmos
			int dci = 0;
			int dii = 0;
			int adci = 0;
			int adii = 0;

			int dciP = 0;
			int diiP = 0;
			int adciP = 0;
			int adiiP = 0;


			for(int j = 0; j< sheet.getColumns();j++) {
				if(sheet.getCell(j,0).getContents().equals("LOC")){
					locPos = j;
				}
				else if(sheet.getCell(j,0).getContents().equals("CYCLO")){
					cycloPos = j;
				}
				else if(sheet.getCell(j,0).getContents().equals("iPlasma")){
					iPlasmaPos = j;
				}
				else if(sheet.getCell(j,0).getContents().equals("PMD")){
					pmdPos = j;
				}
			}



			for(int k = 1; k < sheet.getRows();k++) {
				Cell cell = sheet.getCell(locPos,k);
				if(Integer.valueOf(cell.getContents()) > getLoc_Referencia() && Integer.valueOf(sheet.getCell(cycloPos,k).getContents()) > getCyclo_Referencia()) {
					Cell c = sheet.getCell(iPlasmaPos,k);
					if(Boolean.parseBoolean(c.getContents())){
						dci++;
					}
					else {
						adii++;

					}

					c = sheet.getCell(pmdPos,k);

					if(Boolean.parseBoolean(c.getContents()) ){
						dciP++;
					}
					else {
						adiiP++;
					}
				}

				if( ! (Integer.valueOf(cell.getContents()) > getLoc_Referencia() && Integer.valueOf(sheet.getCell(cycloPos,k).getContents()) > getCyclo_Referencia())) {
					Cell c = sheet.getCell(iPlasmaPos,k);
					if(Boolean.parseBoolean(c.getContents())){
						dii++;
					}
					else {
						adci++;
					}

					c = sheet.getCell(pmdPos,k);

					if(Boolean.parseBoolean(c.getContents())){
						diiP++;
					}
					else {
						adciP++;
					}
				}

			}

			new Results(this, dci, dii, adci, adii, dciP, diiP, adciP, adiiP).open();
		}

		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
