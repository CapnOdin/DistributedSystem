package api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Calendar implements Serializable {
	
	private static final long serialVersionUID = -6389502885882127246L;
	private HashMap<String, HashMap<String, String>> Vagter;
	public String vikarGUID;
	
	public Calendar(String vikarGUID) {
		Vagter = new HashMap<String, HashMap<String, String>>();
		this.vikarGUID = vikarGUID;	
	}
	
	public String[] get_job_names(){
			return Vagter.keySet().toArray(new String[Vagter.keySet().size()]);
	}
	
	public HashMap<String, String> get_job(String TaskId){
		if(Vagter.containsKey(TaskId)){
			return Vagter.get(TaskId);
		}
		return null;
	}
	
	public void edit_job(String TaskId, String key, String val){
		if(Vagter.containsKey(TaskId)){
			Vagter.get(TaskId).put(key, val);
		}
	}
	
	public void edit_job_multi(String TaskId, HashMap<String, String> edits){
		if(Vagter.containsKey(TaskId)){
			for(String str : edits.keySet()){
				if(Vagter.get(TaskId).containsKey(str)){
					Vagter.get(TaskId).put(str, edits.get(str));
				}
			}
		}
	}
	
	public void add_job(HashMap<String, String> job){
		if(!Vagter.containsKey(job.get("TaskId"))){
			Vagter.put(job.get("TaskId"), job);
		}
	}
	
	public void add_jobs(List<HashMap<String, String>> jobs){
		for(HashMap<String, String> job : jobs){
			this.add_job(job);
		}
	}
	
	public void delete_job(String TaskId){
		if(Vagter.containsKey(TaskId)){
			Vagter.remove(TaskId);
		}
	}
	
	
}
