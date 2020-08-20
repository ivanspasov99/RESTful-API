### RESTful-API
*This is my first intro learning project at SAP Labs Bulgaria*
---

## Setup

# Requirements
1. Java 14
2. Maven
3. PostgreSQL

> PostgreSQL needs to be configured manual
> 1. Download form https://www.postgresql.org/
> 2. Run DB on Port-5432
> 3. Fill these line in your application.properties after you clone the repository
>   - spring.datasource.url=jdbc:postgresql://localhost:5432/Blog>   
>   - spring.datasource.username=<fill it if you want>
>   - spring.datasource.password=<fill it if you want>
  
  # Run
  1. Clone the repository
  2. Run mv - is it necesseary
  3. Call localhost:8080/api/post
  
  
  # Operations - Requests
  
  **1. GET:** *api/post*    getAllPosts
  
  **2. GET:** *api/post/id*   getSpecificPost with id
  
  **3. POST:** *api/post*   create new post
  
  **4. PUT:** *api/post/id*    update existing post with id
  
  **5. DELETE:** *api/post/id*    delete post
  
  
  # Technologies
  1. Spring Boot 2.3.3
  2. Maven
  3. PostgreSQL
