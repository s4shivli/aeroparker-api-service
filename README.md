# aeroparker-api-service
This service is for Aero parker Customer Service; This is an API based light weight serverless application on the below technology 
- Java, Springboot, Junit, Lombok , Javax Validator 
- Restful Api - Json message format
- H2 In memmory Data Base with JPA ( Copitable with SQL like MySQL/Oracle Data Base)

This service has the following Api end point for submitting Cutomner Resgistration Form 
POST : http://localhost:8080/registration

1. Sample Payload for Successful submission. 
Response ( Http Status OK- 200)


2. Sample Payload with having missing Cutomer Data ( Validation issue).  
Response ( Http Status Bad Data - 400)


- SQL Scripts :


- Error handling 
Custom Exception for validation,  Controller advise for handling exception. 

Code Modularity and cleanness - Followed SOLID princes, Object Oriented Interface approach, and Cleaning coding including using Lombok 

Junit Coverage - 100% for srvices, controller 

