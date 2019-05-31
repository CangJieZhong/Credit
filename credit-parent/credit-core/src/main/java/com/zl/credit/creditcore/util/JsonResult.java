package com.zl.credit.creditcore.util;

import lombok.Getter;
import lombok.Setter;

/**
 * 发送给前台的json对象
 * @author suke
 *
 */
@Getter
@Setter
public class JsonResult {
	/**success 是否成功  true 表示成功, false 表示失败 */
	private boolean success = true;
	private String msg;
	
	public JsonResult(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	public JsonResult() {
	}
	

	public JsonResult(String msg) {
		this.msg = msg;
	}
	
	
	
	
	
	
}
