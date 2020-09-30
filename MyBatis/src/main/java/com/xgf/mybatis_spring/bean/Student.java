package com.xgf.mybatis_spring.bean;

//创建学生类
public class Student {
    private Integer stuId;       //学生id
    private String stuName;     //学生名
    private String stuClass;    //学生班级
    private float  stuScore;    //学生成绩

    public Student(Integer stuId, String stuName, String stuClass, float stuScore) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuClass = stuClass;
        this.stuScore = stuScore;
    }

    public Student() {
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public float getStuScore() {
        return stuScore;
    }

    public void setStuScore(float stuScore) {
        this.stuScore = stuScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "学号 ='" + stuId + '\'' +
                ", 姓名 ='" + stuName + '\'' +
                ", 班级 ='" + stuClass + '\'' +
                ", 分数 =" + stuScore +
                '}';
    }
}
