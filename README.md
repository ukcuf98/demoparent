# bootexample
springboot示例

#### 目录说明
demo-api : 服务消费，对外接口
demo-baseapi : service interface
demo-model : 各类vo+model等
demo-server : 服务提供，baseapi里各service实现
demo-util : 工具类

## 项目运行
本地只运行zookeeper
api与server项目里配置项spring.dubbo.registry.address可修改为zookeeper://127.0.0.1:2181

项目swagger文档地址
http://localhost:8081/swagger-ui.html



