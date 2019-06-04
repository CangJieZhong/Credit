package com.zl.credit.creditcore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zl.credit.creditcore.util.AliyunSendPhoneMsg;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditCoreApplicationTests {

	@Test
	public void contextLoads() {
		String str = "{" + 
				"    \"error_code\": 0," + 
				"    \"reason\": \"Success\"," + 
				"    \"result\": {" + 
				"        \"realname\": \"张三\"," + 
				"        /*真实姓名*/" + 
				"        \"idcard\": \"330329199001020022\"," + 
				"        /*身份证号码*/" + 
				"        \"isok\": false" + 
				"        /*true：匹配 false：不匹配*/\n" + 
				"        ," + 
				"        \"IdCardInfor\": {" + 
				"            \"area\": \"山西省太原市清徐县\"," + 
				"            \"sex\": \"男\"," + 
				"            \"birthday\": \"1985-4-10\"" + 
				"        }" + 
				"    }" + 
				"}";
		String[] arr = str.split("\"IdCardInfor\":");
		//{"area": "山西省太原市清徐县","sex": "男", "birthday":"1985-4-10"}}}
		String[] arr1 = arr[1].split(",");
		String message = "";
		for (String string : arr1) {
			String[] arr2 =  string.split("\"");
			message +=arr2[3]+",";
		}
		System.out.println(message);
		String[] mess = message.split(",");
		System.out.println(mess[0]+"   "+mess[1]+"   "+mess[2]);
 	}

}
