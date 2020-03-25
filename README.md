# plantsplants
Spring Boot Micro-services Project

## Maven Setup
* Maven >=3.2.5 (recommended)

## Oracle maven dependencies
1. Sign up for [Oracle SSO](https://www.oracle.com/webapps/maven/register/license.html)
2. Add the repository definition as following (already added in this project's ```pom.xml```):
    ```xml
    <repositories>
        <repository>
            <id>maven.oracle.com</id>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
            <url>https://maven.oracle.com</url>
            <layout>default</layout>
        </repository>
    </repositories>
    <pluginRepositories>
        <pluginRepository>
            <id>maven.oracle.com</id>
            <url>https://maven.oracle.com</url>
        </pluginRepository>
    </pluginRepositories>
    ```
3. Download [wagon-http](https://repo1.maven.org/maven2/org/apache/maven/wagon/wagon-http-shared/2.8/wagon-http-shared-2.8.jar) and place the jar into your ```MAVEN_HOME/lib/ext/``` folder.
4. Configure HTTP Wagon in your maven ```settings.xml```
```xml
    <server>
      <id>maven.oracle.com</id>
      <username>sdusername</username>
      <password>password</password>
      <configuration>
        <basicAuthScope>
          <host>ANY</host>
          <port>ANY</port>
          <realm>OAM 11g</realm>
        </basicAuthScope>
        <httpConfiguration>
          <all>
            <params>
              <property>
                <name>http.protocol.allow-circular-redirects</name>
                <value>%b,true</value>
              </property>
            </params>
          </all>
        </httpConfiguration>
      </configuration>
    </server>
```
5. In your default profile, add the repository as following (already added in this project's ```pom.xml```):
```xml
    <profiles>
        <profile>
            <id>main</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <repositories>
                <repository>
                    <id>maven.oracle.com</id>
                    <url>https://maven.oracle.com</url>
                    <layout>default</layout>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                </repository>
            </repositories>
        </profile>
    </profiles>
```
Source: [Oracle](https://docs.oracle.com/middleware/1213/core/MAVEN/config_maven_repo.htm#MAVEN9010)
## Database server (Oracle)
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
    | id	         | int(11)      | NO   | PRI | 0       |       |
    | genus       | varchar(45)  | NO   |     | 0       |       |
    | species     | varchar(45)  | NO   |     | 0       |       |
    | cultivar    | varchar(255) | NO   |     | 0       |       |
    | common      | int(11)      | NO   |     | 0       |       |

* Configure ```datasource``` in ```\plantsplants\src\main\resources\application.properties```
## Building and running
* Clone the repo: ```git clone https://github.com/m4mukulgarg/plantsplants.git```
* Import as Exisiting maven project in eclipse.
* Execute maven update from eclipse or ```mvn clean install -U``` from terminal.
* Add Run configuration -> Java Application
* Project name: ```plantsplants```
* Main class: ```tech.infinence.plantsplants.PlantsplantsApplication```
* Apply and run
* Browse to http://localhost:8080 from your favourite browser.
