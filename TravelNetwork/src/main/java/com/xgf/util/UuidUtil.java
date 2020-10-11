package com.xgf.util;

import java.util.UUID;

/**
 * UUID工具类，能够产生UUID随机字符串工具类，全世界唯一的，不重复的字符串
 */
public final class UuidUtil {
	private UuidUtil(){}
	//获取一个UUID随机字符串
	public static String getUuid(){
		return UUID.randomUUID().toString().replace("-","");
	}
}
