# User Management System
This is a simple Spring Boot application that demonstrates basic CRUD operations (Create, Read, Update, Delete) for managing users. It includes a model, repository, service, and controller to manage user data, all stored in an in-memory repository.

## Features
- Create a new user
- Read user information
- Update existing user details
- Delete a user

## Project Structure
- User Model: Represents a user with attributes like id, name, and email.
- User Repository: An in-memory repository simulating data access, with CRUD operations.
- User Service: A service layer that interacts with the repository to handle business logic.
- User Controller: A REST controller that defines endpoints for CRUD operations.

## Requirements
- Java 17+
- Maven
- Postman or cURL (for testing the API)

## Setup and Run
1. Clone the Repository:
```
git clone https://github.com/Kjeff35/java-upskilling-week3-lab.git
cd java-upskilling-week3-lab
```

2. Build and Run:
```
mvn spring-boot:run
```

3. Test Endpoints:
Use Postman or cURL to interact with the REST API.

Use Postman or cURL to interact with the REST API.

- Create a User:

```
POST /add-user
```

Body (JSON):
```json
{
    "name": "John Doe",
    "age": 23,
    "email": "john.doe@example.com"
}
```

- Get All Users:
```
GET /users
```

- Get User by Email:
```
GET /users/find-user?email={email}
```

- Update User:
```
PUT /change-user/{email}
```

Body (JSON):
```json
{
    "name": "Johnathan Doe",
    "age": 23,
    "email": "john.doe@example.com"
}
```

- Delete User:

```
DELETE /delete-user/{email}
```

4. Run Unit Tests
```
mvn test
```
