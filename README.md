# LogExecutionAnnotation
 Implement / get the execution time of a service method using spring aop.

Implemented using latest spring boot 3.5 version & java 17 version. 


curl below:
curl --location 'http://localhost:8080/api/users/1'
response:
User-1

You can check log in the console as below:
2025-06-29T14:32:10.793+05:30 DEBUG 23666 --- [LogExecutionAnnotation] [nio-8080-exec-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to com.bhanu.controller.UserController#getUser(Long)
2025-06-29T14:32:12.319+05:30  INFO 23666 --- [LogExecutionAnnotation] [nio-8080-exec-1] com.bhanu.aspect.ExecutionTimeAspect     : Method UserService.getUserById executed in 1508 ms{}
