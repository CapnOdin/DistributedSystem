package api;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import client_eng.Profile;

public class Serializer {
	
	public static void save(Profile cal) throws IOException{
		FileOutputStream fout = new FileOutputStream("resourses\\" + cal.vikarGUID +".ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(cal);
		oos.close();
	}
	
	public static Profile load(String vikarGUID) throws IOException, ClassNotFoundException{
		Profile cal;
		FileInputStream fin = new FileInputStream("resourses\\" + vikarGUID +".ser");
		ObjectInputStream ois = new ObjectInputStream(fin);
		cal = (Profile) ois.readObject();
		ois.close();
		return cal;
	}
	
	public static void main(String[] args) throws Exception {
		String[] str = api.MomentApi.loginMoment("Lise_Noerby@hotmail.com", "projekt");
		Profile cal = new Profile();
		cal.vikarGUID = str[0];
		cal.calendar.add_jobs(api.MomentApi.getVagter("2016-01-15", str[0]));
		for(String job : cal.calendar.get_job_names()){
			System.out.print(cal.calendar.get_job(job).get("Title") + "; ");
		}
		System.out.println("");
		Serializer.save(cal);
		cal = null;
		String[] str2 = api.MomentApi.loginMoment("Lise_Noerby@hotmail.com", "projekt");
		Profile cal2 = Serializer.load(str2[0]);
		for(String job : cal2.calendar.get_job_names()){
			System.out.print(cal2.calendar.get_job(job).get("Title") + "; ");
		}
	}
	
	
}
