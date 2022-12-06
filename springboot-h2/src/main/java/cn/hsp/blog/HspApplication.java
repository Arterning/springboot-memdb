package cn.hsp.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 花生皮编程(CSDN、简书、掘金、今日头条、微信公众号、抖音、快手、B站、西瓜视频)
 * @关于作者 https://juejin.cn/post/7002792005688360968
 */
@MapperScan({"cn.hsp.blog"})
@SpringBootApplication
public class HspApplication {

	public static void main(String[] args) {
		SpringApplication.run(HspApplication.class, args);
	}

}
