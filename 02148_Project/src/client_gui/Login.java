package client_gui;

public class Login {

	public static boolean authenticate(String username, String password) {
		// hardcoded username and password
		if (username.equals("Lise") && password.equals("projekt")) {
			return true;
		}
		return false;
	}
}
