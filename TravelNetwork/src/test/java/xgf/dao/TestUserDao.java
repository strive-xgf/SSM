package xgf.dao;

import com.xgf.bean.User;
import com.xgf.dao.UserDao;
import com.xgf.util.GetDaoUtils;
import org.junit.Test;

//对user的dao进程测试
public class TestUserDao {
    //通过工具类获取userdao的bean
    private static UserDao userDao = GetDaoUtils.getMapper(UserDao.class);

    //测试findByUserName方法，查询usermane是否已存在
    @Test
    public void test01(){
        User user = userDao.findByUserName("strive_gf");
        if(user == null){
            System.out.println("username未注册，可以注册");
        }else{
            System.out.println("username已注册，请更换");
        }
    }
}
