package api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class AddressUtil {
	public static List<String> stripNonEgennavne(String term){
		String res = "";
		List<String> address = new ArrayList<String>();
		
		Pattern ALPHAnum = Pattern.compile("[A-Z0-9]");
		Pattern special = Pattern.compile("[^a-zA-Z0-9&&[^ß-ıÀ-İ]&&[^,.]]");
		
		for(String str : term.split(" ")){
			if(ALPHAnum.matcher(str).find() && !special.matcher(str).find()){
				res += str + " ";
			}
		}
		
		if(res.length() != 0){
			res = res.substring(0, res.length()-1);
		}
		
		if(res.contains(",")){
			address.addAll(new ArrayList<String>(Arrays.asList(res.replace(", ", ",").split(","))));
			
		} else {
			address.add(res);
		}
		
		return address;
	}
}
