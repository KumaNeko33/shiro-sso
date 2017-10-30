package com.papabear.sso.server;

import com.papabear.sso.dao.model.TblSystemExample;
import com.papabear.sso.dao.model.TblUser;
import com.papabear.sso.rpc.api.TblSystemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:applicationContext.xml",
        "classpath:applicationContext-dubbo-consumer.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UpmsServiceTest {

    @Autowired
    private TblSystemService upmsSystemService;

    @Test
    public void index() {
        int count = upmsSystemService.countByExample(new TblSystemExample());
        System.out.println(count);
    }

}
