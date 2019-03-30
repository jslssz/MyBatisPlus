package com.hx.mp2.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hx.mp2.bean.Employee;
import com.hx.mp2.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created  on 2019/03/28.
 */
public class BootStrap {


    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);




    @Test
    public void testSelectPage(){
        Employee employee=new Employee();
        Page<Employee> page = employee.selectPage(new Page<Employee>(1, 2), new EntityWrapper<Employee>().like("last_name", "k"));
        List<Employee> records = page.getRecords();
        System.out.println(records);
    }



    @Test
    public void testDel(){
        Employee employee=new Employee();
        employee.setId(5);
 //       boolean res = employee.deleteById();
        boolean res = employee.delete(new EntityWrapper().eq("last_name", "7k7k"));
        System.out.println(res);
    }



    @Test
    public void testSelect(){
        Employee employee=new Employee();
//        employee.setId(15);
//        Employee res = employee.selectById();

//        List<Employee> res = employee.selectAll();

//        List<Employee> res = employee.selectList(new EntityWrapper().like("last_name", "k"));

        int res = employee.selectCount(new EntityWrapper().like("last_name", "k"));
        System.out.println(res);
    }



    @Test
    public void testUpdate(){
        Employee employee=new Employee();
        employee.setLastName("k99999k");
        employee.setAge(15);
        employee.setEmail("7k7k");
        employee.setGender(0);
        employee.setId(15);
        boolean res = employee.updateById();
        System.out.println(res);
    }


    @Test
    public void testInsert(){
        Employee employee=new Employee();
        employee.setLastName("kk");
        employee.setAge(15);
        employee.setEmail("7k7k");
        employee.setGender(0);
        boolean res = employee.insert();
        System.out.println(res);
    }
}
