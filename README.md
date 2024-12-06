## Language

- [English](#english)
- [中文](#中文)

---

### English

# MySQL Code Generator

## Introduction

This project includes a tool for automating the generation of Java code. It is based on the `AutoGenerator` class from MyBatis-Plus and can automatically generate entity classes, Mapper interfaces, Service interfaces, Service implementation classes, Controller classes, and other common CRUD code from specified MySQL database tables. The generated code can be quickly used in projects to help developers accelerate the development process.

## Features

- Automatically generate corresponding entity classes (`Entity`) from MySQL database tables
- Generate corresponding Mapper interfaces and XML configuration files
- Generate Service interfaces and implementation classes
- Automatically generate Controller layer (supports RESTful style)
- Use Lombok annotations to simplify code (such as `@Data`, `@Builder`, `@Getter`, `@Setter`, etc.)
- Automatically generate ResultMap and common database operation methods

## Usage Instructions

### 1. Environment Requirements

- JDK 1.8 or higher
- Maven or Gradle build tools
- MySQL database

### 2. Configuration Steps

#### 2.1 Modify Database Connection Information

In the `MysqlGenerator` class, you need to modify the database connection details. Adjust the following information as needed:

```java
// Data source configuration
DataSourceConfig dsc = new DataSourceConfig();
dsc.setUrl("jdbc:mysql://your-database-address:3306/database-name?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
dsc.setDriverName("com.mysql.cj.jdbc.Driver");
dsc.setUsername("database-username");
dsc.setPassword("database-password");
```

#### 2.2 Modify Package Name and Path Configuration

In the `MysqlGenerator` class, you can set the package name and path for the generated code. Modify the following lines of code as needed:

```java
// Package configuration
PackageConfig pc = new PackageConfig();
pc.setParent("com.mpgene.target1"); // Set the package name for the generated code
```

Additionally, you can set the output directory for the generated code:

```java
// Global configuration
gc.setOutputDir(projectPath + "/src/main/java");  // Set the output directory for the generated code
```

#### 2.3 Specify the Tables for Code Generation

You can specify the database tables for which you want to generate code by modifying the following code (you can pass multiple tables as a string array):

```java
// Strategy configuration
String[] tables = {"test1", "users", "seats"};
strategy.setInclude(tables);  // Specify the tables for which code will be generated
```

### 3. Run the Generator

After executing the `MysqlGenerator.main()` method, the code generator will connect to the specified MySQL database, read the structure of the specified tables, and automatically generate the code based on your configuration. The generated code will be stored in the `src/main/java` directory, organized according to the package name and layer structure you set.

### 4. Generated Code Structure

The directory structure for the generated code is as follows:

```
src
└── main
    └── java
        └── com
            └── mpgene
                └── target1
                    ├── controller
                    │   └── Test1Controller.java
                    ├── entity
                    │   └── Test1.java
                    ├── mapper
                    │   └── Test1Mapper.java
                    ├── service
                    │   └── Test1Service.java
                    └── service/impl
                        └── Test1ServiceImpl.java
```

- `controller`: The generated RESTful style controller
- `entity`: The generated entity class (corresponding to the database table)
- `mapper`: The generated Mapper interface
- `service`: The generated service interface
- `service/impl`: The generated service implementation class

### 5. Features

- Utilizes the MyBatis-Plus code generator, which automatically generates common code based on database tables.
- Automatically adds Lombok annotations to entity classes, reducing boilerplate code.
- The generated code can be modified and extended according to actual needs, greatly improving development efficiency.

## Contribution

Contributions to this project are welcome. If you have any suggestions or issues, feel free to submit them.

## License

This project is licensed under the MIT License. Please refer to the [LICENSE](LICENSE) file for more details.


---

### 中文

# MySQL Code Generator

## 简介

该项目包含一个用于自动化生成 Java 代码的工具。它基于 MyBatis-Plus 的 `AutoGenerator` 类，能够从指定的 MySQL 数据库表中自动生成实体类、Mapper 接口、Service 接口、Service 实现类、Controller 类等常见的 CRUD 代码。生成的代码可以快速用于项目中，帮助开发者加快开发速度。

## 功能

- 自动根据 MySQL 数据库表生成对应的实体类（`Entity`）
- 生成对应的 Mapper 接口及 XML 配置文件
- 生成 Service 接口及实现类
- 自动生成 Controller 层（支持 RESTful 风格）
- 使用 Lombok 注解简化代码（如 `@Data`, `@Builder`, `@Getter`, `@Setter` 等）
- 自动生成 ResultMap 和常见的数据库操作方法

## 使用说明

### 1. 环境要求

- JDK 1.8 或以上
- Maven 或 Gradle 构建工具
- MySQL 数据库

### 2. 配置步骤

#### 2.1 修改数据库连接信息

在 `MysqlGenerator` 类中，你需要修改数据库连接的相关信息。根据需要调整以下内容：

```java
// 数据源配置
DataSourceConfig dsc = new DataSourceConfig();
dsc.setUrl("jdbc:mysql://你的数据库地址:3306/数据库名?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
dsc.setDriverName("com.mysql.cj.jdbc.Driver");
dsc.setUsername("数据库用户名");
dsc.setPassword("数据库密码");
```

#### 2.2 修改包名和路径配置

在 `MysqlGenerator` 类中，你可以设置生成代码的包名和路径。根据需要修改以下代码：

```java
// 包配置
PackageConfig pc = new PackageConfig();
pc.setParent("com.mpgene.target1"); // 设置生成代码的包名
```

此外，你还可以设置代码输出目录：

```java
// 全局配置
gc.setOutputDir(projectPath + "/src/main/java");  // 设置生成代码的输出目录
```

#### 2.3 指定生成的数据库表

可以在以下代码中指定需要生成代码的数据库表（多个表可以以字符串数组的形式传入）：

```java
// 策略配置
String[] tables = {"test1", "users", "seats"};
strategy.setInclude(tables);  // 指定需要生成代码的表
```

### 3. 运行生成器

执行 `MysqlGenerator.main()` 方法后，代码生成器将会连接到指定的 MySQL 数据库，读取指定的表结构，并根据配置自动生成代码。生成的代码将存放在 `src/main/java` 目录下，按照你设置的包名和层级结构组织。

### 4. 生成代码结构

生成代码的目录结构大致如下：

```
src
└── main
    └── java
        └── com
            └── mpgene
                └── target1
                    ├── controller
                    │   └── Test1Controller.java
                    ├── entity
                    │   └── Test1.java
                    ├── mapper
                    │   └── Test1Mapper.java
                    ├── service
                    │   └── Test1Service.java
                    └── service/impl
                        └── Test1ServiceImpl.java
```

- `controller`: 生成的 RESTful 风格的控制器
- `entity`: 生成的实体类（对应数据库表）
- `mapper`: 生成的 Mapper 接口
- `service`: 生成的服务接口
- `service/impl`: 生成的服务实现类

### 5. 特性

- 使用了 MyBatis-Plus 自动化生成器，能够基于数据库表自动生成常用代码。
- 自动为实体类添加 Lombok 注解，减少冗余代码。
- 生成的代码可根据实际需求进行修改和扩展，极大提高开发效率。

## 贡献

欢迎对本项目进行贡献。如果你有任何建议或问题，欢迎提出。

## License

该项目遵循 MIT 许可证，详情请参见 [LICENSE](LICENSE) 文件。

