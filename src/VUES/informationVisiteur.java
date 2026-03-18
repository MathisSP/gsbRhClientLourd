package VUES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class informationVisiteur extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelCreerVisteur;
	private JLabel labeIid;
	private JTextField idAsaisir;
	private JLabel lblNom;
	private JTextField textNom;
	private JLabel lblPrnom;
	private JTextField textPrenom;
	private JLabel lblLogin;
	private JLabel lblMdp;
	private JLabel lblAdresse;
	private JLabel lblCp;
	private JLabel lblDateembauche;
	private JLabel lblIdrole;
	private JLabel lblVille;
	private JButton btnValiderCreationVisiteur;
	private JTextField textMdp;
	private JTextField textCp;
	private JTextField textdateEmbauche;
	private JTextField textVille;
	private JTextField textidRole;
	private JTextField textAdresse;
	private JTextField textLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					informationVisiteur frame = new informationVisiteur();
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
	public informationVisiteur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabelCreerVisteur());
		contentPane.add(getLabeIid());
		contentPane.add(getIdAsaisir());
		contentPane.add(getLblNom());
		contentPane.add(getTextNom());
		contentPane.add(getLblPrnom());
		contentPane.add(getTextPrenom());
		contentPane.add(getLblLogin());
		contentPane.add(getLblMdp());
		contentPane.add(getLblAdresse());
		contentPane.add(getLblCp());
		contentPane.add(getLblDateembauche());
		contentPane.add(getLblIdrole());
		contentPane.add(getLblVille());
		contentPane.add(getBtnValiderCreationVisiteur());
		contentPane.add(getTextMdp());
		contentPane.add(getTextCp());
		contentPane.add(getTextdateEmbauche());
		contentPane.add(getTextVille());
		contentPane.add(getTextidRole());
		contentPane.add(getTextAdresse());
		contentPane.add(getTextLogin());

	}

	public JLabel getLabelCreerVisteur() {
		if (labelCreerVisteur == null) {
			labelCreerVisteur = new JLabel("Création Visiteur");
			labelCreerVisteur.setBounds(168, 11, 97, 14);
		}
		return labelCreerVisteur;
	}
	public JLabel getLabeIid() {
		if (labeIid == null) {
			labeIid = new JLabel("idUtilisateur: ");
			labeIid.setBounds(10, 47, 74, 14);
		}
		return labeIid;
	}
	public JTextField getIdAsaisir() {
		if (idAsaisir == null) {
			idAsaisir = new JTextField();
			idAsaisir.setBounds(112, 47, 86, 14);
			idAsaisir.setColumns(10);
		}
		return idAsaisir;
	}
	public JLabel getLblNom() {
		if (lblNom == null) {
			lblNom = new JLabel("nom: ");
			lblNom.setBounds(254, 47, 74, 14);
		}
		return lblNom;
	}
	public JTextField getTextNom() {
		if (textNom == null) {
			textNom = new JTextField();
			textNom.setColumns(10);
			textNom.setBounds(318, 47, 86, 14);
		}
		return textNom;
	}
	public JLabel getLblPrnom() {
		if (lblPrnom == null) {
			lblPrnom = new JLabel("Prenom: ");
			lblPrnom.setBounds(10, 77, 74, 14);
		}
		return lblPrnom;
	}
	public JTextField getTextPrenom() {
		if (textPrenom == null) {
			textPrenom = new JTextField();
			textPrenom.setColumns(10);
			textPrenom.setBounds(112, 77, 86, 14);
		}
		return textPrenom;
	}
	public JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("Login: ");
			lblLogin.setBounds(254, 77, 74, 14);
		}
		return lblLogin;
	}
	public JLabel getLblMdp() {
		if (lblMdp == null) {
			lblMdp = new JLabel("Mdp: ");
			lblMdp.setBounds(10, 117, 74, 14);
		}
		return lblMdp;
	}
	public JLabel getLblAdresse() {
		if (lblAdresse == null) {
			lblAdresse = new JLabel("Adresse: ");
			lblAdresse.setBounds(254, 117, 74, 14);
		}
		return lblAdresse;
	}
	public JLabel getLblCp() {
		if (lblCp == null) {
			lblCp = new JLabel("Cp: ");
			lblCp.setBounds(10, 152, 74, 14);
		}
		return lblCp;
	}
	public JLabel getLblDateembauche() {
		if (lblDateembauche == null) {
			lblDateembauche = new JLabel("dateEmbauche: ");
			lblDateembauche.setBounds(10, 187, 86, 14);
		}
		return lblDateembauche;
	}
	public JLabel getLblIdrole() {
		if (lblIdrole == null) {
			lblIdrole = new JLabel("idRole: ");
			lblIdrole.setBounds(254, 187, 74, 14);
		}
		return lblIdrole;
	}
	public JLabel getLblVille() {
		if (lblVille == null) {
			lblVille = new JLabel("Ville: ");
			lblVille.setBounds(254, 152, 74, 14);
		}
		return lblVille;
	}
	public JButton getBtnValiderCreationVisiteur() {
		if (btnValiderCreationVisiteur == null) {
			btnValiderCreationVisiteur = new JButton("Valider");
			btnValiderCreationVisiteur.setBounds(185, 227, 89, 23);
		}
		return btnValiderCreationVisiteur;
	}
	public JTextField getTextMdp() {
		if (textMdp == null) {
			textMdp = new JTextField();
			textMdp.setColumns(10);
			textMdp.setBounds(112, 114, 86, 14);
		}
		return textMdp;
	}
	public JTextField getTextCp() {
		if (textCp == null) {
			textCp = new JTextField();
			textCp.setColumns(10);
			textCp.setBounds(112, 149, 86, 14);
		}
		return textCp;
	}
	public JTextField getTextdateEmbauche() {
		if (textdateEmbauche == null) {
			textdateEmbauche = new JTextField();
			textdateEmbauche.setColumns(10);
			textdateEmbauche.setBounds(112, 184, 86, 14);
		}
		return textdateEmbauche;
	}
	public JTextField getTextVille() {
		if (textVille == null) {
			textVille = new JTextField();
			textVille.setColumns(10);
			textVille.setBounds(318, 152, 86, 14);
		}
		return textVille;
	}
	public JTextField getTextidRole() {
		if (textidRole == null) {
			textidRole = new JTextField();
			textidRole.setColumns(10);
			textidRole.setBounds(318, 184, 86, 14);
		}
		return textidRole;
	}
	public JTextField getTextAdresse() {
		if (textAdresse == null) {
			textAdresse = new JTextField();
			textAdresse.setColumns(10);
			textAdresse.setBounds(318, 117, 86, 14);
		}
		return textAdresse;
	}
	public JTextField getTextLogin() {
		if (textLogin == null) {
			textLogin = new JTextField();
			textLogin.setColumns(10);
			textLogin.setBounds(318, 77, 86, 14);
		}
		return textLogin;
	}
}
