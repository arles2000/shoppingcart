# Shopping Cart API

## Overview

This project is a simple RESTful API for managing a shopping cart system. It is built using **Java** with **Spring Boot** as the main framework. The API provides endpoints for managing products, orders, and payments, and includes features for security, authentication, and authorization.

## Features

- **Product Management**: Endpoints to manage products within the shopping cart.
- **Order Management**: Endpoints to manage customer orders.
- **Payment Simulation**: Endpoints for simulating the payment process.
- **Clients and Order Details**: For the payment process simulation, only the entities and DTOs related to **Clients** and **Order Details** are required. These are essential for the payment mechanism, but no additional services or endpoints have been implemented for managing clients or order details directly.
- **Security**: Implemented basic authentication and role-based authorization to secure the endpoints.

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.2**
- **Spring Security**: For authentication and authorization.
- **H2 Database**: An in-memory database used for testing purposes.
- **Lombok**: To reduce boilerplate code.
- **Maven**: For dependency management.

## Getting Started

### Prerequisites

- **Java 17**
- **Maven**
- **Git**

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/arles2000/shoppingcart.git

2. **Build the project**:

   ```bash
   mvn clean install


3. **Run the application**:

   ```bash
   mvn spring-boot:run


**Endpoints**:

   | Method | Endpoint        | Description                   | Authenticated | Roles       |
      |--------|-----------------|-------------------------------|---------------|-------------|
   | GET    | `/api/products` | Retrieve all products         | Yes           | USER        |
   | POST   | `/api/orders`   | Create a new order            | Yes           | ADMIN       |
   | POST   | `/api/payments` | Simulate a payment process    | Yes           | USER, ADMIN |


**Authentication & Authorization**:

   The API uses basic authentication with role-based authorization to secure endpoints. The following roles are available:

    - **ADMIN**: Has access to all endpoints, including order management.
    - **USER**: Has access to product information and can simulate payments.

   **Credentials**:

    - **Admin User**:
        - Username: `shoppingAdmin`
        - Password: `Sh0ppingC@rtS3cur3!`
        - Role: `ADMIN`

    - **Standard User**:
        - Username: `shoppingUser`
        - Password: `Sh0ppingUs3rS3cur3!`
        - Role: `USER`

   **Authorization Rules**:

    - `/api/products`: Accessible by users with either the `USER` or `ADMIN` roles.
    - `/api/orders`: Accessible only by users with the `ADMIN` role.
    - `/api/payments`: Accessible by users with either the `USER` or `ADMIN` roles.

   Ensure that the correct credentials are provided when making requests to the API. The roles assigned to users dictate which endpoints they can access.


**Configuration**:

- **Port: The application runs on port 8081 by default. You can change this in the application.properties file.**


**Testing with Postman**:
You can use Postman to interact with the API. The collection is already set up to use environment variables for easy configuration.

**License**:
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

**Contact**:
For any inquiries, please contact arles_2000@hotmail.com.