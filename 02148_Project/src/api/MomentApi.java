package api;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;


public class MomentApi {
	public static String[] loginMoment(String email, String pass) throws Exception {
		HttpPost uploadFile;
		MultipartEntityBuilder builder;
		HttpResponse response;
		HttpEntity responseEntity;
		Map<String, String> addressDict;
		String address = "", vikarGUID = "", str = "";
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		try{
			// logging in via Post
			uploadFile = new HttpPost("https://www.moment.dk/staff/login");
			builder = MultipartEntityBuilder.create();
			builder.addTextBody("UserName", email, ContentType.TEXT_PLAIN);
			builder.addTextBody("Password", pass, ContentType.TEXT_PLAIN);
			builder.addTextBody("action:Login", "", ContentType.TEXT_PLAIN);
			//builder.addTextBody("ufprt", "E72A01AEA2F5FCC58E32479C3522A99D1D3C973E5B6D6C7787CCBA10E374FCF67555CA701AAF324756BB11DBBB9C43401EB3B9D9446CC1A3D725DAC6052CA8A5D046E4EE11C3A9EA247CC5B9954FCF16AFDDDA49517A55728EEE04719F719CB1F2B3CCE43B7027F5AFF22B510A9B2E2CC803922180E74C65D7067CC31F58124232E46316B73A2FE6C2B5151964AF6573C1BFEDD0194474FEF69B026504F4E1A3", ContentType.TEXT_PLAIN);
			builder.addTextBody("ufprt", "18423882180303C2CC82F8EF10AD9E784519FD791D007DDA9F7F3F4791666EB7130996455CC9BA89FEF7DF892A0C8FCBD8DCBCF82A1ED2DDDEF9CE445A2B6F56FB1F166B7DAB9610561BF7536105256AC8A8E7A15031CB2921ED78944E2C4A21223C213B3D6A8183598BF8909EC2B00352D85CBF8948B46DED484F4B725C455BCDF4F7E2A6FF1CA355D9D0E88AF47CF77BD0B1724B6F0FCBE44EE54447FEF382", ContentType.TEXT_PLAIN);
			HttpEntity multipart = builder.build();
			uploadFile.setEntity(multipart);
			httpClient.execute(uploadFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			// Geting vikarGUID
			HttpGet getvikarGUID = new HttpGet("https://www.moment.dk/vikar/profil/stamdata/personlige-data/");
			response = httpClient.execute(getvikarGUID);
			responseEntity = response.getEntity();
			str = IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8);
			int index = str.indexOf("var studGuid = (\"");
			vikarGUID = str.substring(index, index + 80);
			vikarGUID = vikarGUID.substring(vikarGUID.indexOf("(\"") + 2, vikarGUID.indexOf("\")"));
			System.out.println(vikarGUID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			// Geting user data
			HttpGet getuserData = new HttpGet("https://www.moment.dk/api/Validated/GetStudentBaseProfile/"+ vikarGUID +"?_=1452272073212");
			response = httpClient.execute(getuserData);
			responseEntity = response.getEntity();
			str = IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8);
			
			String[] dics = str.replaceAll("\"", "").replace("{", "").split("},");
			
			for (String dic : dics) {
				if(dic.startsWith("MAddress")){
					addressDict = generateDictionarie(dic.substring(9));
					address = addressDict.get("Street") + " " + addressDict.get("StreetNr") + ", " + addressDict.get("ZipCode") + " " + addressDict.get("City");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new String[] {vikarGUID, address};
	}
	
	
	public static List<HashMap<String, String>> getVagter(String date, String vikarGUID) throws Exception {
		String vagter = "{\"state\":\"Error\"}";
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		try{
			HttpPost poster = new HttpPost("https://www.moment.dk/api/VikarCalendar/GetConsolidatedListOfVagtTasks/1");
			
			StringEntity params = new StringEntity("{\"vikarGUID\":\"" + vikarGUID + "\",\"start\":\"" + date + "T00:00:00.000Z\",\"viewSideBySideBPData\":\"false\"}");
			
			poster.addHeader("Content-type","application/json");
			poster.setEntity(params);
			HttpResponse response = httpClient.execute(poster);
			HttpEntity responseEntity = response.getEntity();
			
			String str = IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8);
			System.out.println(str);
			vagter = str.substring(1, str.length() - 2);
		} catch (Exception e) {
			
		}
		return generateListOfDictionaries(vagter);
	}
	
	
	public static List<HashMap<String, String>> generateListOfDictionaries(String str) {
		List<HashMap<String, String>> dictvagt = new ArrayList<HashMap<String, String>>();
		try{
			String[] dics = str.substring(1, str.length() - 2).replaceAll("\"", "").replace("{", "").split("},");
			for (String dic : dics) {
				dictvagt.add(generateDictionarie(dic));
			}
		} catch (Exception e) {
			
		}
		return dictvagt;
	}
	
	
	public static HashMap<String, String> generateDictionarie(String str) {
		HashMap<String, String> dict = new HashMap<String, String>();
		try{
			String[] pairs = str.replace(", ", "; ").split(",");
			for (String pair : pairs) {
				int index = pair.indexOf(":");
				String tempStr = pair.replace("; ", ", ");
				dict.put(tempStr.substring(0, index), tempStr.substring(index + 1));
			}
		} catch (Exception e) {
			
		}
		return dict;
	}
}
