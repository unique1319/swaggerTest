# Swagger Test #

## 说明 ##
项目为自主学习测试，基于
**SpringForAll / spring-boot-starter-swagger**

<https://github.com/SpringForAll/spring-boot-starter-swagger>

## 集成 ##
```
    <dependency>
        <groupId>com.spring4all</groupId>
        <artifactId>swagger-spring-boot-starter</artifactId>
        <version>1.9.1.RELEASE</version>
    </dependency>
```
默认使用注解`@EnableSwagger2`

可配置使用注解`@EnableSwagger2Doc`，同时添加依赖
```
    <dependency>
         <groupId>javax.validation</groupId>
         <artifactId>validation-api</artifactId>
         <version>1.1.0.Final</version>
     </dependency>
```
配置项
```
    swagger.enabled=true
    swagger.title=API在线文档
    swagger.description=swagger 2.x 学习测试
    swagger.version=V1.0
    swagger.base-package=com.wrh.swaggertest
    swagger.base-path=/**
    swagger.exclude-path=/error, /ops/**
    swagger.authorization.type=None
```
详细配置参见`SpringForAll / spring-boot-starter-swagger`

## 访问 ##
API:
`http://localhost:8080/swagger/swagger-ui.html`
H2控制台: `http://localhost:8080/swagger/h2`