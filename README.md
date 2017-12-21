# Flash Card App
This app allows users to create and review flash cards

## About
 - Maven for build tool
 - Spring boot for application framework
 - h2 in memory database
 - Spring security for authentication/authorization
 - Bootstrap for UI

## To run the app
1. Clone the repository "_git clone https://github.com/sfhallahan/flash-card-app.git_"
2. Navigate into the flash-card directory "_cd flash-card_"
3. Build using maven "_mvn clean install_"
4. Navigate into the target folder "_cd target_"
5. Run the app "_java -jar flash-card-0.0.1-SNAPSHOT.jar --spring.profiles.active=h2_"
6. Using a browser, go to "_localhost:6565_"
7. Enter login credentials
    - Username: _admin_
    - Password: _admin_
    
* H2 database can be viewed at _localhost:6565/console_


 
