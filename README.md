# Waste Sorting Backend Application
A Spring Boot RESTful API for Waste Sorting and Management

The Waste Sorting Application is designed to manage and categorize waste materials, providing guidelines for disposal and tips for recycling. The application supports creating, updating, and managing waste categories, disposal guidelines, and recycling tips. It uses a REST API built with Spring Boot, JPA for database interactions, and H2 for in-memory storage.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [API Endpoints](#api-endpoints)
- [Error Handling](#error-handling)
- [Testing](#testing)
- [Future Enhancements](#future-enhancements)
- [License](#license)

## Overview
The Waste Sorting Backend Application is a RESTful API designed to:
- Add, update, delete, and retrieve waste categories.
- Provide disposal guidelines and recycling tips for each waste category.
- Ensure input validation and proper error handling.

This application uses an in-memory H2 database for simplicity and rapid testing.

## Features
- **CRUD Operations**: Manage waste categories and store/retrieve disposal guidelines and recycling tips.
- **Validation**: Ensures input data is valid using Spring Boot validation annotations.
- **Error Handling**: Returns meaningful error messages for invalid input and missing resources.
- **In-memory Database**: Uses H2 for lightweight and fast database interactions.

## Technologies Used
- **Java**: Core programming language.
- **Spring Boot**: Backend framework for REST API development.
- **H2 Database**: In-memory database for testing.
- **Maven**: Build automation tool.
- **Lombok**: Simplifies Java code by reducing boilerplate.
- **JUnit**: Unit testing framework.

## Setup and Installation

### Prerequisites
- **Java 17 or later**: Ensure you have JDK installed.
- **Maven**: For managing dependencies and running the application.
- **Git**: For version control.

### Steps to Run the Application
1. **Clone the Repository**:
    ```bash
    git clone https://github.com/ntwano14/waste-sorting-backend.git
    cd waste-sorting-backend
    ```

2. **Build the Project**:
    ```bash
    mvn clean install
    ```

3. **Run the Application**:
    ```bash
    mvn spring-boot:run
    ```

4. **Access the H2 Database Console**:
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: (leave blank)

## API Endpoints

### Waste Categories

- **Create a Waste Category**
   - **Endpoint**: `POST /api/waste-categories`
   - **Request Body**:
    ```json
    {
      "name": "Plastic",
      "description": "Waste items made from plastic materials."
    }
    ```

- **Get All Waste Categories**
   - **Endpoint**: `GET /api/waste-categories`
   - **Response**:
    ```json
    [
      {
        "id": 1,
        "name": "Plastic",
        "description": "Waste items made from plastic materials."
      }
    ]
    ```

- **Update a Waste Category**
   - **Endpoint**: `PUT /api/waste-categories/{id}`
   - **Request Body**:
    ```json
    {
      "name": "Plastic",
      "description": "Updated description."
    }
    ```

- **Delete a Waste Category**
   - **Endpoint**: `DELETE /api/waste-categories/{id}`

### Disposal Guidelines

- **Add a Disposal Guideline to a Waste Category**
   - **Endpoint**: `POST /api/waste-categories/{categoryId}/disposal-guidelines`
   - **Request Body**:
    ```json
    {
      "guideline": "Dispose in the blue bin"
    }
    ```

- **Get All Disposal Guidelines for a Waste Category**
   - **Endpoint**: `GET /api/waste-categories/{categoryId}/disposal-guidelines`

### Recycling Tips

- **Add a Recycling Tip to a Waste Category**
   - **Endpoint**: `POST /api/waste-categories/{categoryId}/recycling-tips`
   - **Request Body**:
    ```json
    {
      "tip": "Clean and dry before recycling"
    }
    ```

- **Get All Recycling Tips for a Waste Category**
   - **Endpoint**: `GET /api/waste-categories/{categoryId}/recycling-tips`

## Error Handling
The API returns appropriate HTTP status codes for various error scenarios, including:
- **400 Bad Request** for invalid input or missing fields.
- **404 Not Found** when attempting to access non-existent resources.
- **500 Internal Server Error** for unexpected issues.

## Testing
You can test the API endpoints using tools like **Postman** by making requests to the listed endpoints. You can also write integration tests using **JUnit** and **Spring Boot Test** for automated testing.

## Future Enhancements
- Add user authentication and authorization.
- Implement a feature for uploading and processing waste sorting images.
- Expand the API to handle additional waste categories and recycling processes.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
