# bootexample
>项目说明

springboot示例

> 目录说明

* demo-api : 服务消费，对外接口
* demo-baseapi : service interface
* demo-model : 各类vo+model等
* demo-server : 服务提供，baseapi里各service实现
* demo-util : 工具类

> 运行环境

* zookeeper安装版本3.5.4(否则服务无法注册导致报错)
* Redis为哨兵模式(使用集群模式对应api需要调整) 

>项目运行

* 本地运行只启动zookeeper,不需要dubbo就可以本地运行项目
* api与server项目里配置项spring.dubbo.registry.address可修改为zookeeper://127.0.0.1:2181
* 项目swagger文档地址 http://localhost:8081/swagger-ui.html
* 对于需要切换数据源的地方 service实现方法需要使用@DataSource(DataSourceInstances.SLAVE)注解，括号内为表示要切换为哪个数据源
* ProjConstant为对应application.property里的参数，value标签内参数名可做修改


