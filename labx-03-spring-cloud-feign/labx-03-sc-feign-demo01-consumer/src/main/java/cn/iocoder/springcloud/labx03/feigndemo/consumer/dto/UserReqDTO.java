package cn.iocoder.springcloud.labx03.feigndemo.consumer.dto;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/7/30 10:35
 **/
public class UserReqDTO {

    private String name;

    private Long id;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
