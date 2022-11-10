# aeroparker-api-service
This service is for Aero parker Customer Service; This is an API based light weight serverless application on the below technology 
- Java, Springboot, Junit, Lombok , Javax Validator 
- Restful Api - Json message format
- H2 In memmory Data Base with JPA ( Copitable with SQL like MySQL/Oracle Data Base)

This service has the following Api end point for submitting Cutomner Resgistration Form 
POST : http://localhost:8080/registration

**1. Sample Payload for Successful submission**. 
Response ( Http Status OK- 200)
_{"emailAddress":"lhamma24@gmail.coM",
"title":"Mrs",
"firstName":"ghdtr",
"lastName":"Xolxo",
"addressLine1":" 24 wellington road",
"addressLine2":"North Shileds",
"city":"Newcastle",
"postCode":"sx12 4ty",
"phoneNumber":"1234567"
}_

**2. Sample Payload with having missing Cutomer Data ( Validation issue).  **
Response ( Http Status Bad Request - 400)
_{"emailAddress":"lhamma24@gmail.coM",
"title":"Mrs",
"firstName":"ghdtr",
"lastName":"Xolxo",
"addressLine1":" 24 wellington road",
"addressLine2":"North Shileds",
"city":"Newcastle",
"postCode":"",
"phoneNumber":"1234567"
}_

Response - 400 Bad Request 
[Email address is present, PostCode can not be empty]


**3. SQL Scripts :**
drop table if exists customers;

_create table customers
(
    id             integer      not null,
    address_line_1 varchar(255) not null,
    address_line_2 varchar(255),
    city           varchar(255),
    email_address  varchar(255) not null,
    first_name     varchar(50)  not null,
    last_name      varchar(50)  not null,
    phone_number   varchar(20),
    post_code      varchar(10)  not null,
    registered     timestamp,
    title          varchar(5)   not null,
   _ primary key (id)
)

- **Error handling **
Custom Exception for validation,  Controller advise for handling exception. 

**Code Modularity and cleanness** - Followed SOLID princes, Object Oriented Interface approach, and Cleaning coding including using Lombok 

Junit Coverage - 100% for services, controller, repository, validation logic 
![image](https://user-images.githubusercontent.com/116227949/201052087-9a302227-77d6-4355-80fa-01ec917ff3fa.png)


