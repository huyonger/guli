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

## Maven父工程
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
