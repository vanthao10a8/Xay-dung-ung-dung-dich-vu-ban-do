package com.connecting.ws.gcm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PushGCM {
	
	private static JSONObject SenderInfo;
	private static JSONArray ListReceiver = new JSONArray();
	private static String apiKey = "AIzaSyCL-UjF8kAUZmdEl5VEX98MUvQmM-Zj7es";
	
	public PushGCM() {

	}
		
	public static void sendGCM(JSONArray Receiver, JSONObject Info) throws JSONException
	{
		ListReceiver = Receiver;
		SenderInfo = Info;
		System.out.println( "Sending POST to GCM" );
		JSONObject content = createContent();
		PostGCM.post(apiKey, content);
	}
	
	public static JSONObject createContent() throws JSONException
	{
		String gcmid;
		Content c = new Content();
		for (int i=0;i<ListReceiver.length();i++)
		{ 
			JSONObject obj = (JSONObject) ListReceiver.get(i);
			gcmid = (String) obj.get("gcmrcv");
			c.addRegId(gcmid);
		} 
		c.createData(SenderInfo);
		return c.finishCont();
	}
}
