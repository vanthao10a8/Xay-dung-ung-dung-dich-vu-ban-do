package com.connecting.ws.gcm;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Content implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<String> ids;
	private JSONObject cont = new JSONObject();
    private JSONObject mess=new JSONObject();

	public void addRegId(String regId){
		if(ids == null)
			ids = new LinkedList<String>();
		ids.add(regId);
	}

	public void createData(JSONObject SenderInfo) throws JSONException{
		mess.put("senderinfo", SenderInfo);
	}
	public JSONObject finishCont() throws JSONException
	{
		cont.put("registration_ids", ids);
		cont.put("data", mess);
		System.out.print(cont.toString());
		return cont;
	}
}
