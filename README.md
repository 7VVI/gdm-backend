# GDM-System

## 简介

> GDM（Graduation Design Management ）-System------用于解决大学生毕业设计统一管理的软件系统

**项目模块：**

![image-20230420200841964](https://picgo-liziyuan.oss-cn-hangzhou.aliyuncs.com/img202304202008393.png)

## 技术栈

### 前端

| 前端技术                     | 技术描述         | 官网                                             |
| ---------------------------- | ---------------- | ------------------------------------------------ |
| Typescript                   | 开发语言         | https://www.typescriptlang.org/                  |
| Vue3                         | 前端框架         | https://vuejs.org/                               |
| Vue-router                   | 路由框架         | https://router.vuejs.org/                        |
| Pinia2(Vuex，pinia兼容vuex） | 全局状态管理框架 | https://vuex.vuejs.org/                          |
| Ant design vue               | 前端`UI`框架     | https://www.antdv.com/                           |
| sweetalert2                  | 前端消息弹窗     | https://avil13.github.io/vue-sweetalert2/        |
| iconfont                     | 阿里icon         | https://www.iconfont.cn/                         |
| Axios                        | 前端HTTP框架     | http://www.axios-js.com/zh-cn/docs/#axios-config |
| vue-request                  | 管理请求状态     | [www.attojs.org](https://www.attojs.org/)        |
| Antv                         | 图表框架         | https://antv.gitee.io/zh/                        |
| Js-cookie                    | cookie管理工具   | https://github.com/js-cookie/js-cookie           |
| nprogress                    | 进度条控件       | https://github.com/rstacruz/nprogress            |

### 后端

| 后端技术                    | 技术描述           | 官网                                           |
| --------------------------- | ------------------ | ---------------------------------------------- |
| SpringBoot                  | 容器+`MVC`框架     | https://spring.io/projects/spring-boot         |
| MyBatis`/`MyBatis-Plus      | `ORM`框架          | http://www.mybatis.org/mybatis-3/zh/index.html |
| Redis                       | 分布式缓存（可选） | https://redis.io/                              |
| Druid                       | 数据库连接池       | https://github.com/alibaba/druid               |
| Lombok                      | 简化对象封装工具   | https://github.com/rzwitserloot/lombok         |
| Hibernator-Validator/JSR303 | 验证框架           | http://hibernate.org/validator                 |
| Kenife4j                    | 文档生成工具       | xxxxxxxxx                                      |

## 开发环境

### 开发工具

| 工具               | 说明                | 官网                                                  |
| ------------------ | ------------------- | ----------------------------------------------------- |
| IDEA               | 开发IDE             | https://www.jetbrains.com/idea/download               |
| RedisDesktop       | redis客户端连接工具 | https://github.com/qishibo/AnotherRedisDesktopManager |
| SwitchHosts        | 本地host管理        | https://oldj.github.io/SwitchHosts/                   |
| X-shell            | Linux远程连接工具   | http://www.netsarang.com/download/software.html       |
| Navicat Premium 15 | 数据库连接工具      | http://www.formysql.com/xiazai.html                   |
| PDManer            | 数据库设计工具      |                                                       |
| ScreenToGif        | gif录制工具         | https://www.screentogif.com/                          |
| DrawIO             | 流程图绘制工具      | https://drawio-app.com/                               |
| Snipaste           | 屏幕截图工具        | https://www.snipaste.com/                             |
| Postman            | API接口调试工具     | https://www.postman.com/                              |
| Typora             | Markdown编辑器      | https://typora.io/                                    |

### 开发环境

| 工具  | 版本号 | 下载                                                         |
| ----- | ------ | ------------------------------------------------------------ |
| JDK   | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql | 5.7    | https://www.mysql.com/                                       |
| Redis | 7.0    | https://redis.io/download                                    |
| git   |        | 版本控制                                                     |

## 开发进度

### 数据库表结构设计

> 详情见PDmaner

## 后端开发

### 项目进度

1. 菜单模块开发闭
2. 公告模块开发闭
3. 用户模块开发闭
4. 选题出题模块开发闭
5. 学生选题模块开发闭
6. 系统日志监控模块开发闭
7. 出题审计模块开发闭

### 审计流程

![image-20230422101706876](https://picgo-liziyuan.oss-cn-hangzhou.aliyuncs.com/img202304221017711.png)

1. 指导老师出题，完成题目的创建并提交审批；
2. 系负责人审核，审批结果可为“通过”或“不通过”；
3. 若系负责人审核未通过，则审批流程终止，原因说明在department_audit_opinion字段中体现；
4. 若系负责人审核通过，则由院负责人审核，审批结果可为“通过”或“不通过”；
5. 若院负责人审核通过，则审批流程结束，此时state字段标记为“已审核”；
6. 若院负责人审核未通过，则审批流程结束，原因说明在school_audit_opinion字段中体现。

### 权限设计

1. 学生

- 查看毕业设计题目

- 提交毕业设计进度

- 查看毕业设计进度

- 查看自己提交的毕业设计进度

- 修改自己提交的毕业设计进度

- 导出自己的毕业设计进度

2. 教师

- 查看毕业设计题目

- 查看毕业设计进度

- 查看自己指导的毕业设计进度

- 发布毕业设计题目

- 下载提交的毕业设计论文

3. 系负责人

- 查看毕业设计题目

- 查看毕业设计进度

- 审核毕业设计

4. 院负责人

- 查看毕业设计题目

- 查看毕业设计进度

- 审核毕业设计



## 前端开发

### 项目初始化

1. 创建项目

![image-20230423214425205](https://picgo-liziyuan.oss-cn-hangzhou.aliyuncs.com/img202304232144167.png)

2. 启动：

![image-20230423214456355](https://picgo-liziyuan.oss-cn-hangzhou.aliyuncs.com/img202304232144589.png)

3. 项目瘦身
4. 路由配置
5. 引入组件库
6. 开发页面
