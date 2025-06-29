# LogExecutionAnnotation 📊

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![AOP](https://img.shields.io/badge/Spring-AOP-blue.svg)](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A Spring Boot application demonstrating **Aspect-Oriented Programming (AOP)** to measure and log execution time of service methods using custom annotations.

## 🚀 Features

- **Custom Annotation**: `@LogExecutionTime` for marking methods
- **Aspect-Oriented Programming**: Non-intrusive execution time logging
- **Spring Boot 3.5**: Latest framework version
- **Java 17**: Modern Java features
- **Precise Timing**: Millisecond-level execution time measurement
- **Clean Logging**: Structured log output with method signatures

## 📋 Prerequisites

- **Java 17** or higher
- **Maven 3.6+** or **Gradle 7+**
- **Spring Boot 3.5**

## 🛠️ Installation

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/LogExecutionAnnotation.git
cd LogExecutionAnnotation
```

### 2. Build the Project

```bash
# Using Maven
mvn clean install

# Using Gradle
./gradlew build
```

### 3. Run the Application

```bash
# Using Maven
mvn spring-boot:run

# Using Gradle
./gradlew bootRun

# Or run the JAR file
java -jar target/LogExecutionAnnotation-1.0.0.jar
```

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── bhanu/
│   │           ├── LogExecutionAnnotationApplication.java
│   │           ├── annotation/
│   │           │   └── LogExecutionTime.java
│   │           ├── aspect/
│   │           │   └── ExecutionTimeAspect.java
│   │           ├── controller/
│   │           │   └── UserController.java
│   │           ├── service/
│   │           │   └── UserService.java
│   │           └── model/
│   │               └── User.java
│   └── resources/
│       └── application.yml
```

## 💡 Core Components

### 📌 Custom Annotation

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
    String value() default "";
}
```

### 🎯 Aspect Implementation

```java
@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {
    
    @Around("@annotation(com.bhanu.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        Object result = joinPoint.proceed();
        
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        
        log.info("Method {}.{} executed in {} ms", 
                className, methodName, executionTime);
        
        return result;
    }
}
```

### 🎮 Controller Example

```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable Long id) {
        String user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
```

### 🔧 Service Implementation

```java
@Service
public class UserService {
    
    @LogExecutionTime
    public String getUserById(Long id) {
        // Simulate database call or complex operation
        try {
            Thread.sleep(1500); // Simulating delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "User-" + id;
    }
}
```

## 🧪 Usage Examples

### API Testing

Test the endpoint to see execution time logging in action:

```bash
curl --location 'http://localhost:8080/api/users/1'
```

**Response:**
```
User-1
```

**Console Output:**
```
2025-06-29T14:32:10.793+05:30 DEBUG 23666 --- [LogExecutionAnnotation] [nio-8080-exec-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to com.bhanu.controller.UserController#getUser(Long)
2025-06-29T14:32:12.319+05:30  INFO 23666 --- [LogExecutionAnnotation] [nio-8080-exec-1] com.bhanu.aspect.ExecutionTimeAspect     : Method UserService.getUserById executed in 1508 ms
```

### Multiple Method Testing

```bash
# Test different users
curl 'http://localhost:8080/api/users/1'
curl 'http://localhost:8080/api/users/2'
curl 'http://localhost:8080/api/users/3'
```

## ⚙️ Configuration

###
