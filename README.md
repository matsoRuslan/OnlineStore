# OnlineStore
OnlineStore is a test project created by Matso Ruslan.
# Project setup
To run this project you need to:
- Change user name and password of your mysql db connection in com/test/config/AppConfig.java:
  * dataSource.setUsername("userName");
  * dataSource.setPassword("password").
- Set project SDK to java 1.8.
- Set run configuration to Maven, set command line to "tomcat7:run", example for Intellij IDEA:
  * Go to “Run” menu and click “Edit Configurations…”, click “+” icon at the top left and select “Maven”
  * Set working directory to your project location.
  * Set command line to "tomcat7:run".
- Now project can be accessed at: http://localhost:8080/home/ 
- You can check login info in database table "User" in file import.sql (https://github.com/matsoRuslan/OnlineStore/blob/master/src/main/resources/import.sql):
  - admin: login-admin, password-12345678
  - user: login-user1, password-11111111
