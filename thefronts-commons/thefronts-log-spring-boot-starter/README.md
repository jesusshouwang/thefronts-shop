| 配置项                   | 配置说明                                                     | 默认值 |
| :----------------------- | :----------------------------------------------------------- | :----- |
| thefronts.trace.enable         | 是否开启日志链路追踪                                         | false  |
| thefronts.audit-log.enabled    | 是否开启审计日志                                             |        |
| thefronts.audit-log.logType    | 日志记录类型(logger/redis/db/es)                             |        |
| thefronts.audit-log.datasource | 日志数据源配置，logType=db时生效(非必须)，如果不配置则使用当前数据源 |        |