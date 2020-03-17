package com.paqi.friendsystem.mapper;

import com.paqi.friendsystem.entity.Discuss;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author PQ
 * @Description 评论实体类
 * @Date 下午6:15 17/3/2020
 * @version 3.2.0
**/
@Mapper
public interface DiscussMapper {
    /**
     * 为文章添加一条评论
     * @author PQ
     * @Description 添加一条评论
     * @param discuss：添加一条评论
     * @return 返回受影响的数据
     * @Date 下午6:16 17/3/2020
     * @version 3.2.0
    **/
    @Insert("INSERT INTO `discuss`(`author_id`, `literature_id`, `quote_discuss_id`, `context`, `create_time`) " +
            "VALUES(#{authorId}, #{literatureId}, #{quoteDiscussId}, #{context}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "discussId", keyColumn = "discuss_Id")
    int postDiscuss(Discuss discuss);
}
