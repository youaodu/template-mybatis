# template-mybatis 自用快速开发框架

## 技术选型

|技术|版本|描述|
| - | - | - |
| Springboot  | 2.1.8.RELEASE | 不用介绍吧            |
| MybatisPlus | 3.3.1.tmp     | 非常常见的 Dao 层框架 |
| hutool      | 5.2.4         | 非常好用的国产工具集  |
| Jpa         | 2.1.8.RELEASE | 用来自动生成表的      |

## 类结构说明
```
├── template-admin // 后台应用部分
│   ├── template-admin-application // 后台应用启动模块
│   ├── template-admin-biz // 后台应用业务处理模块
│   ├── template-admin-controller // 后台应用对外接口模块
├── template-client // 客户端应用部分
│   ├── template-client-application // 客户端应用启动模块
│   ├── template-client-biz // 客户端应用业务处理模块
│   ├── template-client-controller // 客户端应用对外接口模块
├── template-common
│   ├── template-common-dao // 公共ORM展示层
│   ├── template-common-entity // 公共封装对象
│   │   ├── template-common-entity-model // ORM映射实体类
│   │   ├── template-common-entity-pojo // POJO
│   ├── template-common-framework // 基础框架
│   ├── template-common-service // 公共业务封装
```
