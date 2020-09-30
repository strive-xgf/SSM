package com.xgf.mybatis_spring;


import com.xgf.mybatis_spring.bean.Student;
import com.xgf.mybatis_spring.dao.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

//测试类 测试spring-mybatis整合 进行增删查改
public class TestStudent {

    private static ApplicationContext applicationContext = null;
    private static StudentMapper studentMapper = null;

    //静态代码块 只加载一次
    static {
        //加载配置文件
        applicationContext = new ClassPathXmlApplicationContext("com/xgf/mybatis_spring/config/applicationContext.xml");
        //获取bean的两种方式
        // 1.类名首字母小写
//        studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
        // 2.类.class
        studentMapper = (StudentMapper) applicationContext.getBean(StudentMapper.class);
    }

    //测试getStudentById()方法 通过id查询
    @Test
    public void test01(){
        System.out.println("===查找id为2017401300的student：===");
        Student std1 = studentMapper.getStudentById("2017401300");
        System.out.println(std1);
    }

    //测试添加
    @Test
    public void test02(){
        /*设置了user的id为自动增长所以不需要设置id*/
        Student addStd = new Student(null,"save student","测试student添加",98);
        boolean flag = studentMapper.addStudent(addStd);
        System.out.println("是否添加成功：" + flag);
    }

    //测试查询所有student信息，通过三种遍历list方式输出
    @Test
    public void test03(){
        //3种遍历list输出方法
//      3.1、for循环遍历
        System.out.println("    ===查找所有student对象===");
        List<Student> studentList = studentMapper.getAllStudent();

        for (Student student : studentList) {
            System.out.println(student);
        }

//      3.2、通过流stream方式遍历
        System.out.println("\n   ===通过流stream方式遍历-->输出student对象集合===   ");
        //@FunctionalInterface 函数式接口
        studentList.stream().forEach(new Consumer<Student>(){
            //接收对象 对Student对象的处理
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });

//      3.3、通过函数式接口方式遍历  函数式接口只有一个方法被调用
        //  (函数式接口方法声明)->{方法代码}
        System.out.println("\n   ===函数式接口方法遍历输出  ===   ");
        studentList.stream().forEach(student->{
            System.out.println(student);
        });

    }

    //更新student--通过student对象的stuId来更新
    @Test
    public void test04(){
        System.out.println("   === 假设更新id为2020211236  ===");
        Student updateStudent = studentMapper.getStudentById("2020211236");
        System.out.println("更新前： " + updateStudent);

        boolean flag = studentMapper.updateStudent(new Student(2020211236,"更新studentName","2020软件1班",96));
        if(flag == true){
            System.out.println("更新后：" + studentMapper.getStudentById("2020211236"));
        }else {
            System.out.println("更新失败，学生id不存在");
        }

    }

    //测试删除
    @Test
    public void test05(){
        boolean flag = studentMapper.deleteStudent("2020211240");
        if(flag){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败，指定id的学生不存在");
        }

    }

    //测试将student的属性名和值封装成map键值对的形式输出
    @Test
    public void test06(){

//     返回Map  每一个Map中，key=user对象的属性名，value=user对象的属性值，一个Map封装了一个user对象
        List<Map<String,Object>> listStudentMap = studentMapper.listStudentMap();

        System.out.println(listStudentMap);

//      1、普通for循环方式输出map
        for(Map<String,Object> map: listStudentMap){
//            循环map输出Entry
            for(Map.Entry<String,Object> entry: map.entrySet()){
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.println("key : "+key+"\t value : "+value);
            }
        }

//      2、函数式接口 输出map
        listStudentMap.stream().forEach((Map<String, Object> userMap)->{
//            循环输出map的key和value
            userMap.forEach((String key, Object value)->{
                System.out.println(key+" : "+value);
            });
        });
    }

}
