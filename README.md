# smart-campus-platform
Smart Campus Academic Services Platform – BoCS3100 Advanced Java Group Project.

# Smart Campus Academic Services Platform (SCASP)

## 1. Project Overview

The Smart Campus Academic Services Platform (SCASP) is a Java-based academic services management system designed to improve the delivery and management of academic services within higher education institutions.

The platform aims to provide a centralised solution for managing students, courses, registrations, academic requests and institutional announcements.

## 2. Project Objectives

The main objectives are to:

- Improve access to academic services.
- Simplify course registration and management.
- Support academic request processing.
- Improve communication through announcements.
- Provide reliable academic data storage.
- Demonstrate Java programming and software engineering concepts.

## 3. Technologies Used

| Technology | Purpose |
|---|---|
| Java JDK 27 | Application development |
| Apache Maven | Project and dependency management |
| NetBeans 25 | Java development environment |
| MySQL | Relational database |
| XAMPP | Local MySQL server environment |
| JDBC | Database connectivity |
| Git and GitHub | Version control and collaboration |

## 4. Project Structure

The project is organised into two main Maven modules:

### Core Domain

Contains:
- Domain entities
- Collections
- Service classes
- Repository interfaces and implementations
- Concurrent processing
- Networking classes
- Enterprise service wrappers
- JDBC database repositories
- Database connection utilities
- Testing classes
- SQL database script

### Application Layer

Contains:
- Application entry point
- Controllers
- Application integration
- Application testing classes

## 5. Database Design

The project uses a MySQL database named `smart_campus_db`.

The database contains six main tables:

1. students
2. courses
3. registrations
4. academic_requests
5. administrators
6. announcements

The database structure is maintained in the `schema.sql` file.

## 6. Implemented Features

The current development work includes:

- Student and course domain models.
- Academic registration and request models.
- Announcement and administrator models.
- Java collection management.
- Synchronized collections for concurrent access.
- Basic TCP client-server communication.
- Enterprise service wrapper classes.
- JDBC database connectivity.
- MySQL database integration.
- JDBC repository operations.
- Application-layer integration and testing.

## 7. Testing

The following tests have been conducted:

- Core Domain build test.
- Application Layer build test.
- Application integration test.
- Concurrency test.
- TCP networking test.
- Database connection test.
- JDBC repository tests.
- SQL schema import test.

## 8. Future Development

Further development may include:

- User authentication and role-based access.
- Web application development.
- Remote Method Invocation (RMI).
- Android application development.
- Notification services.
- Waiting-list management.
- Reporting and audit functionality.

## 9. Installation and Setup

### Prerequisites

- Java JDK 27
- Apache Maven
- NetBeans IDE
- XAMPP with MySQL
- Git

### Database Setup

1. Start MySQL using XAMPP.
2. Open phpMyAdmin.
3. Import `schema.sql`.
4. Ensure the database name is `smart_campus_db`.

### Building the Project

Open the project in NetBeans and build the Maven modules.

For the Core Domain, run:

```bash
mvn clean install
```

For the Application Layer, run:

```bash
mvn clean install
```

## 10. Project Status

The project is under development. Core Domain and Application Layer components have been implemented and tested. Additional platform components and functionality remain part of the planned development.

## 11. Repository

This repository contains the source code, database scripts and documentation for the Smart Campus Academic Services Platform.

