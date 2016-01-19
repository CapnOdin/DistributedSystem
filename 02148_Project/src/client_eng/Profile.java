package client_eng;

import java.io.Serializable;

public class Profile implements Serializable {
	private static final long serialVersionUID = -4449140117055382236L;
	private String username ="", password="", navn="", adresse="", postnummer="", by="", eMail="", harBil="";
	private String momentUsername = "", momentPassword = "";
	public String vikarGUID;
	public api.Calendar calendar;
	
	public Profile(){
		setUsername("Lise");
		setPassword("projekt");
		setNavn("Lise Andersen");
		setAdresse("Grønnehøj 39");
		setPostnummer("2720");
		setBy("Vanløse");
		setEMail("Lise_Noerby@hotmail.com");
		setHarBil("1");
		calendar = new api.Calendar();
	}
	
	public Profile(String user, String password, String name, String address, String zipcode, String city, String email, String car) {
		this.username = user;
		this.password = password;
		this.navn = name;
		this.adresse = address;
		this.postnummer = zipcode;
		this.by = city;
		this.eMail = email;
		this.harBil = car;
		calendar = new api.Calendar();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPostnummer() {
		return postnummer;
	}

	public void setPostnummer(String postnummer) {
		this.postnummer = postnummer;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public String getHarBil() {
		return harBil;
	}

	public void setHarBil(String harBil) {
		this.harBil = harBil;
	}
	
	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public String getMomentUsername() {
		return momentUsername;
	}

	public void setMomentUsername(String momentUsername) {
		this.momentUsername = momentUsername;
	}

	public String getMomentPassword() {
		return momentPassword;
	}

	public void setMomentPassword(String momentPassword) {
		this.momentPassword = momentPassword;
	}

}
