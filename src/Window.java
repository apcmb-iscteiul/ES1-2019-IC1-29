import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
//import javax.swing.JTextField;
//import javax.swing.JEditorPane;
//import java.awt.Panel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame {

	private JPanel contentPane;
	private File file;

	/**
	 * Launch the application.  TestesDeComittsNovosBranchMais um teste
	 */ 
	public static void main(String[] args) {
		File excelFile= new File("Long-Method.xlsx");
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
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent editar) {
				try {
					BufferedWriter wr = new BufferedWriter(new FileWriter("rules.config.txt"));
					Scanner sc = new Scanner(System.in);
					
					System.out.println("LOC = ?");
					String loc = sc.next();
					
					System.out.println("CYCLO = ?");
					String cyclo = sc.next();
					
					wr.write("LOC = " + loc + "\n" + "CYCLO = " + cyclo);
					
					wr.close();
					
				}
				
				catch(IOException e ) {
					System.out.println("O ficheiro tem de ser criado primeiro!");
					e.printStackTrace();
				}
				
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
				String regrasPredefinidas = "LOC=80" + System.lineSeparator() + "CYCLO=10";
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
				try {
					String url = "Long-Method.xlsx";
					ProcessBuilder p = new ProcessBuilder();
					p.command("cmd.exe","/c", url);
					p.start();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
				);



		JButton btnExit = new JButton("Exit");
		contentPane.add(btnExit, BorderLayout.SOUTH);
	}


}
