package com.zl.credit.creditcore.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;


public class IdCardUtil {
	public static String checkIdCard(String idcard,String realname) {
	    String host = "http://vipidcardcheck.haoservice.com";
	    String path = "/idcard/VerifyIdcardv2";
	    String method = "GET";
	    String appcode = "6dd381e3ccf54e23ab22051408052084";
	    Map<String, String> headers = new HashMap<String, String>();
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("cardNo", idcard);
	    querys.put("realName", realname);
	    try {
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	//获取response的body
	    	return EntityUtils.toString(response.getEntity());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}
}
