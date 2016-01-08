package api;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


public class GoogleWebApi {
	
	public static String[] geocoding(String address) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet url = new HttpGet("https://maps.googleapis.com/maps/api/geocode/xml?address=" + address.replace(" ", "+") + "&key=AIzaSyBQGuzq0Ss6n8N1We8zEZ2xy7GwRe0Lpi4");
		
		HttpResponse response = httpClient.execute(url);
		HttpEntity responseEntity = response.getEntity();
		
		String xml = IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8);
		
		if(!xml.contains("<location>")){
			return new String[] {"ZERO", "RESULTS"};
		}
		String coordxml = xml.split("<location>")[1].split("</location>")[0];
		
		return new String[] {coordxml.split("<lat>")[1].split("</lat>")[0], coordxml.split("<lng>")[1].split("</lng>")[0]};
	}
	
	
	public static String distMatrix(String dest, String home) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet url = new HttpGet("https://maps.googleapis.com/maps/api/distancematrix/xml?origins=" + home.replace(" ", "+") + "&destinations=" + dest.replace(" ", "+") + "&key=AIzaSyBQGuzq0Ss6n8N1We8zEZ2xy7GwRe0Lpi4");
		
		HttpResponse response = httpClient.execute(url);
		HttpEntity responseEntity = response.getEntity();
		
		String xml = IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8);
		//System.out.println(xml);
		if(!xml.contains("<distance>")){
			return "ZERO_RESULTS";
		}
		return xml.split("<distance>")[1].split("</distance>")[0].split("<text>")[1].split("</text>")[0].replace(",", "");
	}
	
	
	public static List<String> seachPlaces(String term) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet url = new HttpGet("https://maps.googleapis.com/maps/api/place/textsearch/xml?query=" + term.replace(" ", "+") + ",+Danmark&location=55.676111,12.568333&radius=50000&key=AIzaSyBQGuzq0Ss6n8N1We8zEZ2xy7GwRe0Lpi4");
		
		HttpResponse response = httpClient.execute(url);
		HttpEntity responseEntity = response.getEntity();
		
		String xml = IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8);
		
		List<String> locals = new ArrayList<String>();
		
		if(!xml.contains("<formatted_address>")){
			locals.add("ZERO_RESULTS");
			return locals;
		}
		
		for (String res : xml.split("<result>")){
			if(res.contains("<formatted_address>")){
				locals.add(res.split("<formatted_address>")[1].split("</formatted_address>")[0]);
			}
		}
		
		return locals;
	}
	
	
	public static List<String> seachNearbyPlaces(String term, String[] local) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet url = new HttpGet("https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=" + local[0] + "," + local[1] + "&radius=50000&types=establishment&name=" + term.replace(" ", "+") + "&key=AIzaSyBQGuzq0Ss6n8N1We8zEZ2xy7GwRe0Lpi4");
		
		HttpResponse response = httpClient.execute(url);
		HttpEntity responseEntity = response.getEntity();
		
		String xml = IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8);
		//System.out.println(xml);
		
		List<String> locals = new ArrayList<String>();
		
		if(!xml.contains("<vicinity>")){
			locals.add("ZERO_RESULTS");
			return locals;
		}
		
		for (String res : xml.split("<result>")){
			if(res.contains("<vicinity>")){
				locals.add(res.split("<vicinity>")[1].split("</vicinity>")[0]);
			}
		}
		
		return locals;
	}
	

}
