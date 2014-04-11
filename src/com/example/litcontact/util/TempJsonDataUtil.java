package com.example.litcontact.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.litcontact.domain.ContactData;

/**
 * ��ϵ��json������
 * 
 * @author Administrator
 * 
 */
public class TempJsonDataUtil {

	private static final String CONTACT_JSON = "{" + "\"contact_list\" : ["
			+ "{\"contactName\":\"����\",\"contactPhoneNum\":\"13556782354\"},"
			+ "{\"contactName\":\"����\",\"contactPhoneNum\":\"16542782354\"},"
			+ "{\"contactName\":\"����\",\"contactPhoneNum\":\"13916782354\"},"
			+ "{\"contactName\":\"������\",\"contactPhoneNum\":\"15956782354\"},"
			+ "{\"contactName\":\"����\",\"contactPhoneNum\":\"18556782354\"},"
			+ "{\"contactName\":\"������\",\"contactPhoneNum\":\"16956782354\"},"
			+ "{\"contactName\":\"�����\",\"contactPhoneNum\":\"18853692399\"},"
			+ "{\"contactName\":\"������\",\"contactPhoneNum\":\"19556782354\"},"
			+ "{\"contactName\":\"�Ƿ�\",\"contactPhoneNum\":\"17756782354\"},"
			+ "{\"contactName\":\"����\",\"contactPhoneNum\":\"18256786953\"},"
			+ "{\"contactName\":\"����\",\"contactPhoneNum\":\"13456555554\"},"
			+ "{\"contactName\":\"���Ŵ�ѩ\",\"contactPhoneNum\":\"13256984214\"},"
			+ "{\"contactName\":\"����\",\"contactPhoneNum\":\"15536522354\"},"
			+ "{\"contactName\":\"�ŷ�\",\"contactPhoneNum\":\"15953836924\"},"
			+ "{\"contactName\":\"���Ƴ�\",\"contactPhoneNum\":\"13398536214\"},"
			+ "{\"contactName\":\"�ܲ�\",\"contactPhoneNum\":\"18874623651\"},"
			+ "{\"contactName\":\"�����\",\"contactPhoneNum\":\"18926132514\"},"
			+ "{\"contactName\":\"��Ȩ\",\"contactPhoneNum\":\"15874132651\"},"
			+ "{\"contactName\":\"���\",\"contactPhoneNum\":\"18263845997\"},"
			+ "{\"contactName\":\"���\",\"contactPhoneNum\":\"18636452914\"},"
			+ "{\"contactName\":\"������\",\"contactPhoneNum\":\"15633215662\"},"
			+ "{\"contactName\":\"κ��\",\"contactPhoneNum\":\"13426158892\"},"
			+ "{\"contactName\":\"����\",\"contactPhoneNum\":\"15636958621\"},"
			+ "{\"contactName\":\"��ا\",\"contactPhoneNum\":\"15964872135\"},"
			+ "{\"contactName\":\"˾����\",\"contactPhoneNum\":\"18836225541\"},"
			+ "{\"contactName\":\"������\",\"contactPhoneNum\":\"18736652298\"},"
			+ "{\"contactName\":\"ŷ����\",\"contactPhoneNum\":\"12694362236\"}"
			+ "]}";

	public static ArrayList<ContactData> parshTempContactData() {
		ArrayList<ContactData> tempList = new ArrayList<ContactData>();
		JSONArray jsonObjs;
		try {
			jsonObjs = new JSONObject(CONTACT_JSON)
					.getJSONArray("contact_list");

			String s = "";

			
			for (int i = 0; i < jsonObjs.length(); i++) {
				
				JSONObject jsonObj = jsonObjs.getJSONObject(i);

				String name = jsonObj.getString("contactName");

				String num = jsonObj.getString("contactPhoneNum");

				ContactData data = new ContactData(name, num);
				tempList.add(data);
			}
			
		} catch (JSONException e) {
			OutputUtil.printText("������ϵ����ʱ�����쳣.......");
			e.printStackTrace();
		}
		
		return tempList;
	}
	
	/**
	 * "{" + "   \"phone\" : [\"12345678\", \"87654321\"]," +
	 * "   \"name\" : \"yuanzhifei89\"," + "   \"age\" : 100," +
	 * "   \"address\" : { \"country\" : \"china\", \"province\" : \"jiangsu\" },"
	 * + "   \"married\" : false," + "}";
	 */
}
