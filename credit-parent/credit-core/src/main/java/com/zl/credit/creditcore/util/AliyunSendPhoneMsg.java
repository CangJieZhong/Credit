package com.zl.credit.creditcore.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
public class AliyunSendPhoneMsg {
	
	    public static String sendPhoneMsg(String phoneNumber,String checkCode) {
	        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAImlqj2UYHi2nN", "R2SUlfQ0BwVxIUOf3zwwKFFEdhwzkr");
	        IAcsClient client = new DefaultAcsClient(profile);
	        CommonRequest request = new CommonRequest();
	        //request.setProtocol(ProtocolType.HTTPS);
	        request.setMethod(MethodType.POST);
	        request.setDomain("dysmsapi.aliyuncs.com");
	        request.setVersion("2017-05-25");
	        request.setAction("SendSms");
	        request.putQueryParameter("PhoneNumbers", phoneNumber);
	        request.putQueryParameter("SignName", "蓝鲸智云");
	        request.putQueryParameter("TemplateCode", "SMS_167050543");
	        request.putQueryParameter("TemplateParam", "{\"code\":\""+checkCode+"\"}");
	        try {
	            CommonResponse response = client.getCommonResponse(request);
	            return response.getData();
	        } catch (ServerException e) {
	            e.printStackTrace();
	        } catch (ClientException e) {
	            e.printStackTrace();
	        }
			return null;
	    }
}