# Manual Test Cases
Record Result as PASS/FAIL, tester, date, and an evidence file name (screenshot) in docs/evidence/.

## Web (Stages 6-7)
| ID | Steps | Expected | Result |
|----|-------|----------|--------|
| W1 | Log in as student with correct details | Dashboard shown, name and role in header | |
| W2 | Log in with wrong password | Stays on login, safe message, no stack trace | |
| W3 | While logged out, open /courses directly | Redirect to login | |
| W4 | As student, open /reports directly | 403 or redirect, no data shown | |
| W5 | Register for a course with free seats | Success message; appears in My registrations | |
| W6 | Register for the same course again | Rejected with clear message; no duplicate | |
| W7 | Register for a full course | Added to waiting list with position | |
| W8 | Withdraw from a full course | Next waiting student promoted | |
| W9 | Submit request with empty description | Field error under description; form keeps other values | |
| W10 | Enter `<script>alert(1)</script>` in description | Displayed as text, no popup | |
| W11 | Submit a form without the CSRF token (edit hidden field) | Request refused | |
| W12 | Log out then press Back | Protected page not shown from cache | |
| W13 | Open /courses?q=zzzz | "No courses match" empty state | |
| W14 | Use only keyboard (Tab/Enter) to register | Every control reachable, focus visible | |
| W15 | Narrow browser to phone width | No sideways page scroll; tables scroll inside container | |

## Android (Stage 10)
| ID | Steps | Expected | Result |
|----|-------|----------|--------|
| A1 | Log in with valid details | Home screen opens | |
| A2 | Log in with empty fields | Message, no crash | |
| A3 | Open courses, rotate device | Same list shown, no reload flash | |
| A4 | Turn on airplane mode, open courses | "Offline - showing saved data" with cached list | |
| A5 | Fresh install, airplane mode, open courses | "Offline and nothing saved yet" + empty state | |
| A6 | Campus services > tap Registry Office | Map app opens at the location | |
| A7 | Tap "Show my position", allow | Coordinates shown | |
| A8 | Tap "Show my position", deny | Friendly message; app still works | |
| A9 | Start app: no location prompt appears before tapping the button | Prompt only on tap | |
| A10 | Three services configured and each opens a map | PASS for all three | |

## Deployment (Stage 11)
| ID | Steps | Expected | Result |
|----|-------|----------|--------|
| D1 | Fresh machine: follow README only | App runs without asking the authors | |
| D2 | Run SQL scripts twice | Second run succeeds or fails cleanly (documented) | |
| D3 | Stop server mid-request | Clients show user-safe error | |
