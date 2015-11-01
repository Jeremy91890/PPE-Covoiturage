package fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Toolkit;

public class Main<conn> extends JFrame {

	Connection conn = null;
	
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	private JPanel contentPane;
	private JTextField pseudoConnexion;
	private JPasswordField motDePasseConnexion;
	private JTextField pseudo;
	private JTextField repeterMotDePasse;
	private JTextField nom;
	private JTextField prenom;
	private JTextField naissance;
	private JTextField adresse;
	private JTextField telephone;
	private JTextField mail;
	private JTextField marque;
	private JTextField modele;
	private JTextField annee;
	private JTextField categorie;
	private JTextField motorisation;
	private JTextField puissance;
	private JTextField motDePasse;

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Volumes/KINGSTON/PPE/PPE-Covoiturage/src/BestDrive-Audi-R8-800x500.jpg"));
		frame.setVisible(true);

		conn = ConnectDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		contentPane.setVisible(true);
		contentPane.setEnabled(false);
		
		// ________________________________________________________PANEL INSCRIPTION________________________________________
		
		JPanel Inscription = new JPanel();
		Inscription.setBounds(0, 0, 800, 502);
		contentPane.add(Inscription);
		Inscription.setLayout(null);
		
		JLabel label = new JLabel("Vos informations de connexion");
		label.setBounds(301, 11, 197, 16);
		Inscription.add(label);
		
		JLabel label_1 = new JLabel("Pseudo :");
		label_1.setBounds(188, 59, 53, 16);
		Inscription.add(label_1);
		
		JLabel label_2 = new JLabel("Mot de passe :");
		label_2.setBounds(150, 87, 91, 16);
		Inscription.add(label_2);
		
		JLabel label_3 = new JLabel(" Répéter mot de passe :");
		label_3.setBounds(94, 115, 147, 16);
		Inscription.add(label_3);
		
		JLabel label_4 = new JLabel("Vos informations personnelles");
		label_4.setBounds(301, 160, 192, 16);
		Inscription.add(label_4);
		
		JLabel label_5 = new JLabel("Nom :");
		label_5.setBounds(171, 196, 38, 16);
		Inscription.add(label_5);
		
		JLabel label_6 = new JLabel("Prenom :");
		label_6.setBounds(156, 224, 55, 16);
		Inscription.add(label_6);
		
		JLabel label_7 = new JLabel("Date de naissance :");
		label_7.setBounds(94, 252, 122, 16);
		Inscription.add(label_7);
		
		JLabel label_8 = new JLabel("Adresse :");
		label_8.setBounds(156, 280, 58, 16);
		Inscription.add(label_8);
		
		JLabel label_9 = new JLabel("Téléphone :");
		label_9.setBounds(142, 310, 73, 16);
		Inscription.add(label_9);
		
		JLabel label_10 = new JLabel("Mail :");
		label_10.setBounds(182, 341, 34, 16);
		Inscription.add(label_10);
		//--------------------------------------------Insertion base de donnees 
		JButton button = new JButton("S'inscrire");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscrire();
			}
		});
		button.setBounds(252, 430, 101, 29);
		Inscription.add(button);
		
		
			JButton referencerVehicule = new JButton("Référencer un véhicule");
			referencerVehicule.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Inscription.setVisible(false);
					Vehicule.setVisible(true);
				}
			});
			
		referencerVehicule.setBounds(447, 430, 186, 29);
		Inscription.add(referencerVehicule);
		
		pseudo = new JTextField();
		pseudo.setBounds(301, 53, 197, 28);
		Inscription.add(pseudo);
		pseudo.setColumns(10);
		
		repeterMotDePasse = new JTextField();
		repeterMotDePasse.setBounds(301, 109, 197, 28);
		Inscription.add(repeterMotDePasse);
		repeterMotDePasse.setColumns(10);
		
		nom = new JTextField();
		nom.setBounds(299, 188, 199, 28);
		Inscription.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(301, 218, 199, 28);
		Inscription.add(prenom);
		prenom.setColumns(10);
		
		naissance = new JTextField();
		naissance.setBounds(301, 246, 199, 28);
		Inscription.add(naissance);
		naissance.setColumns(10);
		
		adresse = new JTextField();
		adresse.setBounds(301, 274, 199, 28);
		Inscription.add(adresse);
		adresse.setColumns(10);
		
		telephone = new JTextField();
		telephone.setBounds(299, 304, 199, 28);
		Inscription.add(telephone);
		telephone.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(301, 335, 197, 28);
		Inscription.add(mail);
		mail.setColumns(10);
		
		JLabel permis = new JLabel("possédez vous un permis de conduire");
		permis.setBounds(34, 385, 245, 16);
		Inscription.add(permis);
		
		JRadioButton rdbtnOui = new JRadioButton("Oui");
		rdbtnOui.setBounds(301, 381, 141, 23);
		Inscription.add(rdbtnOui);
		
		JRadioButton rdbtnNon = new JRadioButton("Non");
		rdbtnNon.setBounds(450, 381, 141, 23);
		Inscription.add(rdbtnNon);
		// afficher referencervehicule si oui saisie 
		
		motDePasse = new JTextField();
		motDePasse.setBounds(301, 81, 197, 28);
		Inscription.add(motDePasse);
		motDePasse.setColumns(10);
		Inscription.setVisible(false);
		
		// ________________________________________________________PANEL ACCUEIL________________________________________
		
		JPanel Accueil = new JPanel();
		Accueil.setBounds(0, 0, 806, 488);
		contentPane.add(Accueil);
		Accueil.setLayout(null);
		
		JLabel label_11 = new JLabel("iCovoit");
		label_11.setBounds(321, 5, 163, 57);
		label_11.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 48));
		Accueil.add(label_11);
		
		pseudoConnexion = new JTextField();
		pseudoConnexion.setBounds(283, 119, 134, 28);
		pseudoConnexion.setColumns(10);
		Accueil.add(pseudoConnexion);
		
		motDePasseConnexion = new JPasswordField();
		motDePasseConnexion.setBounds(283, 165, 134, 28);
		motDePasseConnexion.setToolTipText("");
		Accueil.add(motDePasseConnexion);
		
		JButton button_2 = new JButton("Connexion");
		button_2.setBounds(174, 246, 112, 29);
		Accueil.add(button_2);
		
		JButton button_3 = new JButton("Inscription");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil.setVisible(false);
				Inscription.setVisible(true);
				// TODO créer action listener 
			}
		});
		button_3.setBounds(381, 246, 112, 29);
		Accueil.add(button_3);
		
		JLabel label_12 = new JLabel("Pseudo :");
		label_12.setBounds(202, 125, 53, 16);
		Accueil.add(label_12);
		
		JLabel label_13 = new JLabel("Mot de passe :");
		label_13.setBounds(164, 171, 91, 16);
		Accueil.add(label_13);
		
		//----------------------------------Panel Véhicule------------------------
		JPanel Vehicule = new JPanel();
		Vehicule.setBounds(0, 0, 753, 483);
		contentPane.add(Vehicule);
		Vehicule.setLayout(null);
		
		Vehicule.setVisible(false);
		
		JLabel lblPermis = new JLabel("Catégorie Permis");
		lblPermis.setBounds(120, 75, 114, 16);
		Vehicule.add(lblPermis);
		
		JList list = new JList();
		list.setBounds(275, 75, 114, 16);
		Vehicule.add(list);
		
		JLabel lblVehivule = new JLabel("Vehicule");
		lblVehivule.setBounds(298, 126, 61, 16);
		Vehicule.add(lblVehivule);
		
		JLabel lblMarque = new JLabel("Marque");
		lblMarque.setBounds(173, 172, 61, 16);
		Vehicule.add(lblMarque);
		
		JLabel lblNewLabel = new JLabel("Modele");
		lblNewLabel.setBounds(173, 203, 61, 16);
		Vehicule.add(lblNewLabel);
		
		JLabel lblAnnee = new JLabel("Annee");
		lblAnnee.setBounds(173, 231, 61, 16);
		Vehicule.add(lblAnnee);
		
		JLabel lblNewLabel_1 = new JLabel("Categorie");
		lblNewLabel_1.setBounds(173, 259, 61, 16);
		Vehicule.add(lblNewLabel_1);
		
		JLabel lblMotorisation = new JLabel("Motorisation");
		lblMotorisation.setBounds(151, 287, 91, 16);
		Vehicule.add(lblMotorisation);
		
		JLabel lblNewLabel_2 = new JLabel("Puissance");
		lblNewLabel_2.setBounds(173, 315, 83, 16);
		Vehicule.add(lblNewLabel_2);
		
		marque = new JTextField();
		marque.setBounds(275, 166, 134, 28);
		Vehicule.add(marque);
		marque.setColumns(10);
		
		modele = new JTextField();
		modele.setBounds(275, 197, 134, 28);
		Vehicule.add(modele);
		modele.setColumns(10);
		
		annee = new JTextField();
		annee.setBounds(275, 225, 134, 28);
		Vehicule.add(annee);
		annee.setColumns(10);
		
		categorie = new JTextField();
		categorie.setBounds(275, 253, 134, 28);
		Vehicule.add(categorie);
		categorie.setColumns(10);
		
		motorisation = new JTextField();
		motorisation.setBounds(275, 281, 134, 28);
		Vehicule.add(motorisation);
		motorisation.setColumns(10);
		
		puissance = new JTextField();
		puissance.setBounds(275, 309, 134, 28);
		Vehicule.add(puissance);
		puissance.setColumns(10);
		
		//-----------------------------------------------------Enregistrer Véhicule base de données-----------------------
		JButton enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscrire();
					String sql_enregistrerVehicule = ("INSERT INTO vehicule VALUES (NULL,?, ?, ?, ?, ?, ?, ?);") ;
	            
	        	try {
					pst = conn.prepareStatement(sql_enregistrerVehicule);
					pst.setString(1,marque.getText());
		            pst.setString(2,modele.getText());
		            pst.setString(3,annee.getText());
		            pst.setString(4,categorie.getText());
		            pst.setString(5,motorisation.getText());
		            pst.setString(6,puissance.getText());
		            pst.setString(7,pseudo.getText());
		            
		            System.out.println(pst);
		            
		            pst.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		enregistrer.setBounds(204, 379, 117, 29);
		Vehicule.add(enregistrer);
		
		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		annuler.setBounds(399, 379, 117, 29);
		Vehicule.add(annuler);
	}
	//---------------------------------------Connexion base de données 
	public static Connection ConnectDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/covoiturage","root","root");
            return conn;
        }
        catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
            return null;
        }         
    }
	public void inscrire(){
		String sql_inscription = ("INSERT INTO utilisateur VALUES (?, ?, ?, ?, ?, ?, ?, ?);") ;
        
    	try {
			pst = conn.prepareStatement(sql_inscription);
			pst.setString(1,pseudo.getText());
            pst.setString(2,nom.getText());
            pst.setString(3,prenom.getText());
            pst.setString(4,naissance.getText());
            pst.setString(5,adresse.getText());
            pst.setString(6,telephone.getText());
            pst.setString(7,mail.getText());
            pst.setString(8,motDePasse.getText());
          
            
            System.out.println(pst);
            
            pst.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
