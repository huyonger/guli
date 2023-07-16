## note

### docker

介绍：虚拟化容器技术。Docker 基于镜像，可以秒级启动各种容器。每一种容器都是一个**完整的运行环境**，容器之间互相隔离。

安装：https://docs.docker.com/engine/install/centos/

docker hub: https://hub.docker.com/

aliyun docker 加速：https://cr.console.aliyun.com/cn-hangzhou/instances/mirrors

#### docker 常用命令

-   docker pull mysql:5.7
-   docker images 安装查看镜像
-   docker ps 查看运行的容器
-   docker exec -it mysql(name 或 id 前缀) /bin/bash
-   docker restart mysql 重启
-   docker update mysql --restart=always 开机启动镜像

#### docker 安装 Mysql

-   下载 5.7 版本 Mysql：`docker pull mysql:5.7`
-   在 hub 选择版本：https://hub.docker.com/_/mysql/tags
-   运行 mysql

```shell
docker run -p 3306:3306 --name mysql \
-v /mydata/mysql/log:/var/log/mysql \
-v /mydata/mysql/data:/var/lib/mysql \
-v /mydata/mysql/conf:/etc/mysql \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql:5.7
```

参数说明
-p 3306:3306：将容器的 3306 端口映射到主机的 3306 端口
-v /mydata/mysql/conf:/etc/mysql：将配置文件夹挂载到主机
-v /mydata/mysql/log:/var/log/mysql：将日志文件夹挂载到主机
-v /mydata/mysql/data:/var/lib/mysql/：将配置文件夹挂载到主机
-e MYSQL_ROOT_PASSWORD=root：初始化 root 用户的密码
-d 指定镜像

#### docker 安装 redis

-   安装 redis ：`docker pull redis`
-   启动 redis

```shell
mkdir -p /mydata/redis/conf
touch /mydata/redis/conf/redis.conf

docker run -p 6379:6379 --name redis -v /mydata/redis/data:/data \
-v /mydata/redis/conf/redis.conf:/etc/redis/redis.conf \
-d redis redis-server /etc/redis/redis.conf
```

-   启动 redis-cli :`docker exec -it redis redis-cli`
-   redis 配置文件：`https://redis.io/docs/management/config/`

### IDEA 插件

-   lombok: 通过注解用来简化 Model 类编写，需要 IDEA 插件和 Maven 依赖一起使用。(高版本 IDEA 自动安装)
-   MyBatisX：MyBatis 开发操作简化的插件。包括 dao 层和 xml 文件跳转，代码自动补全等。https://blog.csdn.net/weixin_45433031/article/details/123074650

### Maven 父工程

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.atguigu.gulimall</groupId>
	<artifactId>gulimall</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>gulimall</name>
	<description>gulimall parent module</description>
	<packaging>pom</packaging>

	<modules>
		<module>gulimall-coupon</module>
		<module>gulimall-member</module>
		<module>gulimall-order</module>
		<module>gulimall-product</module>
		<module>gulimall-ware</module>
	</modules>

</project>

```

### 后端基本概念

这些术语通常在 Java 后端开发中使用，并且用于表示不同的数据对象。以下是它们的定义和简短的代码示例：

1. DO（Data Object）：DO 是指与数据库表结构一一对应的对象，通常用于与数据库进行交互。它包含了表中的所有字段，通常不包含业务逻辑。

```java
public class UserDO {
    private Long id;
    private String username;
    private String password;
    // getters and setters
}
```

2. DTO（Data Transfer Object）：DTO 用于在不同层之间传输数据，通常用于将 DO 对象转换为可传输的格式。DTO 对象通常不包含业务逻辑。

```java
public class UserDTO {
    private Long id;
    private String username;
    // getters and setters
}
```

3. BO（Business Object）：BO 包含了业务逻辑，通常用于在 Service 层进行业务处理。

```java
public class UserBO {
    private Long id;
    private String username;
    private String password;

    public void encryptPassword() {
        this.password = encrypt(this.password);
    }
    // getters and setters
}
```

4. AO（Application Object）：AO 用于在应用程序层面进行业务处理，比如在 Controller 中进行数据校验和转换。

```java
public class UserAO {
    private String username;
    private String password;
    // getters and setters
}
```

5. VO（View Object）：VO 用于将业务数据传递给前端视图层，通常是一个与业务相关的数据结构，比如用于展示用户信息的 VO 对象。

```java
public class UserVO {
    private Long id;
    private String username;
    // getters and setters
}
```

6. POJO（Plain Old Java Object）：POJO 是一个普通的 Java 对象，没有继承任何特定的框架或接口。它通常用于表示数据的纯粹状态，不包含业务逻辑。

```java
public class User {
    private Long id;
    private String username;
    private String password;
    // getters and setters
}
```

7. Query：Query 用于封装查询条件，通常用于在 DAO 层进行数据库查询操作。

```java
public class UserQuery {
    private String username;
    private String password;
    // getters and setters
}
```

### spring-boot 整合 mybatis-plut

1. 导入 maven 依赖

```xml
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.2.0</version>
        </dependency>
```

2. 配置
    1. 配置数据源
        1. 导入驱动。（根据数据库版本导入驱动）
        ```xml
        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
         <dependency>
             <groupId>mysql</groupId>
             <artifactId>mysql-connector-java</artifactId>
             <version>8.0.17</version>
         </dependency>
        ```
        2. 在 application.yml 配置数据源相关信息
        ```yml
        spring:
          datasource:
            username: root
            password: root
            url: jdbc:mysql://127.0.0.1:3306/gulimall_pms?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
            driver-class-name: com.mysql.cj.jdbc.Driver
        mybatis-plus:
          mapper-locations: classpath:/mapper/**/*.xml
       
          #设置实体类的自增主键
          global-config:
            db-config:
              id-type: auto
        ```
       
   2. 配置MyBatis-Plus:
        1. 设置dao的文件位置。在Application启动类中设置。
        
        ```java
        @MapperScan("com.atguigu.gulimall.product.dao")
        ```
        
        2. 设置mapper的文件位置。在application.yml中设置。
        
           ```yml
           mybatis-plus:
             mapper-locations: classpath:/mapper/**/*.xml
           ```
        
           
