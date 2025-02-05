package com.itheima;

import cn.hutool.core.io.FileUtil;
import com.google.gson.Gson;
import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.File;

@SpringBootTest
class SpringbootWebTests {
    @Autowired
    private Gson gson;
    @Test
    public void testGson() {
        System.out.println(gson.toJson(Result.success("Hello Gson")));
    }

    @Autowired
    private ApplicationContext applicationContext;
    @Test
    public void testScope() {
        for (int i = 0; i < 100; i++){
            System.out.println(applicationContext.getBean("deptController"));

        }

    }
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @Test
    public void testUpload() throws Exception{
        File file = new File("D:\\Backup\\Users\\HONOR\\Desktop\\联想截图_20250128080401.png");
        String url = aliyunOSSOperator.upload(FileUtil.readBytes(file), "联想截图_20250128080401.png");
        System.out.println(url);
    }
}
