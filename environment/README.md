# Environment Notes
## Services
The following services should be up and running before starting the spring-boot applications:
- nacos
- mysql
- namesrv (rocketmq)
- broker (rocketmq)
- seata-server

Since the seata-server depends on nacos configuration, the seata-server needs to be started after the nacos server has been started. Moreover, 
the seata.properties configuration is also required if the seata-server is to be started.
## Nacos Configuration
