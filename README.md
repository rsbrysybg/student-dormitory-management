# 学生宿舍管理系统

## 项目简介
基于Java Swing开发的学生宿舍管理系统，用于管理学生宿舍分配、住宿信息及相关数据，提供宿舍管理的各项功能。

## 技术栈
- Java
- Java Swing (GUI)
- JDBC
- MySQL 8.0

## 主要功能
- 宿舍信息管理（宿舍分配、住宿信息管理）
- 用户登录认证
- 数据的增删改查操作
- 宿舍管理员界面

## 项目结构
```
学生宿舍管理系统/
└── 学生宿舍管理系统/
    └── MISPoject第11周课堂例子/
        ├── src/
        │   └── misproject/
        │       ├── dao/          # 数据访问层
        │       │   ├── JXUserDao.java
        │       │   ├── JDBC.java
        │       │   ├── LoginUserDao.java
        │       │   ├── UUDao.java
        │       │   └── UserDao.java
        │       ├── pojo/         # 实体类
        │       │   ├── JXUser.java
        │       │   ├── LoginUser.java
        │       │   ├── UU.java
        │       │   └── User.java
        │       └── window/       # 界面层
        │           ├── JXEdit.java
        │           ├── Login.java
        │           ├── Main.java
        │           ├── MainJX.java
        │           ├── MyTable.java
        │           ├── User1Edit.java
        │           └── UserEdit.java
└── java综合实验报告.docx         # 实验报告
```

## 运行说明

### 环境要求
- JDK版本：JDK 8 或以上
- IDE：IntelliJ IDEA 或 Eclipse
- 数据库：MySQL 8.0

### 运行步骤
1. 克隆项目到本地
   ```bash
   git clone [仓库地址]
   ```

2. 使用IDE打开项目

3. 配置数据库连接
   - 创建数据库：根据实际需求创建
   - 导入SQL文件（如有）
   - 修改`JDBC.java`中的数据库连接信息（用户名、密码）

4. 运行主程序
   - 找到主类：`misproject.window.MainJX`
   - 运行主类

## 项目截图
[可添加项目运行截图，展示界面效果]

## 开发时间
2024年4月

## 作者
魏嘉良

## 许可证
MIT License
