package com.hxzy.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hxzy.vo.FamilyName;
import com.hxzy.vo.FamilyNameData;

public class ChineseName {

	private static String getRandomFamilyName() {
		FamilyName[] surname = FamilyNameData.Surname;
		int ran = (int)(Math.random() * 100) + 1;
		int weight = ran <= 50 ? 1 : ran <= 90 ? 2 : 3;
		//Object[] array = Stream.of(surname).filter(t -> t.getWeigth() == weight).toArray();
		
		List<FamilyName> list = new ArrayList<>();
		for (int i = 0; i < surname.length; i++) {
			if (surname[i].getWeigth() == weight) {
				list.add(surname[i]);
			}
		}
		
		int index = (int)(Math.random() * list.size());
		return list.get(index).getName();
	}
	
	private static String getChinese() {
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(71)));//区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
		random=new Random();
		lowPos = 161 + Math.abs(random.nextInt(94));//位码，0xA0打头，范围第1~94列
 
		byte[] bArr = new byte[2];
		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "GB2312");	//区位码组合成汉字
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
			return str;
	}
	
	public static String getFullName() {
		String familyName = getRandomFamilyName();
		int count = (int)(Math.random() * 2) + 1;
		
		StringBuilder builder = new StringBuilder(familyName);
		for (int i = 0; i < count; i++) {
			builder.append(getChinese());
		}
		return builder.toString();
	}
}
