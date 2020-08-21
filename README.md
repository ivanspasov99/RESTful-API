### RESTful-API

*This is my first intro learning project at SAP Labs Bulgaria*

## Setup

# Requirements
1. Java 14
2. Maven
3. PostgreSQL

> PostgreSQL needs to be configured manual
> 1. Download form https://www.postgresql.org/
> 2. Run for Mac 
>
>     `brew install postgresql`

>     `brew services start postgresql`

>     `createdb -h localhost -p 5432 Blog`

  # Run
  1. Clone the repository
  2. Run mvn spring-boot:run
  3. Call localhost:8080/api/post
  
  
  # Operations - Requests
  **1. GET:** *api/post*         -> getAllPosts
  
  **2. GET:** *api/post/id*      -> getSpecificPost with id
  
  **3. POST:** *api/post*        -> create new post
  
  **4. PUT:** *api/post/id*      -> update existing post with id
  
  **5. DELETE:** *api/post/id*   -> delete post
  
  
  # Technologies Used
  1. Spring Boot 2.3.3
  2. Maven
  3. PostgreSQL