package com.papabear.sso.rpc.service;

import com.papabear.commons.sign.MD5;
import com.papabear.commons.util.MD5Util;
import com.papabear.sso.dao.mapper.TblUserMapper;
import com.papabear.sso.dao.model.TblPermission;
import com.papabear.sso.dao.model.TblPermissionExample;
import com.papabear.sso.dao.model.TblUser;
import com.papabear.sso.rpc.api.TblPermissionService;
import com.papabear.sso.rpc.api.TblSystemService;
import com.papabear.sso.rpc.api.TblUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.Date;
import java.util.List;

/**
 * 单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:applicationContext.xml",
        "classpath:META-INF/spring/applicationContext-jdbc.xml",
        "classpath:META-INF/spring/applicationContext-listener.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UpmsServiceTest {

    @Autowired
    private TblSystemService upmsSystemService;

    @Autowired
    private TblUserMapper upmsUserMapper;

    @Autowired
    private TblUserService upmsUserService;

    @Autowired
    private TblPermissionService upmsPermissionService;

    @Test
    public void index() {
        //通过测试来实现用户数据 移动
        TblUser upmsUser = new TblUser();
        upmsUser.setUserName("mhs");
        upmsUser.setUserPwd("xxx");
        upmsUser.setCreateDateTime(new Date());
        upmsUser.setEmail("");
        upmsUser.setPhone("");
        upmsUser.setSalt("");
        upmsUser.setNickName("帅帅");
        upmsUser.setStatus((byte) 1);
        upmsUser.setPoints(0);
        upmsUser.setExpNum(0);
        upmsUser.setAvailable((byte) 1);
//        upmsUser.setAvatar("");
//        upmsUser.setSex((byte) 1);
        upmsUserService.insertSelective(upmsUser);
        System.out.println(upmsUser.getId());
    }

    @Test
    public void selectForPage() {
        // 根据条件，按页码+每页条数分页
        TblPermissionExample upmsPermissionExample = new TblPermissionExample();
        upmsPermissionExample.createCriteria()
                .andSystemIdEqualTo(1);
        List<TblPermission> upmsPermissions = upmsPermissionService.selectByExampleForStartPage(upmsPermissionExample, 2, 20);
        System.out.println(upmsPermissions.size());
        // 根据条件，按offset+limit分页
        upmsPermissionExample = new TblPermissionExample();
        upmsPermissionExample.createCriteria()
                .andSystemIdEqualTo(2);
        upmsPermissions = upmsPermissionService.selectByExampleForOffsetPage(upmsPermissionExample, 3, 5);
        System.out.println(upmsPermissions.size());
    }


    @Test
    public void testMD5() {
        TblUser user = upmsUserMapper.getUserByUserName("18656330413");
        String password ="123456";
        String salt = user.getSalt();
        String pwdMD5 = MD5Util.encode(password + salt);
        System.out.println("pwdMD5: " + pwdMD5);
        String pwdMD52 = MD5Util.encode(MD5Util.encode(password + salt));
        System.out.println("pwdMD52: " + pwdMD52);
        System.out.println("------------------------");

        String pwdOldMD5 = MD5.MD5Encode(MD5.MD5Encode(password + salt));//这个生成规则是tbl_user的
        System.out.println("pwdOldMD5: " + pwdOldMD5);
        System.out.println("------------------------");

        String pwdSysMD5 = MD5Util.encode(password);
        System.out.println("pwdSysMD5 " + pwdSysMD5);//这个生存规则是tbl_sys_admin的
    }
}
