# ShopFlow Authentication Service

## Service Description

The ShopFlow Authentication Service is a standalone microservice responsible for user authentication and authorization within the ShopFlow ecosystem. It provides RESTful endpoints for user registration (signup) and login (signin), using JSON Web Tokens (JWT) for secure communication.

## Tech Stack

- **Java 17**
- **Spring Boot 2.7.5**
- **Spring Security** for authentication and authorization.
- **Spring Data JPA** for database interaction.
- **PostgreSQL** as the primary database.
- **Maven** for dependency management.
- **JWT (JSON Web Tokens)** for securing API endpoints.

## How to Run in Dev Mode

To run the service in development mode, you can use the following Maven command:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

This will start the service on port `8081` and connect to the development database as configured in `src/main/resources/application-dev.properties`.

## API Endpoints

### Authentication

- **POST /api/auth/signup**

  Registers a new user.

  **Example Request:**

  ```json
  {
    "username": "testuser",
    "email": "testuser@example.com",
    "password": "password123",
    "roles": ["user"]
  }
  ```

  **Example Response:**

  ```json
  {
    "message": "User registered successfully!"
  }
  ```

- **POST /api/auth/signin**

  Authenticates a user and returns a JWT token.

  **Example Request:**

  ```json
  {
    "username": "testuser",
    "password": "password123"
  }
  ```

  **Example Response:**

  ```json
  {
    "token": "<jwt_token>",
    "id": 1,
    "username": "testuser",
    "email": "testuser@example.com",
    "roles": ["ROLE_USER"]
  }
  ```

## Communication with Other Services

The Authentication Service is designed to be a central point for user authentication. Other microservices in the ShopFlow platform can integrate with it in the following ways:

- **Token Validation:** Other services can validate JWT tokens issued by the Authentication Service to secure their own endpoints. This is typically done by using a shared secret key and a JWT library to verify the token's signature and expiration.

- **User Information:** Once a token is validated, services can extract user information (such as user ID and roles) from the token payload to perform authorization checks and personalize user experiences.
