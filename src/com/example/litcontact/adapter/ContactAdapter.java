package com.example.litcontact.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.litcontact.domain.ContactData;
import com.example.litcontact.util.OutputUtil;
import com.example.litcontactnew.R;

@SuppressLint("NewApi")
public class ContactAdapter extends BaseAdapter {

	private Context mContext;
	private List<ContactData> contactList;
	private boolean isShowAll;

	public ContactAdapter(Context context) {
		this.mContext = context;
		this.contactList = new ArrayList<ContactData>();
	}

	public void refresh(List<ContactData> searchContactList, boolean isShowAll) {
		this.isShowAll = isShowAll;
		this.contactList.clear();
		this.contactList.addAll(searchContactList);
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return contactList.size();
	}

	@Override
	public Object getItem(int position) {
		return contactList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		final ViewHolder viewHolder;

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.contact_list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.nameTv = (TextView) convertView
					.findViewById(R.id.contact_name_tv);
			viewHolder.phoneTv = (TextView) convertView
					.findViewById(R.id.contact_phone_num_tv);
			// viewHolder.matchTv = (TextView) convertView
			// .findViewById(R.id.contact_group_tv);

			viewHolder.quanpinTv = (TextView) convertView
					.findViewById(R.id.contact_quanpin_tv);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		setItemData(viewHolder, position);

		return convertView;
	}

	private void setItemData(ViewHolder viewHolder, int position) {

		if (contactList == null && contactList.size() < 1) {
			return;
		}

		ContactData contactData = contactList.get(position);
		if (contactData == null) {
			return;
		}

		if (isShowAll) {
			contactData.group = "";
		}

		String matchText = contactData.group;
		boolean isMatch = matchText.isEmpty();

		String phoneNumText = contactData.contactPhoneNum;

		if (!isShowAll && !isMatch) {
			List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
			Map<String, Object> target = null;
			target = new HashMap<String, Object>();
			target.put("match", matchText);
			// 指定要改变颜色的内容
			target.put("color", Color.RED); // 指定颜色
			data.add(target);
			viewHolder.phoneTv.setText(highlight(phoneNumText, data));
		} else {
			viewHolder.phoneTv.setText(phoneNumText);
		}

		viewHolder.nameTv.setText(contactData.contactName);

		String pinName = contactData.pyname;

		if (!isShowAll && !isMatch) {

			OutputUtil.printText("拼音匹配.....mathText=" + matchText);

			boolean isUpper = isFirstABC(matchText);

			if (isUpper && matchText.length() > 1) {
				setFirstABCText(viewHolder, pinName, matchText);
			} else {

				List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
				Map<String, Object> target = null;
				target = new HashMap<String, Object>();
				target.put("match", matchText);
				// 指定要改变颜色的内容
				target.put("color", Color.RED); // 指定颜色
				data.add(target);
				viewHolder.quanpinTv.setText(highlight(pinName, data));
			}
		} else {
			viewHolder.quanpinTv.setText(pinName);
		}

		// viewHolder.matchTv.setText(matchText);

	}

	private void setFirstABCText(ViewHolder viewHolder, String pinName, String matchText) {
		
		int[] indexs = new int[matchText.length()];
		
		for(int i=0; i < matchText.length(); i++) {
			char firstChar = matchText.charAt(i);
			
//			for(int j=0; j<pinName.length(); j++) {
//				if(firstChar == pinName.charAt(j)) {
//					indexs[i] = j;
//				}
//			}
			
			if(pinName.lastIndexOf(firstChar) == pinName.indexOf(firstChar))
				indexs[i] = pinName.indexOf(firstChar);
			else {
				indexs[i] = pinName.indexOf(firstChar);
				indexs[indexs.length-1] = pinName.lastIndexOf(firstChar);
			}
		}
		
		if(indexs[0] == -1) {
			OutputUtil.printText("index[0]="+indexs[0]);
			viewHolder.quanpinTv.setText(pinName);
			return;
		}
		
		SpannableStringBuilder style=new SpannableStringBuilder(pinName);  
		
		for(int i=0; i<indexs.length; i++) {
			OutputUtil.printText("脚标:"+indexs[i]+"....pinName="+pinName);
			style.setSpan(new ForegroundColorSpan(Color.RED),indexs[i],indexs[i]+1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);  
		}
		
		viewHolder.quanpinTv.setText(style);
	}

	class ViewHolder {
		TextView nameTv;
		TextView phoneTv;
		// TextView matchTv;

		TextView quanpinTv;
	}

	/*
	 * textview局部变色
	 */
	private SpannableStringBuilder highlight(String wholeContent,
			List<Map<String, Object>> data) {
		SpannableStringBuilder spannable = new SpannableStringBuilder(
				wholeContent);
		for (Map<String, Object> targetdata : data) {
			Pattern p = Pattern.compile(targetdata.get("match").toString());
			Matcher m = p.matcher(wholeContent);
			while (m.find()) {
				spannable.setSpan(
						new ForegroundColorSpan(Integer.valueOf(targetdata.get(
								"color").toString())), m.start(), m.end(),
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}

		return spannable;
	}

	private boolean isFirstABC(String matchText) {

		for (int i = 0; i < matchText.length(); i++) {
			char c = matchText.charAt(i);
			if (Character.isLowerCase(c)) {
				return false;
			}
		}
		return true;

	}

}
