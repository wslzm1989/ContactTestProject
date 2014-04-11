package com.example.litcontactnew;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.litcontact.adapter.ContactAdapter;
import com.example.litcontact.domain.ContactData;
import com.example.litcontact.util.OutputUtil;
import com.example.litcontact.util.SoftKeyDataUtil;
import com.example.litcontact.util.TempJsonDataUtil;

public class MainActivity extends Activity implements OnClickListener, OnTouchListener {

	private List<ContactData> allContactList;
	private List<ContactData> searchContactList;
	private ContactAdapter mAdapter;
	
	private EditText input_edit;
	private ListView myListView;
	private LinearLayout softLayout;
	
	private Button oneBtn;
	
	private Button twoBtn;
	private Button threeBtn;
	private Button fourBtn;
	private Button fiveBtn;
	private Button sixBtn;
	private Button sevenBtn;
	private Button eigterBtn;
	private Button nineBtn;
	private Button xingBtn;
	private Button zeroBtn;
	private Button jingBtn;
	
	private Button updateBtn;
	private Button callBtn;
	private Button deleteBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
		
		Display display = this.getWindowManager().getDefaultDisplay();
		int nHeight = display.getHeight();
		int nWidth = display.getWidth();
		
		OutputUtil.printText("nWidth="+nWidth+"...nHeight="+nHeight);
	}


	private void initView() {

//		allContactList = new ArrayList<ContactData>();
		searchContactList = new ArrayList<ContactData>();
		mAdapter = new ContactAdapter(this);
			
		input_edit = (EditText) findViewById(R.id.main_input_edit);
		input_edit.setOnTouchListener(this);
		/*
		 * 屏蔽系统键盘的弹出
		 */
		if (android.os.Build.VERSION.SDK_INT <= 10) {
			input_edit.setInputType(InputType.TYPE_NULL);
		} else {
			getWindow().setSoftInputMode(
					WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
			try {
				Class<EditText> cls = EditText.class;
				Method setShowSoftInputOnFocus;
				setShowSoftInputOnFocus = cls.getMethod(
						"setShowSoftInputOnFocus", boolean.class);
				setShowSoftInputOnFocus.setAccessible(true);
				setShowSoftInputOnFocus.invoke(input_edit, false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		input_edit.addTextChangedListener(new EdittextWatcher());
		
		oneBtn = (Button) findViewById(R.id.main_one_btn);
		oneBtn.setOnClickListener(this);
		
		twoBtn = (Button) findViewById(R.id.main_two_btn);
		twoBtn.setOnClickListener(this);
		threeBtn = (Button) findViewById(R.id.main_three_btn);
		threeBtn.setOnClickListener(this);
		fourBtn = (Button) findViewById(R.id.main_four_btn);
		fourBtn.setOnClickListener(this);
		fiveBtn = (Button) findViewById(R.id.main_five_btn);
		fiveBtn.setOnClickListener(this);
		sixBtn = (Button) findViewById(R.id.main_six_btn);
		sixBtn.setOnClickListener(this);
		sevenBtn = (Button) findViewById(R.id.main_seven_btn);
		sevenBtn.setOnClickListener(this);
		eigterBtn = (Button) findViewById(R.id.main_eigter_btn);
		eigterBtn.setOnClickListener(this);
		nineBtn = (Button) findViewById(R.id.main_nine_btn);
		nineBtn.setOnClickListener(this);
		xingBtn = (Button) findViewById(R.id.main_xing_btn);
		xingBtn.setOnClickListener(this);
		jingBtn = (Button) findViewById(R.id.main_jing_btn);
		jingBtn.setOnClickListener(this);
		zeroBtn = (Button) findViewById(R.id.main_zero_btn);
		zeroBtn.setOnClickListener(this);
		
		updateBtn = (Button) findViewById(R.id.main_update_btn);
		updateBtn.setOnClickListener(this);
		callBtn = (Button) findViewById(R.id.main_call_btn);
		callBtn.setOnClickListener(this);
		deleteBtn = (Button) findViewById(R.id.main_delete_btn);
		deleteBtn.setOnClickListener(this);
		
		
		myListView = (ListView) findViewById(R.id.main_listview);
		myListView.setOnTouchListener(this);
		myListView.setAdapter(mAdapter);
		
		softLayout = (LinearLayout) findViewById(R.id.main_softkey_layout);
	}
	
	private void initData() {
		allContactList = TempJsonDataUtil.parshTempContactData();
		mAdapter.refresh(allContactList, true);
	}


	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.main_one_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "1");
			break;
		case R.id.main_two_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "2");
			break;
		case R.id.main_three_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "3");
			break;
		case R.id.main_four_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "4");
			break;
		case R.id.main_five_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "5");
			break;
		case R.id.main_six_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "6");
			break;
		case R.id.main_seven_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "7");
			break;
		case R.id.main_eigter_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "8");
			break;
		case R.id.main_nine_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "9");
			break;
		case R.id.main_zero_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "0");
			break;
		case R.id.main_xing_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "*");
			break;
		case R.id.main_jing_btn:
			input_edit.getText().insert(input_edit.getSelectionEnd(), "#");
			break;
			
			
		case R.id.main_delete_btn:
			
			int length = input_edit.getSelectionEnd();
            if(length > 0)
            {
            	input_edit.getText().delete(length - 1, length);
            }
			break;
			
		case R.id.main_update_btn:
			OutputUtil.printText("更新.........");
			break;
			
		case R.id.main_call_btn:
			
			String callNum = input_edit.getText().toString();
			Intent intent=new Intent();
			intent.setAction("android.intent.action.CALL");
			intent.setData(Uri.parse("tel:"+callNum));
			startActivity(intent);
			
			break;
			
		default:
			break;
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		switch (v.getId()) {
		case R.id.main_input_edit:
			if(softLayout.getVisibility() == View.GONE) {
				softLayout.setVisibility(View.VISIBLE);
			}
			break;
		case R.id.main_listview:
			if(softLayout.getVisibility() == View.VISIBLE) {
				softLayout.setVisibility(View.GONE);
			}
			break;
		default:
			break;
		}
		
		return false;
	}
	
	/**
	 * 监听edittext内容变化事件
	 * @author Administrator
	 *
	 */
	class EdittextWatcher implements TextWatcher {

		@Override
		public void afterTextChanged(Editable arg0) {
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
		}


		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			
			if(TextUtils.isEmpty(s)){
				mAdapter.refresh(allContactList, true);
			} else {
				search(s.toString());
			}
		}
		
	}

	/**
	 * 按号码-拼音搜索联系人
	 * @param str
	 */
	public void search(String str){
		searchContactList.clear();
		//如果搜索条件以0 1 +开头则按号码搜索
		if(str.toString().startsWith("0") || str.toString().startsWith("1")
				 || str.toString().startsWith("+") || str.toString().contains("*")){
			for(ContactData model : allContactList){
				if(model.contactPhoneNum.contains(str)){
					model.group = str;
					searchContactList.add(model);
				}
			}
			mAdapter.refresh(searchContactList, false);
			return;
		}
		StringBuffer sb = new StringBuffer();
		//获取每一个数字对应的字母列表并以'-'隔开
		for(int i = 0; i < str.length(); i++){
			sb.append((str.charAt(i) <= '9' && str.charAt(i) >= '0')
					? SoftKeyDataUtil.STRS[str.charAt(i) - '0'] : str.charAt(i));
			
			if(i != str.length() - 1){
				sb.append("-");
			}
		}
		
		for(ContactData model : allContactList){
			if(contains(sb.toString(), model, str)){
				searchContactList.add(model);
			} else if(model.contactPhoneNum.contains(str)){
				model.group = str;
				searchContactList.add(model);
			}
		}
		mAdapter.refresh(searchContactList, false);
    }
	
	/**
	 * 根据拼音搜索
	 * @param str			正则表达式
	 * @param pyName		拼音
	 * @param isIncludsive	搜索条件是否大于6个字符
	 * @return
	 */
	public boolean contains(String str, ContactData model, String search){
		if(TextUtils.isEmpty(model.pyname)){
			return false;
		}
		model.group = "";
		//搜索条件大于6个字符将不按拼音首字母查询
		if(search.length() < 6){
			//根据首字母进行模糊查询
			Pattern pattern = Pattern.compile("^" + str.toUpperCase().replace("-", "[*+#a-z]*"));
			Matcher matcher = pattern.matcher(model.pyname);
			
			if(matcher.find()){
				String tempStr = matcher.group();
				
				for(int i = 0; i < tempStr.length(); i++){
					if(tempStr.charAt(i) >= 'A' && tempStr.charAt(i) <= 'Z'){
						model.group += tempStr.charAt(i);
					}
				}
				return true;
			}
		}
		//根据全拼查询
		Pattern pattern = Pattern.compile(str.replace("-", ""), Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(model.pyname);
		boolean flag = matcher.find();
		if(flag){
			model.group = matcher.group();
		}
		return flag;
	}
}
