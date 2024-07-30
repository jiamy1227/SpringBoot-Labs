package cn.iocoder.springcloud.labx03.feigndemo.consumer.controller;

import cn.iocoder.springcloud.labx03.feigndemo.consumer.dto.UserReqDTO;
import cn.iocoder.springcloud.labx03.feigndemo.consumer.feign.MyFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/7/30 10:00
 **/
@RestController
public class MyFeignClientController {

    @Resource
    MyFeignClient myFeignClient;

    @RequestMapping("hello")
    public String hello(@RequestParam("name") String name){
        return myFeignClient.echo(name);
    }

    @RequestMapping("helloUser")
    public String helloUser(UserReqDTO userReqDTO){
        return myFeignClient.echoUser(userReqDTO);
    }
}
