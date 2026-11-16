# Requirements Catalogue (Stage 0)

## Functional requirements (priority: M = must, S = should)
| ID | Requirement | Pri | Unit |
|----|-------------|-----|------|
| FR1 | Student and staff demo accounts log in and out | M | 6 |
| FR2 | Role-based access: students cannot reach staff functions | M | 6 |
| FR3 | Staff create, update, search and sort courses (capacity, status) | M | 1 |
| FR4 | Student registers for a course; duplicates are rejected | M | 1 |
| FR5 | Registration stops at capacity; extra students join a waiting list | M | 1 |
| FR6 | Withdrawal promotes the next waiting student | M | 1 |
| FR7 | Student submits a service request (transcript, clearance, appeal) | M | 1 |
| FR8 | Staff prioritise, assign and track requests | M | 1 |
| FR9 | Announcements published to defined audiences | S | 5 |
| FR10 | Registration/request events produce notifications | S | 3 |
| FR11 | Reports: capacity, waiting list, workload, registrations, audit | M | 5 |
| FR12 | Audit trail records actor, action, entity, time | M | 5 |
| FR13 | Android client shows campus services and opens a map | M | 10 |
| FR14 | Remote admin client reads reports over RMI | S | 8 |

## Non-functional requirements
| ID | Requirement | Measure |
|----|-------------|---------|
| NFR1 | Concurrency safety | 1,000 parallel registrations never exceed capacity |
| NFR2 | SQL-injection resistance | All user values use PreparedStatement |
| NFR3 | Session security | HttpOnly cookie, session invalidated on logout |
| NFR4 | Output safety | All untrusted output escaped (c:out) |
| NFR5 | Usability | New student registers for a course in under 2 minutes unaided |
| NFR6 | Accessibility | Keyboard navigable, labelled fields, table captions |
| NFR7 | Reliability | Timeouts and user-safe errors; no stack traces shown |
| NFR8 | Portability | Builds from README on a clean Windows machine |
