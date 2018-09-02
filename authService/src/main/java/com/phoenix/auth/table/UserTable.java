package com.phoenix.auth.table;

import com.phoenix.auth.entity.User;

import java.util.ArrayList;
import java.util.List;

//模拟数据库
public class UserTable {
    private static List<User> table=new ArrayList<User>();
    //初始化表数据
    static {
            for (int i=0;i<10;i++){
                User u=new User();
                u.setId(i+1);
                u.setAge((i+1)*2);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                u.setName(System.currentTimeMillis()+"");
                table.add(u);
            }
            
            
    }
    
     public  static User getUserById(Integer id){
         for (int i=0;i<table.size();i++){
            if (table.get(i).getId().equals(id)){
                return  table.get(i);
            }
         }
         return null;
     }

     public  static  void addUser(User user){
        table.add(user);
     }

     public  static List<User> getAllUser(){
        return  table;
     }
}
