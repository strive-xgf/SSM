package com.xgf.mybatis_spring.dao;



import com.xgf.mybatis_spring.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentMapper {
//    只要建立接口，具体实现由spring执行（动态代理）

    //通过id获取学生
//    com.xgf.mybatis_spring.dao.StudentMapper.getStudentById完全限定名来找sql语句
    public Student getStudentById(String stuId);

    //增加学生
    public boolean addStudent(Student user);

    //通过查询学生
    public List<Student> getAllStudent();

    //更新学生信息  - 通过student对象的stuId来更新
    boolean updateStudent(Student student);

    //通过id删除学生
    boolean deleteStudent(String stuId);

    //将student的属性名和值封装成map对象  Map<stuid,123>
    List<Map<String, Object>> listStudentMap();
}
