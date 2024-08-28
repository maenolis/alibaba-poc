# Alibaba-POC
## Cloud Modules
This repository contains a basic presentation of **spring-cloud-alibaba** modules:
- Configuration Server (Nacos)
- Service Discovery (Nacos)
- Messaging (RocketMQ)
## Project Modules
### 1. company-management
##### Description
The company-management module contains exclusively company related functionality. Also, this module acts as the business orchestrator during integration
scenarios. (eg. update manager flow)
##### Database Schema
###### Manager Table
|  column  |  type  |  comment  |
|---------:|-------:|----------:|
|id|bigint(20)|identifier|
|first_name|varchar(50)|manager's first name|
|last_name|varchar(50)|manager's last name|
### 2. employee-management
##### Description
The employee-management module handles CRUD operations for the employee related resources. Additionally, the employee-management module is the last service invoked during the update manager flow.
##### Database Schema
###### Employee Table
|  column  |  type  |  comment  |
|---------:|-------:|----------:|
|id|bigint(20)|identifier|
|first_name|varchar(50)|employee's first name|
|last_name|varchar(50)|employee's last name|
|is_manager|boolean|is manager indicator|
### 3. shared-model
The shared-model module contains shared DTOs and is imported by both company-management and employee-management modules.
###### RocketMessageDto
|  property  |  type  |  comment  |
|---------:|-------:|----------:|
|id|Long|identifier|
|message|String|the payload|
###### EmployeeDto
|  property  |  type  |  comment  |
|---------:|-------:|----------:|
|id|Long|identifier|
|firstName|String|manager's first name|
|lastName|String|manager's last name|
|isManager|boolean|is manager indicator|
##### Description
TBD
