package com.papabear.sso.server.controller;

import com.papabear.commons.base.BaseController;
import com.papabear.sso.dao.model.TblPermission;
import com.papabear.sso.dao.model.TblSystem;
import com.papabear.sso.dao.model.TblSystemExample;
import com.papabear.sso.dao.model.TblUser;
import com.papabear.sso.rpc.api.TblApiService;
import com.papabear.sso.rpc.api.TblSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 后台controller
 * Created by miaohongshuai on 2017/10/18.
 */
@Controller
@RequestMapping("/manage")
@Api(value = "后台管理", description = "后台管理")
public class ManageController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(ManageController.class);

	@Autowired
	private TblSystemService upmsSystemService;

	@Autowired
	private TblApiService upmsApiService;

	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		// 已注册系统
		TblSystemExample upmsSystemExample = new TblSystemExample();
		upmsSystemExample.createCriteria()
				.andStatusEqualTo((byte) 1);
		List<TblSystem> upmsSystems = upmsSystemService.selectByExample(upmsSystemExample);
		modelMap.put("upmsSystems", upmsSystems);
		// 当前登录用户权限
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		TblUser upmsUser = upmsApiService.selectUserByUsername(username);
		List<TblPermission> upmsPermissions = upmsApiService.selectPermissionByUserId(upmsUser.getId());
		modelMap.put("upmsPermissions", upmsPermissions);
		return "/manage/index.jsp";
	}

}