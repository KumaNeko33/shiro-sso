/**
 * ibaixiong.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 */
package com.papabear.sso.rpc.api;

/**
 * 用户分销相关
 */
public interface TblUserDistributingService {

	/**
	 * 支付宝账号实名
	 * @author yaoweiguo
	 * @date 2016年6月21日
	 * @param aliPayNumber	支付宝账号
	 * @param realName		真实姓名
	 * @param userId		用户ID
	 * @return
	 */
	int accountRealNameByAli(String aliPayNumber, String realName, Long userId);
	/**
	 * 银行账号实名
	 * @author yaoweiguo
	 * @date 2016年6月21日
	 * @param bankNumber	银行账号
	 * @param bankName		银行名称
	 * @param realName		真实姓名
	 * @param cardNumber	身份证号
	 * @param userId		用户ID
	 * @return
	 */
	int accountRealNameByBank(String bankNumber, String bankName, String realName, String cardNumber, Long userId);
}
