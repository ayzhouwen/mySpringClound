package com.phoenix.ribbonConsumer.controller;
import com.phoenix.ribbonConsumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ConsumerController {
    private final Logger logger=Logger.getLogger(getClass().toString());
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
       return  restTemplate.getForEntity("http://auth-service/hello",String.class).getBody();
    }

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public List getAllUser(){
        return  restTemplate.getForEntity("http://auth-service/getAllUser",List.class).getBody();
    }
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(String id){
        return  restTemplate.getForEntity("http://auth-service/getUser?id={1}",User.class,id).getBody();
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Integer addUser(User user){
        return  restTemplate.postForEntity("http://auth-service/addUser",user,Integer.class).getBody();
    }
//    public static void main(String[] args) {
//        HelloController helloController=new HelloController();
//        System.out.println(helloController.getClass().toString());
//    }
}
