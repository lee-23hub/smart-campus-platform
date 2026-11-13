# SCASP DOMAIN MODEL

## 1. Introduction

The domain model describes the main entities of the Smart Campus Academic Services Platform (SCASP), their attributes and relationships. It provides a foundation for implementing the system using Java object-oriented programming concepts.

## 2. Main Domain Entities

### 2.1 Student

The Student entity represents a student registered on the platform.

Attributes:
- studentId: String
- fullName: String
- email: String
- password: String
- programme: String
- yearOfStudy: int

### 2.2 Course

The Course entity represents an academic course offered by the institution.

Attributes:
- courseId: String
- courseName: String
- courseCode: String
- creditHours: int
- capacity: int

### 2.3 Registration

The Registration entity represents a student's registration for a particular course.

Attributes:
- registrationId: String
- studentId: String
- courseId: String
- registrationDate: LocalDate
- status: String

### 2.4 AcademicRequest

The AcademicRequest entity represents an academic service request submitted by a student.

Attributes:
- requestId: String
- studentId: String
- requestType: String
- description: String
- submissionDate: LocalDate
- status: String

### 2.5 Administrator

The Administrator entity represents an authorised person responsible for managing the platform.

Attributes:
- administratorId: String
- fullName: String
- email: String
- password: String

### 2.6 Announcement

The Announcement entity represents information published for students and academic staff.

Attributes:
- announcementId: String
- title: String
- message: String
- publicationDate: LocalDate
- authorId: String

## 3. Relationships Between Entities

1. A Student can have multiple Registration records.
2. A Course can have multiple Registration records.
3. Each Registration belongs to one Student and one Course.
4. A Student can submit multiple Academic Requests.
5. An Administrator can manage academic information and platform records.
6. An Administrator or authorised staff member can publish Announcements.

## 4. Object-Oriented Design

The domain model supports object-oriented programming through:

- Encapsulation: Attributes are protected using appropriate access modifiers.
- Abstraction: Each entity represents an important part of the academic system.
- Inheritance: Shared user attributes may be placed in a common User superclass.
- Association: Entities interact through defined relationships.

## 5. Conclusion

The SCASP domain model identifies the main objects required for the platform. It provides a foundation for implementing Java classes, collections, business logic and database relationships.