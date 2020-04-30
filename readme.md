# template-mybatis 快速开发后台管理架构
### 一直在寻找一个快速开发的框架，市面也有类似于jeecg/guns/x-boot这些。个人觉得有些局限，没法满足我的需求，所以我的快速开发框架诞生。该架构还有配套前端，我的爱人正在编辑中。介时会放上此文档。

## 使用说明

### 基础实体实现
- 基础实体类 
--	BaseEntity 里面含有一些基本字段
```java
	// 编号
    private Long id;
	
	// 创建时间
    private Date ctime;
	
	// 修改时间
    private Date utime;
	
	// 逻辑删除
    private int deleted;
```
所有实体类均需继承此实体类。

### 用户模块设计

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

