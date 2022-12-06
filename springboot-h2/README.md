# 目标
在SpringBoot中集成内存数据库H2.
# 为什么
像H2、hsqldb、derby、sqlite这样的内存数据库，小巧可爱，做小型服务端演示程序，非常好用。最大特点就是不需要你另外安装一个数据库。
# 操作步骤
1. 修改pom.xml文件
```
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>
```
2. 修改项目配置文件application.yml
```
spring:
  datasource:
    username: hsp
    password: 123456
    url: jdbc:h2:file:./blogDB
    driver-class-name: org.h2.Driver
    schema: classpath:schema.sql
    data: classpath:data.sql
    initialization-mode: always
    continue-on-error: true

  h2:
    console:
      enabled: true
      path: /h2
```
3. 添加初始化数据文件
- 建表脚本：schema.sql
```
CREATE TABLE `blog` (
  `id` int AUTO_INCREMENT NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
```
- 导入数据脚本：data.sql
```
insert into blog(id,title) values(1,'花生皮编程博客');
```
4. 启动类：HspApplication
```
@MapperScan({"cn.hsp.blog"})
@SpringBootApplication
public class HspApplication {

	public static void main(String[] args) {
		SpringApplication.run(HspApplication.class, args);
	}

}
```
5. Controller类：BlogController
```
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;

    @GetMapping(value="/query")
    public List<Blog> query()
    {
        return blogMapper.query();
    }
}
```
6. Mapper类：BlogMapper
```
@Repository
public interface BlogMapper {
    @Select(value = "select * from blog")
    List<Blog> query();
}
```
7. 数据bean：Blog
```
@Data
public class Blog {
    private int id;
    private String title;
}
```
# 工程截图
![image.png](https://img-blog.csdnimg.cn/img_convert/27a0d82b543e73d5bffa66d622ea1c60.png)
# 运行
运行HspApplication即可
# 效果
![image.png](https://img-blog.csdnimg.cn/img_convert/8819550ba2460e531564abf5ba045525.png)

# 完整源代码
https://gitee.com/lblbc/springboot_memdb.git

# 关于我
厦门大学计算机专业 | 前华为工程师
专注《零基础学编程系列》  http://lblbc.cn/blog
包含：Java | 安卓 | 前端 | Flutter | iOS | 小程序 | 鸿蒙
公众号：蓝不蓝编程

# 集成内存数据库系列
 [SpringBoot集成内存数据库H2](https://cxyxy.blog.csdn.net/article/details/120148641)  
 [SpringBoot集成内存数据库Derby](https://cxyxy.blog.csdn.net/article/details/120148643)  
 [SpringBoot集成内存数据库hsqldb](https://cxyxy.blog.csdn.net/article/details/120148646)  
 [SpringBoot集成内存数据库Sqlite](https://cxyxy.blog.csdn.net/article/details/120148647)