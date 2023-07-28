<h1 align="center"> 
🏡Blogging Platform Api</h1>
This project is aimed at creating Blogging Platform API. This Readme.md file will guide you through the project setup, the models used, and the API endpoints available.

> ### Framework and Language used

- ![MySql](https://img.shields.io/badge/DBMS-MYSQL_8.0_or_Higher-blue)
- ![SpringBoot](https://img.shields.io/badge/Framework-SpringBoot-green)
- ![Security](https://img.shields.io/badge/Security-Spring_Security_6.1.0-red)
- ![JWT Authentication](https://img.shields.io/badge/JWT_Authentication-JWT_0.11.5-purple)
- ![Java](https://img.shields.io/badge/Language-Java%208%20or%20higher-yellow)

> ### Installation

To run this application locally, you will need to have Java and MySQL installed on your machine.

- Clone the repository to your local machine.
- Create a new MySQL database called `blogapi`
- Make sure you have Java JDK above 8 on ur local machine.
- Update the `application.properties` file in the `src/main/resources` directory to include your MySQL username and password
- Run the application using your IDE or by running the command `mvn spring-boot:run` in the project directory
- Access the APIs using any HTTP client such as Postman or Swagger open AI.

> ### API Documentation
>
> The API endpoints will be available at http://13.233.64.241:8080/
>
>To view full API documentation u can we my Documentation on swagger at http://13.233.64.241:8080/swagger-ui/index.html#/

> ### Data flow

> The application is built using the SpringBoot framework and consists of seven layers: DTO, model, controller, service, security, repository and jwt

- **DTO** -The DTO layer consists of classes that are used to transfer data between different layers of the application
- **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer.
- **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
- **Security** -We configure Spring security in this layer by creating security beans such as UserDetailsService,PasswordEncoder,SecurityFilterChain
- **JWT** - In this layer we configure JWT Authentication filter and create Jwt entry point.
- **Repository** - This layer maintains the data by accessing Mysql Database on which CRUD operations are performed.. for that we extend our interface with another interface called JpaRepository.
- **Model** - This layer consists basically the class level things-and this classes are stored in form of tables in given Mysql database as we annotate this class by @Entity.


>## Endpoints

> To access all this endpoints u must access ![auth/login]( https://img.shields.io/badge/auth%2Flogin-red) to generate jwt token then only u can access below api's through that jwt token.

> User Controller

This controller includes the following endpoints for user authentication:


- POST /user/signup :- to post new user with validation (email should end with "@gmail.com")
- GET /user/{id} :- to get particular by its id
- GET /user/welcome :- this is just for testing purpose

> Post Controller

This controller includes the following endpoints for posts:

- POST /post/create :- to create new post
- GET /post/{id} :- get post by its id
- GET /post/allPost/{contentType} :- filter first 10 post(used pagination) of given content type.
- GET /post/all/{userid} :- filter post of given user by its id
- DELETE /post/{id} :- delete the post only if post associated belongs to logged in user
- PUT /post :- update the post only if post associated belongs to logged in user

> Comment Controller

This controller includes the following endpoints for comments:

- POST /comment/create :- create new comment
- GET /comment/all/{postId} :- filter first 10 comments(used pagination) of given post
- DELETE /comment/{id} :- delete the comment only if comment associated belongs to logged in user
- /comment/{commentBody}/{commentId} :- update the comment body only if comment associated belongs to logged in user

> UserFollower Controller

This controller includes the following endpoints for Follower management:

- POST /userfollower/follow :- follow user
- GET /userfollower/followed/{id} :- get all followed user of particular user


### Models

> User Model

- userId
- email*
- password
- userHandle
- gender
- age
- userBio


> Post Model

- postId
- postContent
- postCaption
- postLocation
- contentType
- postOwner (of type User)

> Comment Model

- commentId
- commentBody
- instaPost	(of type Post)
- commenter (of type User)

> UserFollower Model

- userFollowerId
- owner	(of type User)
- followedUser (of type User whom owner follows)

> ## Contributor

- [Durgesh Sonawale](https://github.com/durgeshsonawale)

> ## Project Summary
>
> This project includes design of the backend of blogging platform, including user , post and comment model, and it contains JWT authentication security so that whenever user logged in by valid credential he will receive jwt token in response body to access all other endpoints as they are made secured through spring security.
