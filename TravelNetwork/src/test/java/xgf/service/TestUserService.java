package xgf.service;

import com.xgf.bean.User;
import com.xgf.service.UserService;
import org.junit.Test;

import java.util.Date;


//测试user业务层
public class TestUserService {

/*
    private static ApplicationContext applicationContext = null;
    private static UserDao userDao = null;

    //静态代码块 只加载一次
    static {
        //加载配置文件
        applicationContext = new ClassPathXmlApplicationContext("com/xgf/config/applicationContext.xml");
        //获取bean的两种方式
        // 1.类名首字母小写
//        userDao = (UserDao) applicationContext.getBean("userDao");
        // 2.类.class
        userDao = (UserDao) applicationContext.getBean(UserDao.class);
    }
*/

    //测试登录
    @Test
    public void test01(){
        UserService userService = new UserService();

        //创建user数据
        User user = new User();
        user.setUsername("861221293");
        user.setPassword("ABC123456");
        //user.setStatus("Y");//用户激活

        //测试登录
        int code = userService.login(user);
        if(code == 1){
            System.out.println("登录成功");
        }else if(code == -1){
            System.out.println("用户名或密码错误");
        }else if(code == -2){
            System.out.println("用户未激活");
        }
    }


    //测试注册用户 - 保存用户信息  需要对username是否已经被注册过进行判断
    @Test
    public void test02() {

        UserService userService = new UserService();

        User user= new User(null,"register123","ABC123456",new Date(),"注册昵称","男","17878782828","9689621@qq.com","N","codeNumber");
//        user.setUsername("strive_gf");
//        user.setPassword("ABC123456");
        int code = userService.register(user);

        if(code == 1){
            System.out.println("注册成功");
        }else if(code == 0){
            System.out.println(user.getUsername()+"已经被注册过了，请更换用户名");
        }
    }

}
