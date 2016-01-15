package api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class AddressUtil {
	public static List<String> stripNonEgennavne(String term){
		String res = "";
		List<String> address = new ArrayList<String>();
		
		Pattern ALPHA = Pattern.compile("[A-ZÀ-Ý]");
		Pattern number = Pattern.compile("[0-9]");
		Pattern special = Pattern.compile("[^a-zA-Z0-9&&[^ß-ýÀ-Ý]&&[^,.-]&&[^\\u0027]]"); // \u0027 is '
		Pattern dontThinkAboutIt = Pattern.compile("[×÷]");
		
		System.out.println(term);
		
		try{
			for(String str : term.split(" ")){
				if(str.contains("-")){
					int index = str.indexOf("-");
					String temp = str.substring(index + 1, index + 2);
					if(!ALPHA.matcher(temp).find()){
						continue;
					}
				}
				if((ALPHA.matcher(str).find() || number.matcher(str).find()) && !special.matcher(str).find() && !dontThinkAboutIt.matcher(str).find()){
					res += str + " ";
				}
			}
		} catch (Exception e){
			
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
