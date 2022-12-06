package cn.hsp.blog;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 花生皮编程(CSDN、简书、掘金、今日头条、微信公众号、抖音、快手、B站、西瓜视频)
 * @关于作者 https://juejin.cn/post/7002792005688360968
 */
@Repository
public interface BlogMapper {
    @Select(value = "select * from blog")
    List<Blog> query();
}
