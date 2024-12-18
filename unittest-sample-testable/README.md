## Tutorial
* https://alibaba.github.io/testable-mock

## 一、install：
1. import jar
```xml
<dependency>
    <groupId>com.alibaba.testable</groupId>
    <artifactId>testable-core</artifactId>
    <version>${testable.version}</version>
</dependency>
```
2. config maven plugin
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
4. 
## 二、Rules
1. The package path of the test class and the tested class is the same, otherwise the mock will fail
2. If the mock contains a non-tested class, it must be placed in the ${TargetClass}Test class
3. The mock container associated with the test class is a static class named Mock inside it, or an independent class named the tested class name + Mock under the same package path. If this convention is not met, the @MockWith annotation must be used to explicitly specify it
