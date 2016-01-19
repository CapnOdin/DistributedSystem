package client_eng;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 8239691071648536847L;
	
	private String userName;
	private Profile profile;
	
	public User(String userName, Profile profile) {
		this.setUserName(userName);
		this.setProfile(profile);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
