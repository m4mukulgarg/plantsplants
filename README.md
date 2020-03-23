# plantsplants
Spring Boot Micro-services Project

## Setup

### Database server

* Setup database server.
  * Database name: ```plants```
  * Table ```SPECIMEN```
    | Field       | Type         | Null | Key | Default | Extra |
    |-------------|--------------|------|-----|---------|-------|
    | specimen_id | int(11)      | NO   | PRI | 0       |       |
    | latitude    | varchar(45)  | NO   |     | 0       |       |
    | longitude   | varchar(45)  | NO   |     | 0       |       |
    | description | varchar(255) | NO   |     | 0       |       |
    | plant_id    | int(11)      | NO   |     | 0       |       |
    | plant_name  | varchar(45)  | NO   |     | 0       |       |
    
  * Table ```PLANTS```

    | Field       | Type         | Null | Key | Default | Extra |
    |-------------|--------------|------|-----|---------|-------|
    | id	  | int(11)      | NO   | PRI | 0       |       |
    | genus       | varchar(45)  | NO   |     | 0       |       |
    | species     | varchar(45)  | NO   |     | 0       |       |
    | cultivar    | varchar(255) | NO   |     | 0       |       |
    | common      | int(11)      | NO   |     | 0       |       |

* Configure URL, username, password in  
```
        \plantsplants\src\main\resources\application.properties
```
