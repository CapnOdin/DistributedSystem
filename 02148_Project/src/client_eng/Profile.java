package client_eng;

import java.io.Serializable;

public class Profile implements Serializable {
	private static final long serialVersionUID = -4449140117055382236L;
	public String username ="", password="", navn="", adresse="", postnummer="", by="", eMail="Lise_Noerby@hotmail.com", harBil="";
	public String momentUsername = "", momentPassword = "";
	public String vikarGUID;
	public api.Calendar calendar, archive;
	
	public Profile(){
		instanciate_calendar();
	}
	
	public Profile(String username, String password){
		this.username = username;
		this.password = password;
		instanciate_calendar();
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
		instanciate_calendar();
	}
	
	private void instanciate_calendar(){
		calendar = new api.Calendar(this);
		archive = new api.Calendar(this);
	}
	
	public String toString(){
		return "username = " + username + ", " + "password = " + password + ", " + "navn = " + navn + ", " + "adresse = " + adresse + ", " + "postnummer = " + postnummer + ", " + "by = " + by + ", " + "eMail = " + eMail + ", " + "harBil = " + harBil;
	}
	
	public void archive_job(String Start){
		archive.add_job(calendar.get_job(Start));
		calendar.delete_job(Start);
	}

}
