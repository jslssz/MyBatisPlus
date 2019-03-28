package com.hx.mp.test;

import com.baomidou.mybatisplus.plugins.Page;
import com.hx.mp.bean.Employee;
import com.hx.mp.mapper.EmployeeMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 2019/03/28.
 */
public class BootStrap {


    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);




    /**
     * 通用删除操作
     */
    @org.junit.Test
    public void testDel(){
        //根据id删除
//        Integer res = mapper.deleteById(13);
        //根据条件删除
//        Map<String,Object> map=new HashMap<>();
//        map.put("last_name","陈");
//        Integer res = mapper.deleteByMap(map);

        List<Integer> list=new ArrayList<>();
        list.add(8);
        list.add(12);
        Integer res = mapper.deleteBatchIds(list);

        System.out.println(res);
    }






    /**
     * 通用查询操作
     */
    @org.junit.Test
    public void testQuery() {
        //通过id查询
        //Employee employee = mapper.selectById(9);

//        注意返回多条数据
//
//        Employee employee = new Employee();
//        employee.setId(9);
//        employee.setGender(1);
//        Employee resEmployee = mapper.selectOne(employee);
//


        //多个id批量查询
//        List<Integer> list=new ArrayList<>();
//        list.add(8);
//        list.add(9);
//        list.add(10);
//        List<Employee> employees = mapper.selectBatchIds(list);


//        Map<String,Object> map=new HashMap<>();
//        //map.put("lastName","陈");  采用数据库列名
//        map.put("last_name","陈");
//        map.put("gender",1);
//        List<Employee> employees = mapper.selectByMap(map);

        //没有limit关键字，是内存分页，效果不是很好
        List<Employee> employees = mapper.selectPage(new Page<Employee>(2, 2), null);

        System.out.println(employees);
    }


    /**
     * 通用更新操作
     */
    @org.junit.Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setId(12);
        employee.setLastName("hhhhhh");
        // mapper.insertAllColumn(employee);  没写的值会为置为空
        mapper.updateById(employee);
    }


    /**
     * 通用初入操作
     *
     * @throws SQLException
     */

    @org.junit.Test
    public void testInsert() throws SQLException {
        Employee employee = new Employee();
        employee.setLastName("陈");
        employee.setEmail("jxrjcmh@163.com");
        employee.setGender(1);
        employee.setAge(22);

        //测试字段的存在与否
        //employee.setSalary(2000.0);

        Integer result = mapper.insert(employee);

        //Integer result2 = mapper.insertAllColumn(employee);  两者插入的区别

        Integer id = employee.getId();

        System.out.println(result);
        System.out.println(id);

    }


    //测试环境是否配置正确

    @org.junit.Test
    public void testEnvironment() throws SQLException {
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Connection con = dataSource.getConnection();
        System.out.println(con);

    }
}
