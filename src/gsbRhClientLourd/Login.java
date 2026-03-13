package gsbRhClientLourd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BDD.ConnexionDB;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfLogin;
	private JTextField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private boolean verifierIdentifiants(String username, String password) {
	    String sql = "SELECT * FROM utilisateur WHERE login = ? AND mdp = ?";

	    try (Connection conn = ConnexionDB.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, username);
	        stmt.setString(2, password);

	        ResultSet rs = stmt.executeQuery();
	        return rs.next(); // true si un enregistrement correspond

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return false;
	    }
	}
	
	/**
	 * Create the frame.
	 */
	public Login() {
		getContentPane().setLayout(null);
		
		setTitle("GSB - Connexion");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// texte à gauche (label) pour indiquer le login
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLogin.setBounds(109, 115, 82, 36);
		getContentPane().add(lblLogin);
		
		// zone de texte du login
		tfLogin = new JTextField();
		tfLogin.setBounds(217, 115, 150, 36);
		getContentPane().add(tfLogin);
		tfLogin.setColumns(10);
		
		// texte à gauche (label) pour indiquer le mot de passe
		JLabel lblPassword = new JLabel("Mot de passe : ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBounds(21, 184, 167, 36);
		getContentPane().add(lblPassword);
		
		// zone de texte du mot de passe
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(217, 184, 150, 36);
		getContentPane().add(tfPassword);
		
		// Bouton de connexion
		JButton loginButton = new JButton("Connection");
		loginButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String username = tfLogin.getText();
		        String password = tfPassword.getText();

		        if (verifierIdentifiants(username, password)) {
		            // Connexion réussie → ouvrir la page suivante
		            PageTest page = new PageTest();
		            page.setVisible(true);
		            dispose(); // ferme la fenêtre de login
		        } else {
		            JOptionPane.showMessageDialog(null, "Identifiants incorrects.", "Erreur", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		
		loginButton.setBounds(250, 276, 89, 23);
		getContentPane().add(loginButton);
	}
}
