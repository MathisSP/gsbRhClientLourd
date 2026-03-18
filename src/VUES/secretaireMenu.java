package VUES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import java.awt.ScrollPane;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class secretaireMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnConsulterFichesVisiteurs;
	private JButton btnlstVisiteurs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secretaireMenu frame = new secretaireMenu();
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
	public secretaireMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnConsulterFichesVisiteurs());
		contentPane.add(getBtnlstVisiteurs());

	}
	public JButton getBtnConsulterFichesVisiteurs() {
		if (btnConsulterFichesVisiteurs == null) {
			btnConsulterFichesVisiteurs = new JButton("Consulter les fiches des visiteurs");
			btnConsulterFichesVisiteurs.setBounds(235, 118, 189, 29);
		}
		return btnConsulterFichesVisiteurs;
	}
	public JButton getBtnlstVisiteurs() {
		if (btnlstVisiteurs == null) {
			btnlstVisiteurs = new JButton("Visiteurs");
			btnlstVisiteurs.addActionListener(new ActionListener() {
				
			public void actionPerformed(ActionEvent e) {
				listeVisiteurs page = new listeVisiteurs();
				page.setVisible(true);
				dispose();
				}
			});
			btnlstVisiteurs.setBounds(62, 118, 131, 29);
		}
		return btnlstVisiteurs;
	}
	
}
