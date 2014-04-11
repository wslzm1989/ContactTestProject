package com.example.litcontact.domain;

import com.example.litcontact.util.SoftKeyDataUtil;

public class ContactData {

	public String contactName;
	public String contactPhoneNum;
	public String pyname;
	public String group; //Æ¥ÅäµÄËÑË÷¶Î
	
	public ContactData(){}
	
	public ContactData(String conName, String conNum) {
		this.contactName = conName;
		this.contactPhoneNum = conNum;
		this.group = "";
		this.pyname = SoftKeyDataUtil.getPingYin(conName);
	}
	
}
