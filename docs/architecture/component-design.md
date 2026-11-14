# SMART CAMPUS ACADEMIC SERVICES PLATFORM (SCASP)

# ARCHITECTURE AND COMPONENT DESIGN

## 1. Introduction

The Smart Campus Academic Services Platform (SCASP) uses a modular software architecture consisting of independent components that work together to provide academic services to students, academic staff and administrators.

The system is developed using Java, Maven, JDBC and MySQL. Its modular design supports maintainability, scalability, reusability, concurrency and system integration.

This document describes the architecture, implemented components and current development status, with particular focus on Member A and Member B responsibilities.

## 2. Main System Components

### 2.1 Core Domain

The Core Domain contains the main business entities and rules of the system.

Implemented entities include:
- Student
- Course
- Registration
- Academic Request
- Administrator
- Announcement

The component also contains collections, services, repositories and interfaces that support the management of academic information.

### 2.2 Concurrent Processing

This component supports simultaneous access to shared academic data.

Java synchronization was implemented in the main collection classes to help prevent conflicting access when multiple threads perform operations.

A concurrency test was conducted using multiple threads, successfully adding 300 student records.

### 2.3 Network Gateway

The networking component supports communication using Java TCP sockets.

The following classes were implemented:
- CampusServer
- CampusClient
- NetworkingTest

A local client-server connection was successfully tested. The current implementation demonstrates basic connection handling and can be extended to support message exchange.

### 2.4 Enterprise Services

The enterprise service component provides service-level access to academic operations.

The following service wrappers were implemented:
- StudentEnterpriseService
- CourseEnterpriseService
- RegistrationEnterpriseService
- AcademicRequestEnterpriseService
- AnnouncementEnterpriseService

These classes provide an additional service layer around existing business services. Full EJB deployment has not yet been implemented.

### 2.5 Persistence JDBC

The Persistence JDBC component manages communication between the Java application and the relational database.

The system uses:
- Java Database Connectivity (JDBC)
- MySQL
- MySQL Connector/J
- Prepared statements for database operations

JDBC repositories were implemented for:
- Students
- Courses
- Registrations
- Academic Requests
- Administrators
- Announcements

The repositories support database operations such as saving, retrieving, counting and deleting records.

A database named `smart_campus_db` was created with six corresponding tables.

The database connection and repository operations were successfully tested.

### 2.6 Application Layer

The Application Layer coordinates access to the Core Domain through controllers and integration classes.

Implemented classes include:
- StudentController
- CourseController
- RegistrationController
- AcademicRequestController
- AnnouncementController
- ApplicationIntegration
- ApplicationLayerTest

The application integration test successfully added and retrieved in-memory student, course and registration records through the domain services.

The current application integration uses the existing in-memory services. Direct integration of the application services with the JDBC repositories remains a possible extension.

### 2.7 Web Application

The proposed Web Application will provide browser-based access to academic services using Java Servlets and JavaServer Pages (JSP).

This component is part of the proposed architecture and is not yet implemented in the current Member A and Member B scope.

### 2.8 RMI Administration

This proposed component will support remote communication and administration through Java Remote Method Invocation (RMI).

### 2.9 Android Client

The proposed Android Client will provide a mobile interface through which users can access supported academic services.

## 3. Component Interaction

The components communicate through defined interfaces and service operations.

- The Application Layer coordinates access to the Core Domain.
- The Core Domain provides shared academic entities and business rules.
- Collections manage groups of academic records.
- Services provide operations for managing academic information.
- Repository interfaces define data access operations.
- JDBC repositories communicate with the MySQL database.
- Concurrent Processing supports simultaneous access to shared collections.
- The Network Gateway demonstrates basic client-server communication.
- Enterprise Services provide an additional service layer around business operations.

## 4. Database Design

The system uses a MySQL relational database named `smart_campus_db`.

The database contains six tables:

1. `students`
2. `courses`
3. `registrations`
4. `academic_requests`
5. `administrators`
6. `announcements`

Foreign key relationships maintain the relationships between students, courses, registrations, academic requests and administrators.

The database structure is also maintained in a `schema.sql` file under the Core Domain resources directory.

## 5. Project Structure

The project is divided into two main Maven modules:

### Core Domain
Contains:
- Domain entities
- Collections
- Services
- Repository interfaces and implementations
- Integration classes
- Networking classes
- Enterprise service wrappers
- Database connection and JDBC repositories
- Testing classes
- Database schema script

### Application Layer
Contains:
- Application entry point
- Controllers
- Application integration
- Application testing classes

## 6. Testing and Verification

The following tests were successfully completed:

| Test | Result |
|---|---|
| Core Domain build | Successful |
| Application Layer build | Successful |
| Application integration test | Successful |
| Concurrency test | 300 student records added |
| TCP networking test | Successful local connection |
| Database connection test | Successful |
| JDBC student repository test | Successful |
| Combined JDBC repository test | Successful |
| SQL schema import | 8 queries executed successfully |

These tests demonstrate that the implemented components compile and that the tested operations work as expected.

## 7. Architectural Design Considerations

The architecture follows a modular approach to make the system easier to maintain, test and extend.

The main design considerations include:

- **Modularity:** Each component has a clearly defined responsibility.
- **Reusability:** Shared entities, services and interfaces can be used by different components.
- **Scalability:** The architecture allows additional services and components to be introduced.
- **Concurrency:** Synchronization supports safer access to shared collections.
- **Maintainability:** Separate Maven modules organize the application.
- **Data persistence:** JDBC and MySQL provide relational data storage.
- **Integration:** Interfaces and service classes support communication between components.

## 8. Conclusion

The Smart Campus Academic Services Platform has established a modular foundation through its Core Domain and Application Layer.

The implemented work covers domain modelling, collections, concurrency, basic networking, enterprise service wrappers, JDBC persistence, database design and application integration.

The architecture also provides a foundation for future development of the Web Application, RMI Administration and Android Client components.

