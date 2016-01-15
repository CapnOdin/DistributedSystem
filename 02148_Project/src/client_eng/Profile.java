package client_eng;

public class Profile {	
	private String username ="", password="", navn="", adresse="", postnummer="", by="", eMail="", harBil="";
	
	public Profile(){
		setUsername("Lise");
		setPassword("projekt");
		setNavn("Lise Andersen");
		setAdresse("Grønnehøj 39");
		setPostnummer("2720");
		setBy("Vanløse");
		setEMail("Lise_Noerby@hotmail.com");
		setHarBil("1");
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

}
