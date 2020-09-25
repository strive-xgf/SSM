//package com.xgf.mybatis_spring.controller;
//
//
//import com.xgf.mybatis_spring.bean.Student;
//import com.xgf.mybatis_spring.dao.StudentMapper;
//import com.xgf.mybatis_spring.service.StudentService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//import java.util.Map;
//import java.util.function.Consumer;
//
//@Controller
//public class StudentController {
//
//
//
//    @Autowired
//    private StudentMapper studentService;
//
//    //测试
//    @Test
//    public void test01(){
//
//
//
//    }
//
//    public void test(){
//        System.out.println("++++返回单个对象-->通过ID++++");
//        System.out.println("===查找id为2017401300的student：===");
//        Student std1 = studentService.getStudentById("2017401300");
//        System.out.println(std1);
//        System.out.println("===查找id为2017401222的student：===");
//        Student std2 = studentService.getStudentById("2017401222");
//        System.out.println(std2);
//
//        System.out.println("\n===添加student：===");
//        /*设置了user的id为自动增长所以不需要设置id*/
//
//        Student addStd = new Student(null,"save student","测试666",100);
//        boolean flag = studentService.addStudent(addStd);
//        System.out.println("是否添加成功："+flag);
//
//
//
////      3中遍历list输出方法
////      3.1、for循环遍历
//        System.out.println("\n++++返回多个对象++++");
//        System.out.println("    ===查找所有student对象===");
//        List<Student> studentList = studentService.listStudent();
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
//
////      3.2、通过流stream方式遍历
//        System.out.println("\n++++通过流stream方式遍历-->输出student对象++++");
//        //@FunctionalInterface 函数式接口
//        studentList.stream().forEach(new Consumer<Student>(){
//            //            接收对象 对User对象的处理
//            @Override
//            public void accept(Student student) {
//                System.out.println(student);
//            }
//        });
//
////        3.3、通过函数式接口方式遍历  函数式接口只有一个方法被调用
//        //  (函数式接口方法声明)->{方法代码}
//        System.out.println("\n++++函数式接口方法遍历输++++");
//        studentList.stream().forEach(student->{
//            System.out.println(student);
//        });
//
//
//
//
//        System.out.println("\n===更新id=100010的user===");
//        Student updateStudent = studentService.getStudentById("2020211213");
//        System.out.println(updateStudent);
//        updateStudent.setStuName("更新stuid2020211213");
//        updateStudent.setStuClass("更新班级");
//        updateStudent.setStuScore(95);
//        studentService.updateStudent(updateStudent);
//        System.out.println(studentService.getStudentById("2020211213"));
//
//
//        System.out.println("\n===删除通过id=2020211215====");
//        studentService.deleteStudent("2020211215");
//
//
//        System.out.println("\n++++map输出++++");
////     返回Map  每一个Map key=user对象的属性名  value=user对象的属性值，一个Map封装了一个user对象
//        List<Map<String,Object>> listStudentMap = studentService.listStudentMap();
//        /*System.out.println(listStudentMap);*/
//
////      1、普通方式输出map
//
//        for(Map<String,Object> map: listStudentMap){
////            循环map输出Entry
//            for(Map.Entry<String,Object> entry: map.entrySet()){
//                String key = entry.getKey();
//                Object value = entry.getValue();
//                System.out.println("key : "+key+"\t value : "+value);
//            }
//        }
//
////      2、输出map
//        listStudentMap.stream().forEach((Map<String, Object> userMap)->{
////            循环输出map的key和value
//            userMap.forEach((String key, Object value)->{
//                System.out.println(key+" : "+value);
//            });
//        });
//
//
//    }
//}
