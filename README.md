# Microservices Architecture with Spring Cloud

This repository contains an implementation of a microservices architecture using Spring Cloud. It covers key components such as Eureka Service Discovery, API Gateway, and Config Server, along with various microservices.

## Microservices Implemented
- **Config Server** - Centralized configuration management.
- **API Gateway** - Handles routing, authentication, and load balancing.
- **Service Registry (Eureka Server)** - Manages service discovery.
- **Hotel Service** - Manages hotel-related operations.
- **Review Service** - Handles user reviews for hotels.
- **User Service** - Manages user-related operations.

## Features
- Eureka-based service discovery.
- Centralized configuration using Spring Cloud Config Server.
- API Gateway for routing and security.
- Independent microservices for modular development.

## Getting Started
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Start the **Config Server** first.
3. Start the **Service Registry (Eureka Server)**.
4. Start the **API Gateway**.
5. Start the microservices (**Hotel Service, Review Service, User Service**).

## Technologies Used
- Spring Boot
- Spring Cloud Eureka
- Spring Cloud Config
- Spring Cloud Gateway
- Java

## License
This project is for learning purposes.
