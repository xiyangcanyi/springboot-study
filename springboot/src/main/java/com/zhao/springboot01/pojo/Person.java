package com.zhao.springboot01.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Component
@ConfigurationProperties(prefix = "person")
@Validated//数据校验
public class Person{

    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

    public Person() {
    }

    public Person(String name, Integer age, Boolean happy, Date birth, Map<String, Object> maps, List<Object> lists, Dog dog) {
        this.name = name;
        this.age = age;
        this.happy = happy;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getHappy() {
        return happy;
    }

    public Date getBirth() {
        return birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", happy=" + happy +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
