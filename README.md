# platform
# 基本准备
## 创建项目
&ensp;&ensp;&ensp;&ensp;环境：idea、java8
&ensp;&ensp;&ensp;&ensp;*file->new->project->spring initializer*
&ensp;&ensp;&ensp;&ensp;接下来是一些配置和依赖项的选择，根据需要填写即可。
&ensp;&ensp;&ensp;&ensp;（添加）目录结构如下：
![初期目录结构](https://img-blog.csdn.net/20181015230359880?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2lkY2hhbmd5aWZhbg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

## 添加数据库相关
&ensp;&ensp;&ensp;&ensp;本项目采用mysql数据库，准备为项目添加mybatis-generator。
&ensp;&ensp;&ensp;&ensp;第一步：在pom文件的**plugins**标签下加入以下配置：

```
<!--mybatis-generator插件-->
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.6</version>
                <configuration>
                    <configurationFile>src/main/resources/generatorConfig.xml</configurationFile>
                    <verbose>true</verbose>
                    <overwrite>true</overwrite>
                </configuration>
                <dependencies>
                    <dependency>
                        <groupId>org.mybatis.generator</groupId>
                        <artifactId>mybatis-generator-core</artifactId>
                        <version>1.3.6</version>
                    </dependency>
                    <dependency>
                        <groupId> mysql</groupId>
                        <artifactId>mysql-connector-java</artifactId>
                        <version>8.0.11</version>
                    </dependency>
                </dependencies>
            </plugin>
```

&ensp;&ensp;&ensp;&ensp;值得注意的是这里的版本号：*mybatis-generator*最好是1.3.5以上，这样可以指定生成mapper文件的名字，*mysql-connector-java*采用8以上，因为用的是mysql8，否则将会报错。
&ensp;&ensp;&ensp;&ensp;第二步：根据上面的配置添加*src/main/resources/generatorConfig.xml*如下所示：

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <!-- 数据库驱动包位置 -->
    <properties resource="jdbc.properties" />
    <context id="context" targetRuntime="MyBatis3">
        <commentGenerator>
            <property name="suppressAllComments" value="true"/>
        </commentGenerator>

        <jdbcConnection
                driverClass="com.mysql.jdbc.Driver"
                connectionURL="jdbc:mysql://127.0.0.1:3306/platform?serverTimezone=UTC"
                userId="root"
                password="123456">
        </jdbcConnection>

        <javaTypeResolver>
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>

        <!-- 生成dao的包名和位置 -->
        <javaModelGenerator targetPackage="com.orchard.platform.dao.entity" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>

        <!-- 生成的xml文件包名和位置 -->
        <sqlMapGenerator targetPackage="com.orchard.platform.dao.mapper" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>

        <!-- 生成mapper的包名和位置 -->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.orchard.platform.dao.mapper"
                             targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>


        <table schema="" tableName="user_info" domainObjectName="UserInfo"
               modelType="flat" mapperName="UserInfoMapper" enableCountByExample="true"
               enableUpdateByExample="true"
               enableDeleteByExample="true"
               enableSelectByExample="true"
               selectByExampleQueryId="true">
        </table>
    </context>
</generatorConfiguration>
```
&ensp;&ensp;&ensp;&ensp;这里的坑是注意在connectionURL="jdbc:mysql://127.0.0.1:3306/platform?serverTimezone=UTC"添加?serverTimezone=UTC以解决时区问题，否则会报错。
&ensp;&ensp;&ensp;&ensp;第三步：添加src/main/resource/jdbc.properties:

```
driverClass="com.mysql.jdbc.Driver"
connectionURL="jdbc:mysql://127.0.0.1:3306/platform?serverTimezone=UTC"
userId="root"
password="123456">
```
&ensp;&ensp;&ensp;&ensp;第四步：idea右上角edit configuration：
![在这里插入图片描述](https://img-blog.csdn.net/2018101617285291?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2lkY2hhbmd5aWZhbg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

&ensp;&ensp;&ensp;&ensp;最后，点击右侧maven project，双击generator：
![在这里插入图片描述](https://img-blog.csdn.net/20181016173005503?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2lkY2hhbmd5aWZhbg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
　　如果一切正常，将生成4个文件，如下所示：
　　![在这里插入图片描述](https://img-blog.csdn.net/2018101617321274?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2lkY2hhbmd5aWZhbg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

　　
