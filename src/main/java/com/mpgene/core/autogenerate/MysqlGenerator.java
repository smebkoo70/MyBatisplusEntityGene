package com.mpgene.core.autogenerate;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
public class MysqlGenerator {

    private static final Logger logger = LoggerFactory.getLogger(MysqlGenerator.class);

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        System.out.println("Start……");

        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath == " + projectPath);
        gc.setOutputDir(projectPath + "/target/src/main/java");  // 修改生成路径，放到 target 下
        //gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("paris"); // 设置作者
        gc.setOpen(false);
        gc.setFileOverride(true); // 第二次生成会把第一次生成的覆盖掉
        gc.setServiceName("%sService"); // 生成的 service 接口名字首字母是否为 I，这样设置就没有
        gc.setBaseResultMap(true); // 生成 resultMap
        mpg.setGlobalConfig(gc);

        // 2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // mac pwd = 12345678

        dsc.setUrl("jdbc:mysql://your-address:3306/gengyun?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        // dsc.setPassword("");
        dsc.setPassword("your-password");

        mpg.setDataSource(dsc);

        // 3、包配置
        PackageConfig pc = new PackageConfig();
        // 设置包名为目标包 `com.mpgene.target`
        pc.setParent("com.mpgene.target1");  // 生成的代码会放在这个包下面
        mpg.setPackageInfo(pc);

        // 4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // strategy.setSuperControllerClass("com.example.jdk8demo.controller.BaseController");
        // strategy.setSuperEntityClass("com.example.jdk8demo.dto.BaseEntity");
        // strategy.setTablePrefix("t_"); // 表名前缀
        strategy.setEntityLombokModel(true); // 使用 Lombok
        strategy.setRestControllerStyle(true);

        String[] tables = {"test1", "users", "seats"};
        strategy.setInclude(tables);  // 逆向工程使用的表，如果要生成多个，传入 String[]
        mpg.setStrategy(strategy);

        // 5、执行
        mpg.execute();

        System.out.println("Finished……");
    }

}

