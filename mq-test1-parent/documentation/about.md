This is an example with rabbitmq, need a rabbitmq service before running

这个是带有rabbitmq的示例

运行前需要有个rabbitmq的服务，目前是

```shell
docker run \
-e RABBITMQ_DEFAULT_USER=admin \
-e RABBITMQ_DEFAULT_PASS=admin \
-v mq-plugins:/plugins \
--name mq \
--hostname mq \
-p 15672:15672 \
-p 5672:5672 \
-d \
rabbitmq:3.8-management
```
在此之前还要注册hw1的用户和virtual host

在配置文件中
```properties
spring.rabbitmq.host=192.168.56.108
spring.rabbitmq.port=5672
spring.rabbitmq.virtual-host=/hw1
spring.rabbitmq.username=hw1
spring.rabbitmq.password=admin
```

管理网页是在`http://192.168.56.108:15672`

The management page is at `http://192.168.56.108:15672`

----------------------------
`mq-test1-cons`和`mq-test1-pub`是用来简单测试基本功能和几种交换机，`mq-test2-cons`和`mq-test2-pub`是带上消息确认的

`mq-test1-cons` and `mq-test1-pub` are used to simply test basic functions and several exchanges, `mq-test2-cons` and `mq-test2-pub` are used to test message confirmation