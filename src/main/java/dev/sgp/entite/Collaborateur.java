package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

// TODO: Auto-generated Javadoc
/**
 * The Class Collaborateur.
 */
public class Collaborateur {

	/** The matricule. */
	private String matricule;
	
	/** The nom. */
	private String nom;
	
	/** The prenom. */
	private String prenom;
	
	/** The date naissance. */
	private LocalDate dateNaissance;
	
	/** The adresse. */
	private String adresse;
	
	/** The numero securite social. */
	private String numeroSecuriteSocial;
	
	/** The email pro. */
	private String emailPro;
	
	/** The photo. */
	private String photo;
	
	/** The date heure creation. */
	private ZonedDateTime dateHeureCreation;
	
	private static int cmpt = 0;
	
	/**
	 * Instantiates a new collaborateur.
	 */
	public Collaborateur() {
		
	}
	
	
	/**
	 * Instantiates a new collaborateur.
	 *
	 * @param nom the nom
	 * @param prenom the prenom
	 * @param dateNaissance the date naissance
	 * @param adresse the adresse
	 * @param numeroSecuriteSocial the numero securite social
	 * @param emailPro the email pro
	 * @param photo the photo
	 */
	public Collaborateur(String nom, String prenom, LocalDate dateNaissance, String adresse,
			String numeroSecuriteSocial) {		
		ResourceBundle properties = ResourceBundle.getBundle("application");
		String suffixe = properties.getString("email.suffixe");
				
		this.matricule = "M" + cmpt++;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.numeroSecuriteSocial = numeroSecuriteSocial;
		this.emailPro = nom.toLowerCase()+"."+prenom.toLowerCase()+"@" + suffixe.toLowerCase();
		this.photo = "https://cdn.pixabay.com/photo/2017/02/23/13/05/profile-2092113_960_720.png";
		this.dateHeureCreation = ZonedDateTime.now();
	}


	/**
	 * Gets the matricule.
	 *
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}


	/**
	 * Sets the matricule.
	 *
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * Sets the nom.
	 *
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * Gets the prenom.
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * Sets the prenom.
	 *
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * Gets the date naissance.
	 *
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}


	/**
	 * Sets the date naissance.
	 *
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	/**
	 * Gets the adresse.
	 *
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/**
	 * Sets the adresse.
	 *
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/**
	 * Gets the numero securite social.
	 *
	 * @return the numeroSecuriteSocial
	 */
	public String getNumeroSecuriteSocial() {
		return numeroSecuriteSocial;
	}


	/**
	 * Sets the numero securite social.
	 *
	 * @param numeroSecuriteSocial the numeroSecuriteSocial to set
	 */
	public void setNumeroSecuriteSocial(String numeroSecuriteSocial) {
		this.numeroSecuriteSocial = numeroSecuriteSocial;
	}


	/**
	 * Gets the email pro.
	 *
	 * @return the emailPro
	 */
	public String getEmailPro() {
		return emailPro;
	}


	/**
	 * Sets the email pro.
	 *
	 * @param emailPro the emailPro to set
	 */
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}


	/**
	 * Gets the photo.
	 *
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}


	/**
	 * Sets the photo.
	 *
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}


	/**
	 * Gets the date heure creation.
	 *
	 * @return the dateHeureCreation
	 */
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}


	/**
	 * Sets the date heure creation.
	 *
	 * @param dateHeureCreation the dateHeureCreation to set
	 */
	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

}
