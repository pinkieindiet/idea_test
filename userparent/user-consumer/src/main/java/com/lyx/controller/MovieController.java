package com.lyx.controller;

import com.lyx.feign.UserFeign;
import com.lyx.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@DefaultProperties(defaultFallback = "defaultFallBackMethod")
public class MovieController {

    /*@Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;*/

    @Autowired
    private UserFeign userFeign;

    @RequestMapping("/get/{id}")
    @HystrixCommand//(fallbackMethod = "myFallBackMethod")
    public User getUserInfo(@PathVariable("id") Integer id) {
        /*List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");
        ServiceInstance serviceInstance = instances.get(0);*/
        //User user = restTemplate.getForObject("http://user-provider/user/get/" + id, User.class);
        User user = userFeign.findById(id);
        return user;
    }

    public User myFallBackMethod(Integer id){
        User user = new User();
        user.setId(id);
        user.setName("服务降级");
        return user;
    }

    public User defaultFallBackMethod(){
        User user = new User();
        user.setName("默认服务降级");
        return user;
    }

}
