package com.zhao.springboot01.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog{
    @Value("旺财")
    private String name;
    @Value("3")
    private Integer age;

    //有参无参构造、get、set方法、toString()方法
    public Dog(){

    }
    public Dog(String name) {

        this.name = name;
    }

    public Dog(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
