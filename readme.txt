项目说明：
xframe-springcloud-eureka-server eureka服务注册中心
xframe-springcloud-eureka-ha-server eureka高可用服务注册中心，可以通过cmd启动两个进程，参数分别为--spring.profiles.active=peer1和--spring.profiles.active=peer2。
xframe-springcloud-eureka-provider-user 用户服务提供者，只是个demo，可以通过cmd启动两个进程，参数分别为--server.port=2222和--server.port=2223
xframe-springcloud-ribbon-consumer 用户服务消费者，通过eureka服务注册中心以轮询方式调用xframe-springcloud-eureka-provider-user服务
xframe-springcloud-eureka-ribbon-hystrix-consumer 用户服务消费者（Hystrix版本），提供了超时调用转入fallback机制。
xframe-springcloud-hystrix-dashboard hystrix仪表盘，监控xframe-springcloud-eureka-ribbon-hystrix-consumer调用情况。
---------------
后续进一步预研
spring cloud Ribbon (客户端负载均衡)
spring cloud Hystrix (服务容错保护)：服务降级、服务熔断、线程和信号隔离、请求缓存、请求合并以及服务监控等功能。
spring cloud Feign (声明式调用服务)
spring cloud Zuul (API网关服务)
spring cloud Config (分布式配置中心)