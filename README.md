
# The King Moss Backend

## Dependencies

- JDK 17
    
- Maven
    
- PostgreSQL
    
- Spring
    
    - Spring Web
        
    - Spring Boot DevTools
        
    - Lombok
        
    - Spring Data JPA
        
    - PostgreSQL Driver
        
    - Spring Security
        

## Running the Project

In your terminal, run the command:


```bash
mvn install
```

## Starting the Project
In your terminal, run the command:

```bash
mvn spring-boot:run
```

## Version Control Guidelines

Every change must be implemented in a separate branch.  
No changes should ever be pushed directly to the `main` branch.  
The commit message should start with the type of action (`fix`, `feat`, `refactor`), followed by a description written in the imperative mood.  
For example:

```bash
git commit -m "feat: add validation in endpoint client"
```

After creating your commit, push your branch to the remote repository:

```bash
git push origin <YourBranchName>
```

Where *YourBranchName* is the name of the branch containing your changes.  
Then, go to GitHub and open a pull request.  
You must assign the project owner as a reviewer.

## Project Structure

```bash
thekingmoss-be/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── thekingmoss/
│                   ├── controller/
│                   ├── service/
│                   ├── repository/
│                   ├── entity/
│                   ├── dto/
│                   ├── mapper/
│                   ├── exception/
│                   ├── security/
│                   └── ThekingmossBeApplication.java
├── src/
│   └── main/
│       └── resources/
│           ├── application.yml
│           └── static/
├── pom.xml
└── target/
```

### **Folder Structure Explanation**

1. **`controller/`**
    Contains the REST controllers that expose API endpoints.
    Example: `ProductController.java` handles HTTP requests like GET, POST, PUT, DELETE.

2. **`service/`**
    Contains the business logic of the application.
    Example: `ProductService.java` performs operations like creating or updating products.

3. **`repository/`**
    Interfaces that handle data access using Spring Data JPA.
    Example: `ProductRepository.java` extends `JpaRepository`.

4. **`entity/`**
    JPA entities mapped to database tables.
    Example: `Product.java` represents the `products` table.

5. **`dto/`**
    Data Transfer Objects used to send and receive data between the client and the server.

6. **`mapper/`**
    Contains mapper classes or interfaces that convert between `entity` and `dto`.

7. **`exception/`**
    Custom exceptions and global exception handling.

8. **`security/`**
    Spring Security configuration and filters (authentication, authorization, etc).

