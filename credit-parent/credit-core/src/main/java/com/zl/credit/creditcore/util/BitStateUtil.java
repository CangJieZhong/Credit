package com.zl.credit.creditcore.util;

public class BitStateUtil {
	/**
	 * 身份证认证的状态码
	 */
	public  static  final  int OP_ID_CARD = 1 << 0;  //0001
	/**
	 * 手机认证的状态码
	 */
	public  static  final  int OP_PHONE_NUMBER = 1 << 1; //0010
	/**
	 * 银行卡认证的状态码
	 */
	public  static  final  int OP_BACK_CARD = 1 << 2;  //0100
	/**
	 * 现居住地址认证的状态码
	 */
	public  static  final  int OP_NEW_ADDRESS = 1 << 3;  //1000
	/**
	 * 判断是否有该认证
	 * @param bitState  用户认证状态
	 * @param stateCode  认证状态码
	 * @return   true  有   false 没有
	 */
	public static boolean  hasState(int bitState,  int  stateCode){
		return (bitState & stateCode) > 0;
	}
	
	/**
	 * 添加状态码
	 * @param bitState    用户认证状态
	 * @param stateCode   需要添加认证状态码
	 * @return   添加之后的状态
	 */
	public  static  int  addState(int bitState,  int  stateCode){
		if(hasState(bitState,stateCode)){
			return bitState;
		}
		return  bitState | stateCode;
	}
	

	/**
	 * 移除状态码
	 * @param bitState    用户认证状态
	 * @param stateCode   需要移除认证状态码
	 * @return   移除之后的状态
	 */
	public  static  int  removeState(int bitState,  int  stateCode){
		if(hasState(bitState,stateCode)){
			return bitState ^ stateCode;
		}
		return bitState;
	}
}	
