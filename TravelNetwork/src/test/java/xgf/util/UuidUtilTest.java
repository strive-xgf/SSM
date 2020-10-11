package xgf.util;

import com.xgf.util.UuidUtil;
import org.apache.ibatis.logging.Log;
import org.apache.logging.log4j.core.impl.LogEventFactory;
import org.apache.logging.log4j.jcl.Log4jLog;
import org.junit.Test;


//测试UUID工具类
public class UuidUtilTest {

    //测试生成十个随机的UUID字符串
    @Test
    public void getUuid() {
        for (int i = 0; i < 10; i++) {
            String code  = UuidUtil.getUuid();
            System.out.println(code);


        }
    }
}