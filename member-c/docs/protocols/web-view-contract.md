# Web View Contract (Servlets -> JSP)
Servlets must set these before forwarding. JSPs only read them (no scriptlets).

| JSP | Request attributes | Item fields |
|-----|--------------------|-------------|
| all | `flash`, `errorMessage` (optional), `errors` (Map<String,String> from ValidationResult.errors()) | |
| all | session: `user` (name, role = STUDENT or STAFF), `csrfToken` | |
| dashboard | `registrationCount`, `openRequestCount`, `waitlistCount`, `announcements` | title, body |
| courses | `courses` | courseCode, title, enrolled, capacity, status |
| registrations | `registrations` | courseCode, status, position, createdAt |
| requests | `requests` | requestId, category, priority, status, assignedTo |
| reports | `capacityReport`, `workloadReport`, `auditEvents` | courseCode, enrolled, capacity, waiting / staff, open, closed / occurredAt, actor, action, entityType, entityId |

Servlet rules: POST validates with `Validators`, checks `csrfToken` equals the session token, then redirects (PRG). On validation failure forward back with `errors`, HTTP 400.
Items must be JavaBeans (getters) so EL can read them (Stage 4, item 1).
