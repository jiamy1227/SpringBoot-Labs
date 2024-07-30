package cn.iocoder.springcloud.labx03.feigndemo.provider.controller;

import cn.iocoder.springcloud.labx03.feigndemo.provider.dto.UserReqDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    private Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/echo")
    public String echo(String name) throws InterruptedException {
        // 记录被调用的日志
        logger.info("[echo][被调用啦 name({})]", name);

        return serverPort + "-provider:" + name;
    }

    @GetMapping("echoUser")
    public String echoUser(UserReqDTO userReqDTO) {
        return serverPort + "-provider:" + userReqDTO.toString();
    }

}
