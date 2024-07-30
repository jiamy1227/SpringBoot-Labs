package cn.iocoder.springcloud.labx03.feigndemo.consumer.feign;

import cn.iocoder.springcloud.labx03.feigndemo.consumer.dto.UserReqDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: feign client test
 * @author: jiamy
 * @create: 2024/7/30 9:58
 **/
@FeignClient("demo-provider")
public interface MyFeignClient {

    @GetMapping("/echo")
    String echo(@RequestParam("name") String name);

    @GetMapping("/echoUser")
    String echoUser(@SpringQueryMap UserReqDTO userReqDTO);
}
