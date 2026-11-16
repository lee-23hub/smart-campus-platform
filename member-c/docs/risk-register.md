# Risk Register (Stage 0)
| ID | Risk | Likelihood | Impact | Mitigation | Owner |
|----|------|-----------|--------|------------|-------|
| R1 | Modules do not integrate at the end | High | High | Shared interfaces in core-domain; integrate every stage; CI build | A |
| R2 | CORBA modules removed from JDK | Certain | Medium | Dossier-only (IDL + migration design); optional third-party ORB | A |
| R3 | A member unavailable (illness, exams) | Medium | High | Reviewer pairs; contribution log; documented handover | All |
| R4 | Schedule clash with other courses' exams | High | Medium | Stage plan aligned to teaching calendar; weekly 30-minute sync | All |
| R5 | Race conditions pass tests by luck | Medium | High | Latch/barrier tests, not sleep() | B |
| R6 | Secrets committed to Git | Low | High | .gitignore, config templates, pre-commit check | C |
| R7 | Jakarta EE runtime differences between laptops | Medium | Medium | One agreed runtime and version in README | A |
| R8 | Android emulator too heavy for some laptops | Medium | Low | Mock API mode; physical-device option | C |
