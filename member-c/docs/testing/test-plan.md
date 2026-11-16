# Test Plan

## Levels
| Level | Tool | Scope | Run with |
|-------|------|-------|----------|
| Unit | JUnit 5 | Validators, domain invariants, collections | `mvn test` |
| Concurrency | JUnit 5 + CountDownLatch/CyclicBarrier | No overbooking under parallel load | `mvn test` |
| Network | JUnit 5 + local sockets | Malformed message, timeout, disconnect, shutdown | `mvn verify` |
| Persistence | JUnit 5 + test DB | Commit, rollback, constraint failure | `mvn verify` |
| Web | Manual + HTTP client | Auth, roles, validation, sessions | docs/testing/manual-test-cases.md |
| Android | JUnit 4 + manual | Normal, denied permission, offline, empty, rotation | manual-test-cases.md |

## Rules
- No `Thread.sleep()` for synchronisation; use latches or barriers.
- Every defect found gets a row in the defect log with evidence.
- Every test run is recorded in docs/evidence/ using test-report-template.md.
- A feature is "done" only when reviewed by a different member and its tests pass.

## Entry/exit criteria
- Entry: feature merged to a feature branch, builds locally.
- Exit: all automated tests green, manual cases for the stage passed or defects logged.
