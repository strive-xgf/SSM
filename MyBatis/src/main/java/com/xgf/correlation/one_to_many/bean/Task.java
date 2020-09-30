package com.xgf.correlation.one_to_many.bean;

//一对多 task任务表与users表关联，一个user有多个task
public class Task {

    private Integer id;
    private String taskName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "编号=" + id +
                ", 任务名='" + taskName + '\'' +
                '}';
    }
}
