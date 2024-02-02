## 教程
* https://alibaba.github.io/testable-mock

## 一、安装：
1. 引入jar包
```xml
<dependency>
    <groupId>com.alibaba.testable</groupId>
    <artifactId>testable-core</artifactId>
    <version>${testable.version}</version>
</dependency>
```
2. 配置插件
```xml
 <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.0.0-M6</version>
    <configuration>
        <forkCount>4</forkCount>
        <argLine>
            @{argLine} -javaagent:${settings.localRepository}/com/alibaba/testable/testable-agent/${testable.version}/testable-agent-${testable.version}.jar
        </argLine>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.testable</groupId>
            <artifactId>testable-agent</artifactId>
            <version>${testable.version}</version>
        </dependency>
    </dependencies>
</plugin>

```
## 二、约定 
1. 测试类与被测类的包路径相同，否则会Mock失败
2. 如果mock里包含非被测试类 必须放到${TargetClass}Test类里
3. 测试类关联的Mock容器为在其内部且名为Mock的静态类，或相同包路径下名为被测类名+Mock的独立类，不符合此约定需使用@MockWith注解显示指定
