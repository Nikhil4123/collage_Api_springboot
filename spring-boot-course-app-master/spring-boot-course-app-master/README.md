# spring-boot-course-app
University Course Application assignment

# Pre Requisite 
Please make sure you have Java 1.8 intalled and present in environment path.

# Feature 
 Spring Boot + Spring Data JPA + Rest Webservices + Swagger-UI with H2 database.

# DB Design
![db-design](https://user-images.githubusercontent.com/10242113/27259436-fa1aa6f4-5430-11e7-9214-c0c5c2c11f42.JPG)

# Steps To run the application
- Download project or checkout it.
- Open command prompt at pom.xml level and type "mvn package" cammand.
- In the target folder you can see course-app-0.0.1-SNAPSHOT.jar is generated.
- Use cammand  "java -jar  ./target/course-app-0.0.1-SNAPSHOT.jar" to run the jar file.
- Now the application has started.
- Hit http://localhost:8080/course-app/console url on browser to configure database. You can see following database page on browser just click on connect button.

![db-connection](https://user-images.githubusercontent.com/10242113/27259441-180927f8-5431-11e7-9192-279af81dc3cb.JPG)

- Run SQL queries present in file course_create.sql (present in "/main/resource" folder) on DB SQL console section to create schema and table you can see COURSE schema gets generated.

![schema-generation](https://user-images.githubusercontent.com/10242113/27259446-2bedcc88-5431-11e7-909b-9ce16f938df1.JPG)

- To see all application ReST Services and their decription hit this URL http://localhost:8080/course-app/swagger-ui.html 
![swagger-ui](https://user-images.githubusercontent.com/10242113/27277923-89477f24-54fd-11e7-9d1f-85c320ae8609.JPG)

- To see the application UI as below you can hit http://localhost:8080/course-app/ and add university, course and students.
Following is some of the sample data for Universities which I have derived from the link 
https://raw.githubusercontent.com/Hipo/university-domains-list/master/world_universities_and_domains.json

        alpha_two_code : US,
        country: United States,
        domain: calbaptist.edu,
        name: California Baptist University,
        web_page: http://www.calbaptist.edu/

        alpha_two_code: US,
        country: United States,
        domain: stevenson.edu,
        name: Stevenson University,
        web_page: http://www.stevenson.edu/

        alpha_two_code: US,
        country: United States,
        domain: mbl.edu,
        name: Marine Biological Laboratory,
        web_page: http://www.mbl.edu/

        alpha_two_code: US,
        country: United States,
        domain: maryville.edu,
        name: Maryville University,
        web_page: http://www.maryville.edu/


See Following app screen shot
![homescreen](https://user-images.githubusercontent.com/10242113/27259584-c91391c6-5433-11e7-9265-2d1920fd87fc.JPG)
![add-course](https://user-images.githubusercontent.com/10242113/27259543-f448f5a8-5432-11e7-874a-3ccc23f58596.JPG)
![add-university](https://user-images.githubusercontent.com/10242113/27259542-f444c348-5432-11e7-98d8-8206dfd5d393.JPG)
