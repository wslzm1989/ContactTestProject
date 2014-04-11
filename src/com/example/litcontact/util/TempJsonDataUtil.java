package com.example.litcontact.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.litcontact.domain.ContactData;

/**
 * 联系人json假数据
 * 
 * @author Administrator
 * 
 */
public class TempJsonDataUtil {

	private static final String CONTACT_JSON = "{" + "\"contact_list\" : ["
			+ "{\"contactName\":\"李四\",\"contactPhoneNum\":\"13556782354\"},"
			+ "{\"contactName\":\"张三\",\"contactPhoneNum\":\"16542782354\"},"
			+ "{\"contactName\":\"王五\",\"contactPhoneNum\":\"13916782354\"},"
			+ "{\"contactName\":\"西门庆\",\"contactPhoneNum\":\"15956782354\"},"
			+ "{\"contactName\":\"武松\",\"contactPhoneNum\":\"18556782354\"},"
			+ "{\"contactName\":\"东方白\",\"contactPhoneNum\":\"16956782354\"},"
			+ "{\"contactName\":\"令狐冲\",\"contactPhoneNum\":\"18853692399\"},"
			+ "{\"contactName\":\"风清扬\",\"contactPhoneNum\":\"19556782354\"},"
			+ "{\"contactName\":\"乔峰\",\"contactPhoneNum\":\"17756782354\"},"
			+ "{\"contactName\":\"段誉\",\"contactPhoneNum\":\"18256786953\"},"
			+ "{\"contactName\":\"虚竹\",\"contactPhoneNum\":\"13456555554\"},"
			+ "{\"contactName\":\"西门吹雪\",\"contactPhoneNum\":\"13256984214\"},"
			+ "{\"contactName\":\"刘备\",\"contactPhoneNum\":\"15536522354\"},"
			+ "{\"contactName\":\"张飞\",\"contactPhoneNum\":\"15953836924\"},"
			+ "{\"contactName\":\"关云长\",\"contactPhoneNum\":\"13398536214\"},"
			+ "{\"contactName\":\"曹操\",\"contactPhoneNum\":\"18874623651\"},"
			+ "{\"contactName\":\"诸葛亮\",\"contactPhoneNum\":\"18926132514\"},"
			+ "{\"contactName\":\"孙权\",\"contactPhoneNum\":\"15874132651\"},"
			+ "{\"contactName\":\"孙坚\",\"contactPhoneNum\":\"18263845997\"},"
			+ "{\"contactName\":\"孙策\",\"contactPhoneNum\":\"18636452914\"},"
			+ "{\"contactName\":\"赵子龙\",\"contactPhoneNum\":\"15633215662\"},"
			+ "{\"contactName\":\"魏延\",\"contactPhoneNum\":\"13426158892\"},"
			+ "{\"contactName\":\"刘禅\",\"contactPhoneNum\":\"15636958621\"},"
			+ "{\"contactName\":\"曹丕\",\"contactPhoneNum\":\"15964872135\"},"
			+ "{\"contactName\":\"司马昭\",\"contactPhoneNum\":\"18836225541\"},"
			+ "{\"contactName\":\"段延庆\",\"contactPhoneNum\":\"18736652298\"},"
			+ "{\"contactName\":\"欧阳锋\",\"contactPhoneNum\":\"12694362236\"}"
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
			OutputUtil.printText("解析联系人临时数据异常.......");
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
