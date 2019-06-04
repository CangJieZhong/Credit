package com.zl.credit.creditcore.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
/**
 * 传入姓名、身份证号码和手机号，查询该用户在金融平台的消费、交易、还款等统计数据；
 * 还包括交易时间、还款成功笔数、机构数等统计数据；
 * @author 龙发文
 * @version  创建时间   2019年6月4日  上午10:45:31
 */
public class BorrowOrLendMoney {
	/**
	 * 
	 * @param idCard 身份证号
	 * @param mobile	手机号
	 * @param name	姓名
	 */
	public static String checkBorrowOrLendMoney(String idCard,String mobile,String name) {
	String host = "https://multiplec.shumaidata.com";
    String path = "/getMultipleC";
    String method = "GET";
    String appcode = "2c60f99fecc647b9a6e089599a82abf8";
    Map<String, String> headers = new HashMap<String, String>();
    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
    headers.put("Authorization", "APPCODE " + appcode);
    Map<String, String> querys = new HashMap<String, String>();
    querys.put("idCard", idCard);
    querys.put("mobile", mobile);
    querys.put("name", name);
    
    

	try {

		HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
		System.out.println(response.toString());
		//获取response的body
		//System.out.println(EntityUtils.toString(response.getEntity()));
	} catch (Exception e) {
		e.printStackTrace();
	}
	return appcode;
}

}

