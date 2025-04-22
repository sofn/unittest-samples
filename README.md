# Java Unit Testing Samples / Java单元测试示例

This repository contains examples of various unit testing libraries and frameworks for Java projects. It serves as a reference for developers looking to understand and implement different testing approaches.

本代码仓库包含了Java项目中各种单元测试库和框架的示例。它为希望理解和实现不同测试方法的开发人员提供了参考。

## Project Structure / 项目结构

The project is organized into multiple modules, each focusing on a specific testing framework or technique:

该项目分为多个模块，每个模块专注于特定的测试框架或技术：

- **unittest-common**: Common code shared across modules / 各模块共享的通用代码
- **unittest-sample-junit4**: JUnit 4 testing examples / JUnit 4测试示例
- **unittest-sample-junit5**: JUnit 5 testing examples / JUnit 5测试示例
- **unittest-sample-mockito**: Mockito examples for mocking objects / Mockito对象模拟示例
- **unittest-sample-powermock**: PowerMock examples for mocking static/final methods / PowerMock静态/final方法模拟示例
- **unittest-sample-spock**: Spock framework examples (Groovy-based testing) / Spock框架示例（基于Groovy的测试）
- **unittest-sample-spring**: Spring framework testing examples / Spring框架测试示例
- **unittest-sample-spring-boot**: Spring Boot testing examples / Spring Boot测试示例
- **unittest-sample-testable**: Testable-mock examples / Testable-mock示例

## Testing Frameworks / 测试框架

### JUnit Platforms / JUnit平台
- **JUnit 4**: Traditional JUnit testing / 传统JUnit测试
- **JUnit 5**: Next generation testing platform with enhanced features / 具有增强功能的下一代测试平台
- **Spock**: Groovy-based testing and specification framework / 基于Groovy的测试和规范框架

### Mocking Libraries / Mock库
- **Mockito**: Popular mocking framework for unit tests / 单元测试中流行的模拟框架
- **PowerMock**: Extension to Mockito for mocking static/final methods / Mockito的扩展，用于模拟静态/final方法
- **Testable-mock**: Lightweight mocking tool / 轻量级模拟工具

## Key Features / 主要特性

The examples demonstrate various testing techniques:

这些示例演示了各种测试技术：

- Basic unit testing / 基本单元测试
- Mocking dependencies / 模拟依赖
- Testing static methods / 测试静态方法
- Testing final classes / 测试final类
- Argument matchers / 参数匹配器
- Stubbing / 存根技术
- Spying on real objects / 监视真实对象
- Spring integration testing / Spring集成测试
- Spring Boot testing / Spring Boot测试
- Data-driven testing / 数据驱动测试
- Advanced mocking techniques / 高级模拟技术

## Requirements / 要求

- Java 11 or higher / Java 11或更高版本
- Maven 3.6 or higher / Maven 3.6或更高版本

## Getting Started / 快速入门

1. Clone this repository / 克隆此代码库
2. Run `mvn clean test` to execute all tests / 运行`mvn clean test`执行所有测试
3. Or navigate to specific modules to run tests individually / 或者导航到特定模块单独运行测试

## License / 许可证

See LICENSE file for details / 详情请参阅LICENSE文件
