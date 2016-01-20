package api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Calendar implements Serializable {
	
	private static final long serialVersionUID = -6389502885882127246L;
	private HashMap<String, HashMap<String, String>> Vagter;
	//public String vikarGUID;
	
	public Calendar() {
		Vagter = new HashMap<String, HashMap<String, String>>();
		//this.vikarGUID = vikarGUID;
	}
	
	public String[] get_job_names(){
			return Vagter.keySet().toArray(new String[Vagter.keySet().size()]);
	}
	
	public HashMap<String, String> get_job(String Start){
		if(Vagter.containsKey(Start)){
			return Vagter.get(Start);
		}
		return null;
	}
	
	public void edit_job(String Start, String key, String val){
		if(Vagter.containsKey(Start)){
			Vagter.get(Start).put(key, val);
		}
	}
	
	public void edit_job_multi(String Start, HashMap<String, String> edits){
		if(Vagter.containsKey(Start)){
			for(String str : edits.keySet()){
				if(Vagter.get(Start).containsKey(str)){
					Vagter.get(Start).put(str, edits.get(str));
				}
			}
		}
	}
	
	public void add_job(HashMap<String, String> job){
		if(!Vagter.containsKey(job.get("Start"))){
			Vagter.put(job.get("Start"), job);
		}
	}
	
	public void add_jobs(List<HashMap<String, String>> jobs){
		for(HashMap<String, String> job : jobs){
			if(job.get("AvailabilityType").equals("3")){
				this.add_job(process(job));
			}
		}
	}
	
	public void delete_job(String Start){
		if(Vagter.containsKey(Start)){
			Vagter.remove(Start);
		}
	}
	
	private HashMap<String, String> process(HashMap<String, String> job){
		HashMap<String, String> formatedJop = new HashMap<String, String>();
		
		String temp = "";
		
		formatedJop.put("Start", job.get("Start"));
		
		formatedJop.put("Date", job.get("Start").split("T")[0]);
		formatedJop.put("StartTime", job.get("Start").split("T")[1].substring(0, 5));
		formatedJop.put("EndTime", job.get("End").split("T")[1].substring(0, 5));
		formatedJop.put("Address", formatStr(job.get("Title")));
		formatedJop.put("Name", formatStr(job.get("JobName")));
		
		return formatedJop;
	}
	
	private String formatStr(String str){
		if(str.contains(":")){
			str = str.split(": ")[1];
		} else if(str.contains(",")) {
			str = str.split(", ")[1];
		}
		if(str.contains(",")){
			str = str.split(",")[0];
		} else if(str.contains(".")) {
			str = str.split("\\.")[0];
		}
		
		return str;
	}
	
//	AvailabilityType
//	AvailabilityTypeText
//	Description
//	End
//	EndTimezone
//	IsAllDay
//	JobName
//	Msg
//	ShiftStatus
//	Start
//	StartTimezone
//	TaskId
//	Title
//	ViewSideBySideBpData
//	VikarGuid
//	VikarId
	
}
