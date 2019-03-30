package com.hx.mp1.bean;

import com.baomidou.mybatisplus.annotations.TableField;

/**
 * Created  on 2019/03/28.
 */

//@TableName("tbl_employee ")  xml 配置表前缀，结合实体类型

public class Employee {

    //@TableId(value = "id",type = IdType.AUTO)  xml文件配置全局的

    private Integer id;

    //@TableField("last_name")  如果未开启驼峰，则启用该注解

    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    //@TableField(exist = false)  作用：如果数据库表里面没有该字段，将不会插入

    @TableField(exist = false)
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public Employee() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ']';
    }
}
