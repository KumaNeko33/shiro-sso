package com.papabear.sso.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
    * @Description: 服务启动类
    * @author: miaohongshuai
    * @Date: 2017/10/19 0019
*/
public class PapabearSsoRpcServiceApplication {

	private static Logger _log = LoggerFactory.getLogger(PapabearSsoRpcServiceApplication.class);

	public static void main(String[] args) {
		_log.info(">>>>> papabear-sso-rpc-service 正在启动 <<<<<");
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		_log.info(">>>>> papabear-sso-rpc-service 启动完成 <<<<<");
	}

}
