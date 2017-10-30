package com.papabear.sso.rpc;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

//可以通过客户端是测试链接zk，看是否通畅
//客户端链接栗子：
public class ZookeeperTest {
    public static void main(String[] args) throws Exception {


        ZooKeeper zk = new ZooKeeper("2181", 3000, null);

        System.out.println(zk.getClass());
        if(zk.exists("/test", false) == null)
        {
            zk.create("/test", "znode1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        System.out.println(new String(zk.getData("/test", false, null)));
    }
}
