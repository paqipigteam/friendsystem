package com.paqi.friendsystem.mapper;

import com.paqi.friendsystem.entity.Discuss;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author PQ
 * @Description discussMapper测试类
 * @Date 下午6:19 17/3/2020
 * @version 3.2.0
**/
@SpringBootTest
public class DiscussMapperTest {
    @Autowired
    private DiscussMapper discussMapper;

    /**
     * @author PQ
     * @Description 测试post是否可用
     * @Date 下午6:20 17/3/2020
     * @version 3.2.0
    **/
    @Test
    public void testPostDiscussMapper() {
        Discuss discuss = new Discuss();
        discuss.setAuthorId(5);
        discuss.setLiteratureId(10);
        discuss.setContext("这篇文章真好");
        discuss.setCreateTime(new Date());
        int ret = discussMapper.postDiscuss(discuss);
        Assertions.assertNotEquals(0, ret);
    }

    /**
     * @author PQ
     * @Description 删除关于某文章评论的测试
     * @Date 下午8:29 17/3/2020
     * @version 3.3.0
    **/
    @Test
    public void testDeleteDiscuss() {
        int literatureId = 1;
        int ret = discussMapper.deleteDiscussByLiteratureId(literatureId);
        Assertions.assertNotEquals(0, ret);
    }
}
