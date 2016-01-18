package api;

public class main {
	
	public static void main(String[] args) {
		try {
			String[] str = api.MomentApi.loginMoment("Geelsmark@hotmail.com", "liseskaterskør");
			//String[] str = api.MomentApi.loginMoment("Lise_Noerby@hotmail.com", "projekt");
			api.MomentApi.getVagter("2016-01-15", str[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
