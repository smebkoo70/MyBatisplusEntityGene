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
