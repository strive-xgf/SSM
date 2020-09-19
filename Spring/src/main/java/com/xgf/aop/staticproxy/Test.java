package com.xgf.aop.staticproxy;


/*
    proxy代理类
    公共部分，保证业务类代码的纯洁性，
    业务类只写业务代码、处理业务逻辑。
    写代理类  Proxy
*/
public class Test {

    public static void main(String[] args) {
        /* 数学计算类 */
        MathImpl mathImpl = new MathImpl();

        int result = mathImpl.jia(1,2);
        System.out.println(result);


        System.out.println("=====代理Proxy======");
        /*Math mathProxy = new MathProxy();
        int result2 = mathProxy.jia(1,2);
        System.out.println(result2);

        result2 = mathProxy.cheng(2,5);
        System.out.println(result2);*/

//      AOP切面
        //被代理对象--业务类
        MathImpl mathImpl2 = new MathImpl();


      //切面 （切点+通知）
      //通知：切面类中定义的公共方法
      //切点:放入通知的程序执行的地点（业务方法执行之前，之后，业务方法抛出异常等）

      //织入：讲通知放入切点的过程叫做织入（静态代理是直接代码实现织入）
      //织入分类：编译期织入 ：在生成class文件的时候生成代理类
      //         类加载期织入：在类加载时候生成代理类
      //         运行时织入：spring运行时织入(spring使用的方式)
      //                    AspectJ AOP框架运行时织入（两种方式：）
      //                                1、2_jdk动态代理 在运行时生成代理类 （spring默认生成动态代理方式），被代理类实现接口
      //                                2、cglib：生成动态代理  不需要被代理类实现接口
        //                     源文件java-->javac编译.class-->类加载--->虚拟机运行
        Tools tools = new Tools();

//      代理对象
        Math math = new MathProxy(mathImpl,tools);
        int result3 = math.jia(1,6);
        System.out.println(result3);



    }
}
