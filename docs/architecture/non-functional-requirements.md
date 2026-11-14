
# 3. NON-FUNCTIONAL REQUIREMENTS

Non-functional requirements describe the quality attributes, performance expectations and operational constraints of the Smart Campus Academic Services Platform (SCASP).

## NFR01: Performance
The system shall process common user operations, including course searches and viewing announcements, within an acceptable response time under normal operating conditions.

## NFR02: Security
The system shall protect user accounts through secure authentication, password hashing and appropriate access control.

## NFR03: Reliability
The system shall handle unexpected errors without causing unnecessary system failures or loss of existing records.

## NFR04: Availability
The system should remain accessible to authorised users during the institution's normal operating hours, subject to planned maintenance.

## NFR05: Maintainability
The system shall use modular Java components and clearly defined interfaces to simplify debugging, updates and future improvements.

## NFR06: Scalability
The system should support an increasing number of students, courses and academic service requests without requiring a complete redesign.

## NFR07: Usability
The system shall provide clear navigation, understandable messages and consistent interfaces to help students and staff use its services.

## NFR08: Data Integrity
The system shall maintain accurate and consistent academic records by enforcing validation rules, database constraints and transaction management.

## NFR09: Compatibility
The system shall provide appropriate interfaces for supported desktop, web and Android environments.

## NFR10: Auditability
The system shall maintain records of important activities to support monitoring, accountability and administrative reviews.

## 4. Non-Functional Requirements Implementation Status

The non-functional requirements establish the expected quality standards and operational characteristics of the Smart Campus Academic Services Platform.

The current implementation provides a foundation for maintainability through modular Java development, concurrency through synchronized collections, and data integrity through MySQL primary keys and foreign key constraints.

Database connectivity, repository operations, application integration and basic networking have also been tested.

Further development and testing will be required to fully satisfy requirements relating to security, availability, usability, auditability and cross-platform compatibility.

These requirements will be reviewed throughout the development process to ensure that the completed system meets the expected quality standards.