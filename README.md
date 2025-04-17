
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
git commit -m "feat: add validation in endpoint user"
```

After creating your commit, push your branch to the remote repository:

```bash
git push origin <YourBranchName>
```

Where *YourBranchName* is the name of the branch containing your changes.  
Then, go to GitHub and open a pull request.  
You must assign the project owner as a reviewer.

## Project Structure

