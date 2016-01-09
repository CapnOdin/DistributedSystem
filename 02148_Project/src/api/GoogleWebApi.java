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
	
	static String KEY = "AIzaSyBQGuzq0Ss6n8N1We8zEZ2xy7GwRe0Lpi4";
	
	public static List<String> geocoding(String address) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet url = new HttpGet("https://maps.googleapis.com/maps/api/geocode/xml?address=" + address.replace(" ", "+") + "&key=" + KEY);
		
		HttpResponse response = httpClient.execute(url);
		HttpEntity responseEntity = response.getEntity();
		
		String xml = IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8);
		
		List<String> results = new ArrayList<String>();
		
		if(xml.contains("<status>")){
			results.add(xml.split("<status>")[1].split("</status>")[0]);
		}
		if(xml.contains("<location>")){
			String coordxml = xml.split("<location>")[1].split("</location>")[0];
		
			results.add(coordxml.split("<lat>")[1].split("</lat>")[0]);
			results.add(coordxml.split("<lng>")[1].split("</lng>")[0]);
		}
		return results;
	}
	
	
	public static List<String> distMatrix(String dest, String home) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet url = new HttpGet("https://maps.googleapis.com/maps/api/distancematrix/xml?origins=" + home.replace(" ", "+") + "&destinations=" + dest.replace(" ", "+") + "&key=" + KEY);
		
		HttpResponse response = httpClient.execute(url);
		HttpEntity responseEntity = response.getEntity();
		
		String xml = IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8);
		//System.out.println(xml);
		
		List<String> results = new ArrayList<String>();
		
		if(xml.contains("<status>")){
			results.add(xml.split("<status>")[1].split("</status>")[0]);
		}
		
		if(xml.contains("<distance>")){
			results.add(xml.split("<distance>")[1].split("</distance>")[0].split("<text>")[1].split("</text>")[0].replace(",", ""));
		}
		
		return results;
	}
	
	
	public static List<String> seachPlaces(String term) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet url = new HttpGet("https://maps.googleapis.com/maps/api/place/textsearch/xml?query=" + term.replace(" ", "+") + ",+Danmark&location=55.676111,12.568333&radius=50000&key=" + KEY);
		
		HttpResponse response = httpClient.execute(url);
		HttpEntity responseEntity = response.getEntity();
		
		String xml = IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8);
		//System.out.println(xml);
		
		List<String> results = new ArrayList<String>();
		
		if(xml.contains("<status>")){
			results.add(xml.split("<status>")[1].split("</status>")[0]);
		}
	
		if(xml.contains("<formatted_address>")){
			for (String res : xml.split("<result>")){
				if(res.contains("<formatted_address>")){
					results.add(res.split("<formatted_address>")[1].split("</formatted_address>")[0]);
				}
			}
		}
		return results;
	}
	
	
	public static List<String> seachNearbyPlaces(String term, List<String> local) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet url = new HttpGet("https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=" + local.get(1) + "," + local.get(2) + "&radius=50000&types=establishment&name=" + term.replace(" ", "+") + "&key=" + KEY);
		
		HttpResponse response = httpClient.execute(url);
		HttpEntity responseEntity = response.getEntity();
		
		String xml = IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8);
		//System.out.println(xml);
		
		List<String> results = new ArrayList<String>();
		
		if(xml.contains("<status>")){
			results.add(xml.split("<status>")[1].split("</status>")[0]);
		}
		
		if(xml.contains("<vicinity>")){
			for (String res : xml.split("<result>")){
				if(res.contains("<vicinity>")){
					results.add(res.split("<vicinity>")[1].split("</vicinity>")[0]);
				}
			}
		}
		
		return results;
	}
	

}
