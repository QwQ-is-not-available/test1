这个是nacos项目，在启动那两个模块之前需要准备nacos服务器

目前定的nacos服务器ip是`192.168.56.108:8848`，在`application.properties`中定义的

然后直接运行springboot就行

当前这个是添加了gateway网关，可以用8080端口访问8081和8091路径上的东西

test1是只是添加了nacos和网关，

---------------
test2是配置了热更新。要自己在nacos添加一点:

+ data id: `nacos-test2-hw1.properties`
+ Group: DEFAULT_GROUP
+ 内容: `test2.test.aSentence=msg from nacos`

添加了sentinel，目前写的端口是9080


