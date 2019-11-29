import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import javax.swing.JTextField;
//import javax.swing.JEditorPane;
//import java.awt.Panel;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;

public class Window extends JFrame {

	private JPanel contentPane;

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
