package com.zl.credit.creditcore.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;


public class AliyunQueryBackCard {
	/**
	 * 
	 * @param name 持卡人姓名
	 * @param backcard  银行卡帐号
	 * @param idcard 开卡使用的证件号码
	 * @return
	 */
	public static String queryBackCard(String name,String backcard,String idcard) {
	    String host = "https://ali-bankcard3.showapi.com";
	    String path = "/bank3";
	    String method = "GET";
	    String appcode = "6dd381e3ccf54e23ab22051408052084";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    //持卡人姓名
	    querys.put("acct_name", name);
	    //银行卡帐号
	    querys.put("acct_pan", backcard);
	    //开卡使用的证件号码
	    querys.put("cert_id", idcard);
	    //开卡使用的证件类型；01:身份证，目前只支持身份证
	    querys.put("cert_type", "01");
	    //是否需要返回归属地信息
	    querys.put("needBelongArea", "true");
	    try {
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	return EntityUtils.toString(response.getEntity());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}
}
