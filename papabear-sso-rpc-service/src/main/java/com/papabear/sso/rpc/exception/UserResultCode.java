/**
 * ibaixiong.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 */
package com.papabear.sso.rpc.exception;


import com.papabear.commons.exception.CommonsResultCode;
import com.papabear.commons.exception.ResultCode;

/**
 * 
 * @author yaoweiguo
 * @email  280435353@qq.com
 * @date   2016年6月22日
 * @since  1.0.0
 */
public class UserResultCode extends CommonsResultCode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3295436245122326310L;

	public static final ResultCode DATA_BLANK=new UserResultCode(50001, "账号或密码不能为空！");
	
	public static final ResultCode MOBILE_FORMAT_ERROR= new UserResultCode(50002, "手机格式错误，请输入正确的手机格式");

	public static final ResultCode PASSWORD_LENGTH_ERROR= new UserResultCode(50003, "密码长度错误，请正确输入6-16位之间");
			
	public static final ResultCode ACCOUNT_EXIST_ERROR=new UserResultCode(50004, "该账号已存在，请重新输入");
	
	public static final ResultCode ACCOUNT_NOT_EXIST_ERROR=new UserResultCode(50004, "该账号不存在！");
			
	public UserResultCode(int code, String resultDesc) {
		super(code, resultDesc);
	}
}
