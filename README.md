# Waste Sorting Backend Application

### A Spring Boot RESTful API for Waste Sorting and Management

This project is part of an assessment to build a backend system for a waste sorting mobile application. The API enables users to manage waste categories, disposal guidelines, and recycling tips, promoting sustainable waste management practices.

---

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

---

## Overview

The Waste Sorting Backend Application is a RESTful API designed to:
- Add, update, delete, and retrieve waste categories.
- Provide disposal guidelines and recycling tips for each waste category.
- Ensure input validation and proper error handling.

This application uses an in-memory H2 database for simplicity and rapid testing.

---

## Features

1. **CRUD Operations**:
    - Manage waste categories.
    - Store and retrieve disposal guidelines and recycling tips.

2. **Validation**:
    - Ensures input data is valid using Spring Boot validation annotations.

3. **Error Handling**:
    - Returns meaningful error messages for invalid input and missing resources.

4. **In-memory Database**:
    - Uses H2 for lightweight and fast database interactions.

---

## Technologies Used

- **Java**: Core programming language.
- **Spring Boot**: Backend framework for REST API development.
- **H2 Database**: In-memory database for testing.
- **Maven**: Build automation tool.
- **Lombok**: Simplifies Java code by reducing boilerplate.
- **JUnit**: Unit testing framework.

---

## Setup and Installation

### Prerequisites
- **Java 17 or later**: Ensure you have JDK installed.
- **Maven**: For managing dependencies and running the application.
- **Git**: For version control.

### Steps to Run the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/ntwano14/waste-sorting-backend.git
   cd waste-sorting-backend
   
### On Terminal run the following commands
2. Build the project: mvn clean install
3. Run the application: mvn spring-boot:run
4. Access the H2 database console at: http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:testdb
   Username: sa
   Password: (leave blank)
   


