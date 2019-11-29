import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Panel;
import javax.swing.JButton;

public class Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.  TESTE29
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
		
		JButton btnEditar = new JButton("Editar");
		contentPane.add(btnEditar, BorderLayout.EAST);
		
		JButton btnImportar = new JButton("Importar");
		contentPane.add(btnImportar, BorderLayout.NORTH);
		
		JButton btnExit = new JButton("Exit");
		contentPane.add(btnExit, BorderLayout.SOUTH);
	}

}
