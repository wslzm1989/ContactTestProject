package com.example.litcontact.util;

public class LitMessage {

	public int what;
	public int arg1;
	public int arg2;
	public Object obj;
	
	public LitMessage(){}
	
	public LitMessage(int what) {
		this(what,0,0,null);
	}
	
	public LitMessage(int what, Object obj) {
		this(what, 0, 0, obj);
	}
	
	public LitMessage(int what, int arg1, int arg2, Object obj) {
		this.what = what;
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.obj = obj;
	}
	
}
