package xgf.service;


import com.xgf.bean.Category;
import com.xgf.service.CategoryService;
import org.junit.Test;


import java.util.List;

//测试获取所有分类信息Category
public class TestCategoryService {
    @Test
    public void test01(){
        //创建业务对象
        CategoryService categoryService = new CategoryService();
        //所有的分类
        List<Category> categoryList=categoryService.findAll();
        //显示
        System.out.println(categoryList);
    }
}
