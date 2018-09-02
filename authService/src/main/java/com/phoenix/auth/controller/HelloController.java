package com.phoenix.auth.controller;


import com.phoenix.auth.entity.User;
import com.phoenix.auth.table.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class HelloController {
    private final Logger logger=Logger.getLogger(getClass().toString());
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance=client.getLocalServiceInstance();
        logger.info("/hello,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
        return "Hello,World";
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(String id){
        ServiceInstance instance=client.getLocalServiceInstance();
        logger.info("getUser_host:"+instance.getHost()+",服务ID:"+instance.getServiceId()+",端口:"+instance.getPort());
        return UserTable.getUserById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public List<User> getAllUser(String id){
        ServiceInstance instance=client.getLocalServiceInstance();
        logger.info("getAllUser_host:"+instance.getHost()+",服务ID:"+instance.getServiceId()+",端口:"+instance.getPort());
        return UserTable.getAllUser();
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Integer addUser(@RequestBody User user){
        ServiceInstance instance=client.getLocalServiceInstance();
        logger.info("addUser_host:"+instance.getHost()+",服务ID:"+instance.getServiceId()+",端口:"+instance.getPort());
        UserTable.addUser(user);
        return 1;
    }




//    public static void main(String[] args) {
//        HelloController helloController=new HelloController();
//        System.out.println(helloController.getClass().toString());
//    }
}
