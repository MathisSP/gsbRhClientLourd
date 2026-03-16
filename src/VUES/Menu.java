package VUES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		getContentPane().setLayout(null);
		
		JButton btnSecretaireRH1 = new JButton("Secretaire RH Bouton 1");
		btnSecretaireRH1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageTest page = new PageTest();
	            page.setVisible(true);
			}
		});
		btnSecretaireRH1.setBounds(40, 91, 164, 40);
		getContentPane().add(btnSecretaireRH1);
		
		JButton btnDirecteurRH1 = new JButton("Directeur RH Bouton 1");
		btnDirecteurRH1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageTest page = new PageTest();
	            page.setVisible(true);
			}
		});
		btnDirecteurRH1.setBounds(261, 91, 183, 40);
		getContentPane().add(btnDirecteurRH1);
		
		JButton btnResponsableFrais1 = new JButton("Responsable Frais Bouton 1");
		btnResponsableFrais1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageTest page = new PageTest();
	            page.setVisible(true);
			}
		});
		btnResponsableFrais1.setBounds(111, 157, 240, 40);
		getContentPane().add(btnResponsableFrais1);
		
		setTitle("GSB - Accueil");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
