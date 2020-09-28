package com.xgf.dynamic_sql.dao;


import com.xgf.dynamic_sql.bean.Customer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class CustomerMapperTest {

    private static ApplicationContext applicationContext = null;
    private static CustomerMapper customerMapper = null;
    private static Customer customer = new Customer("赵六","开发人员");//初始化customer数据

    //只加载一次  @BeforeClass@BeforeClass只在类中执行一次, 必须声明为public static
    @BeforeClass
    public static void init(){
        //加载配置文件
        applicationContext = new ClassPathXmlApplicationContext("com/xgf/dynamic_sql/config/applicationContext.xml");
        //获取bean的两种方式
        // 1.类名首字母小写
//        customerMapper = (CustomerMapper) applicationContext.getBean("customerMapper");
        // 2.类.class
        customerMapper = (CustomerMapper) applicationContext.getBean(CustomerMapper.class);
    }


    //    不用标签，普通方法测试- 通过name和job查询Customer
    @Test
    public void getCustomerByNameAndJob() {
        System.out.println(customerMapper.getCustomerByNameAndJob(customer));;
    }
    //    通过if标签实现查询
    @Test
    public void getCustomerByNameAndJobForIf() {
        System.out.println(customerMapper.getCustomerByNameAndJobForIf(customer));
    }
    //    通过choose标签实现查询
    @Test
    public void getCustomerByNameAndJobForChoose() {
        customer.setJob(null);
        customer.setUsername(null);
        System.out.println(customerMapper.getCustomerByNameAndJobForChoose(customer));
    }
    //    where标签查询
    @Test
    public void getCustomerByNameAndJobForWhere() {
        System.out.println(customerMapper.getCustomerByNameAndJobForWhere(customer));
    }
    //trim标签查询
    @Test
    public void getCustomerByNameAndJobForTrim() {
        System.out.println(customerMapper.getCustomerByNameAndJobForTrim(customer));
    }
    //set标签更新数据
    @Test
    public void updateForSet() {
        customer.setId(4);//前面初始化数据没有id
        customer.setUsername("赵六数据更新");
        customer.setJob("赵六当老板");
        System.out.println(customerMapper.updateForSet(customer));
    }
    //通过trim+set实现更新数据，通过添加和忽略前后缀实现
    @Test
    public void updateForTrim() {
        customer.setId(4);//前面初始化数据没有id
        customer.setUsername("赵六通过trim更新");
        customer.setJob("赵六董事长了哟");
        System.out.println(customerMapper.updateForTrim(customer));
    }
        //通过foreach标签查询 - 参数是list集合id (相当于select * from tableName where id in {1,2,3} 查询结果为集合)
        @Test
        public void getCustomerByIdsForeach() {
            ArrayList<Integer> idList = new ArrayList<>();
            idList.add(2);
            idList.add(3);
            idList.add(4);
            System.out.println(customerMapper.getCustomerByIdsForeach(idList));

        }
    //bind标签，解决可移植性问题 ，解决不同数据库拼接函数或连接符号的不同(防止sql注入)
    @Test
    public void getCustomerByNameAndJobForBind() {
        customer.setUsername("李四");
        customer.setJob("项目经理");
        System.out.println(customerMapper.getCustomerByNameAndJobForBind(customer));
    }

    //通过foreach和insert，实现foreach循环批量插入
    @Test
    public void insertCustomerList() {
        //customer表的主键id自动增长所以不需要赋值
        Customer customer1 = new Customer("钱一","大数据工程师");
        Customer customer2 = new Customer("孙二","AI工程师");
        Customer customer3 = new Customer("马三","运维工程师");

        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);

        System.out.println(customerMapper.insertCustomerList(customerList));
    }


}