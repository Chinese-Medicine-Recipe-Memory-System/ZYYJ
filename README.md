# 项目结构：

## java src：controller（控制层）、service（业务逻辑层）、mapper（数据访问层）

（1）控制层(com.zyyj.controller.*)：只负责接收视图层（页面）传入的请求，调用业务逻辑层方法完成请求处理，返回数据到视图层 <br>

（2）业务逻辑层(com.zyyj.service.*): 接收从控制层传来的需要处理的数据，同时会调用数据访问层的方法操作数据库完成处理<br>

（3）数据访问层(com.zyyj.mapper.*): 用mybatis实现的数据库访问层<br><br><br>

（4）配置文件（src.conf.*): springMVC配置文件和mybatis配置文件

## Web-content: 
 （1）/***/*.jsp: 按照功能模块划分路径的各个页面
 （2）utility.jsp: 工具集合，包括加载外部页面的ajax代码和向后端发送搜索请求和接收搜索结果的ajax代码

