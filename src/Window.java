import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Window extends JFrame {

	private JPanel contentPane;
	private File file;

	private final String caminho = "Long-Method.xls";
	private int loc_Referencia;
	private int cyclo_Referencia;
	private int atfd_Referencia;
	private double laa_Referencia;

	/**
	 * Launch the application.  TestesDeComittsNovosBranchMais um teste
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setLoc(80); setCyclo(10); setAtfd(4); setLaa(0.42);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quality App");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnCriar = new JButton("Criar");
		contentPane.add(btnCriar, BorderLayout.WEST);

		JButton btnVisualizar = new JButton("Visualizar");
		contentPane.add(btnVisualizar, BorderLayout.CENTER);

		JButton btnEditar = new JButton("editar");
		contentPane.add(btnEditar, BorderLayout.EAST);

		JButton btnImportar = new JButton("Importar");
		contentPane.add(btnImportar, BorderLayout.NORTH);

		JButton btnExit = new JButton("Exit");
		contentPane.add(btnExit, BorderLayout.SOUTH);


		Visualizar vis = new Visualizar(this);
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent visualizar) {
				vis.open();


			}
		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent editar) {

				Scanner sc = new Scanner(System.in);

				System.out.println("LOC = ?");
				String loc = sc.next();
				setLoc(Integer.valueOf(loc));

				System.out.println("CYCLO = ?");
				String cyclo = sc.next();
				setCyclo(Integer.valueOf(cyclo));

				System.out.println("ATFD = ?");
				String atfd = sc.next();
				setAtfd(Integer.valueOf(atfd));

				System.out.println("LAA = ?");
				String laa = sc.next();
				setLaa(Double.valueOf(laa));

				writeOnFile("LOC = " + loc + "\n" + "CYCLO = " + cyclo + "\n" + "ATFD = " + atfd + "\n" + "LAA = " +laa);

				sc.close();

			}
		});

		//evento para btnCriar
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent criar) {
				// guardar caminho para ficheiro de regras a ser criado
				String caminhoParaFicheiroDeRegras = "rules.config.txt";
				// String nova linha
				String novaLinha = "\\r\\n";
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
		});

		//evento para btnImportar
		btnImportar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser(".");
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

				int returnValue = jfc.showOpenDialog(null);

				if ( returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile=jfc.getSelectedFile();
					System.out.println(selectedFile.getAbsolutePath());
					String url = selectedFile.getAbsolutePath();

					try {	
						ProcessBuilder p = new ProcessBuilder();
						p.command("cmd.exe","/c", url);
						p.start();
					} catch (IOException e1) {
						System.out.println("O ficheiro est� danificado ou n�o se encontra no diret�rio escolhido!");
					}
				}
			}
		}
				);

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

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

	public void setLoc(int x) {
		this.loc_Referencia = x;
	}

	public void setCyclo(int cyclo_Referencia) {
		this.cyclo_Referencia = cyclo_Referencia;
	}

	public void setAtfd(int atfd_Referencia) {
		this.atfd_Referencia = atfd_Referencia;
	}

	public void setLaa(double laa_Referencia) {
		this.laa_Referencia = laa_Referencia;
	}


	public JPanel getContentPane() {
		return contentPane;
	}

	public File getFile() {
		return file;
	}

	public String getCaminho() {
		return caminho;
	}

	public int getLoc_Referencia() {
		return loc_Referencia;
	}

	public int getCyclo_Referencia() {
		return cyclo_Referencia;
	}

	public int getAtfd_Referencia() {
		return atfd_Referencia;
	}

	public double getLaa_Referencia() {
		return laa_Referencia;
	}

	public void correrExcel() {
		File inputWorkbook = new File(caminho);
		Workbook w;

		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);


			//Algoritmos
			int dci = 0;
			int dii = 0;
			int adci = 0;
			int adii = 0;

			int dciP = 0;
			int diiP = 0;
			int adciP = 0;
			int adiiP = 0;


			for(int i = 1; i < sheet.getRows();i++) {
				Cell cell = sheet.getCell(4,i);

				if(Integer.valueOf(cell.getContents()) > getLoc_Referencia() && Integer.valueOf(sheet.getCell(5,i).getContents()) > getCyclo_Referencia()) {
					Cell c = sheet.getCell(9,i);
					if(Boolean.parseBoolean(c.getContents())){
						dci++;
					}
					else {
						adii++;

					}

					c = sheet.getCell(10,i);

					if(Boolean.parseBoolean(c.getContents()) ){
						dciP++;
					}
					else {
						adiiP++;
					}
				}


				if( ! (Integer.valueOf(cell.getContents()) > getLoc_Referencia() && Integer.valueOf(sheet.getCell(5,i).getContents()) > getCyclo_Referencia())) {
					Cell c = sheet.getCell(9,i);
					if(Boolean.parseBoolean(c.getContents())){
						dii++;
					}
					else {
						adci++;
					}

					c = sheet.getCell(10,i);

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
