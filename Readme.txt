
SSjpa=Spring+SpringMVC+jpa


1.Spring如何启动？
Tomcat加载web.xml的时候，启动Spring容器，
有三种启动方式：Listener，Servlet，Filter，

2.MyBatis如何启动的？
在Spring容器中启动，
DataSource负责管理JDBC连接，
SqlSessionFactoryBean是Spring给我们提供的类，可以启动MyBatis，还能自动扫描Mapper，
根据DataSource创建一个事务管理器，可以注解事务，也可以声明式事务。

3.SpringMVC如何启动的？
通过web.xml启动，入口是一个Servlet。
MVC框架的原理就是拦住大门，所有请求都由框架处理。


备注：
classpath代表类路径，项目启动之后存放class的目录就是classpath，
例如我们的web项目，class文件会放到/WEB-INF/classes/，所以这就是类路径，
而我们开发的时候，src/main/java以及src/main/resources这两个目录，都对应类路径，所以他们都是类路径。

exclude ：排除
include ：包含

实体类的包名：pojo / domain / entity / po / model