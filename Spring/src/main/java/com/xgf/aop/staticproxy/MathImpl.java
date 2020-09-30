package com.xgf.aop.staticproxy;

public class MathImpl implements Math{

    public int jia(int a,int b){
//     抽出成Tools工具类
//        System.out.println("权限检查。。。");
//        System.out.println("日志记录。。。");
        return a+b;
    }
    public int jian(int a,int b){
//     抽出成Tools工具类
//        System.out.println("权限检查。。。");
//        System.out.println("日志记录。。。");
        return a-b;
    }


}
