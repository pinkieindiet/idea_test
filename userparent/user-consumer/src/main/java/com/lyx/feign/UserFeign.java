package com.lyx.feign;

import com.lyx.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-provider")
@RequestMapping("/user")
@Component
public interface UserFeign {

    @RequestMapping("/get/{id}")
    User findById(@PathVariable(name = "id") Integer id) ;

}
