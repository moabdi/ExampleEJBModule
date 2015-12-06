
### Example of EJB module

#### To install server module (BankEJB), you have  to :
 1. Install JBoss server (this application is run on version wildfly-8.2.1.Final)
 2. Add mysql driver (com/mysl/main) on the path: wildfly-8.2.1.Final/modules/system/layers/base/com
 3. Create a new database in mysql
 4. Create a new datasource in JBoss using the database created
 5. Deploy the application on JBoss server.
 


### Example project to call EJB module:
1. Use ClientEJB project.
2. import BankEJB into ClientEJB project in the classpath.
3. Add the jboss-client.jar library in the classpath.
4. Run application using ClientRemote class.
