package client_eng;

import java.io.Serializable;

public class Profile implements Serializable {
	private static final long serialVersionUID = -4449140117055382236L;
	public String username ="", password="", navn="", adresse="", postnummer="", by="", eMail="", harBil="";
	private String momentUsername = "", momentPassword = "";
	public String vikarGUID;
	public api.Calendar calendar;
	
	public Profile(){
		calendar = new api.Calendar(); 
	}
	
	public Profile(String username, String password){
		this.username = username;
		this.password = password;
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
	
	public String toString(){
		return "username = " + username + ", " + "password = " + password + ", " + "navn = " + navn + ", " + "adresse = " + adresse + ", " + "postnummer = " + postnummer + ", " + "by = " + by + ", " + "eMail = " + eMail + ", " + "harBil = " + harBil;
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
