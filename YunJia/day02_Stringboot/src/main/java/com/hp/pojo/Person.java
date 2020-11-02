package com.hp.pojo;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//@Component   能实例化当前类，并将对象存到spring容器中  使用@A
import java.util.Date;
@Component//创建对象：@Controller  @Service @Repository
@ConfigurationProperties(prefix="person")

public class Person {
    private int id;
    private String name;
    private int age;
    private Date birth;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
