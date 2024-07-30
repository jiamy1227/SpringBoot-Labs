package cn.iocoder.springcloudalibaba.labx5.nacosdemo.controller;

import cn.iocoder.springcloudalibaba.labx5.nacosdemo.config.OrderProperties;
import cn.iocoder.springcloudalibaba.labx5.nacosdemo.config.SalesProperties;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/demo")
@RefreshScope
public class DemoController {

    @Autowired
    private OrderProperties orderProperties;

    @Resource
    private SalesProperties salesProperties;

    /**
     * 测试 @ConfigurationProperties 注解的配置属性类
     */
    @GetMapping("/test01")
    public OrderProperties test01() {
        return orderProperties;
    }

    @Value(value = "${order.pay-timeout-seconds}")
    private Integer payTimeoutSeconds;
    @Value(value = "${order.create-frequency-seconds}")
    private Integer createFrequencySeconds;

    @Value(value = "${sales.price}")  //@Value注解单独使用，配置刷新不生效，需要配合refreshScope注解
    private String salesName;

    /**
     * 测试 @Value 注解的属性
     */
    @GetMapping("/test02")
    public Map<String, Object> test02() {
        return new JSONObject().fluentPut("payTimeoutSeconds", payTimeoutSeconds)
                .fluentPut("createFrequencySeconds", createFrequencySeconds);
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/logger")
    public void logger() {
        logger.debug("[logger][测试一下]");
    }

    @GetMapping("/getSales")
    public SalesProperties getSalesProperties(){
        return salesProperties;
    }

    @GetMapping("/getSalesName")
    public String getSalesName(){
        return salesName;
    }


}
