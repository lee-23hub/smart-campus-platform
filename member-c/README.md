# SCASP - Member C package

Drop these folders into the group repository (merge with `scasp/`).

|Folder|What|Needs from others|
|-|-|-|
|core-domain/.../validation|Validators + JUnit 5 tests|Add pom-snippet.xml to core-domain/pom.xml|
|web-application/src/main/webapp|JSP views, fragments, CSS|Servlets that follow docs/protocols/web-view-contract.md|
|android-client|Java Android app (mock mode on)|Android Studio; set USE\_MOCK=false once JSON endpoints exist|
|docs|Requirements, risks, test plan, manual tests, user guides, demo script, traceability, contribution log|Fill in real evidence as you go|

## Before you submit (important)

1. Nothing here was compiled or run in my environment (no JDK or Android SDK available). Run `mvn test` and build the Android project; fix any small errors, and record the real output as evidence.
2. Evidence must be real: screenshots, test output, thread dumps and usability results have to come from your runs. Blank cells in the logs are intentional.
3. The brief requires generated assistance to be acknowledged. Add a line to your README and contribution log saying AI assistance was used for these files.
4. You may be asked to explain any file in a viva or change it live. Read each file once; the validators and the Android list screens are the likeliest targets.
5. Roles rotate after Stages 3 and 7, so the tasks above move to a different member then.
AI assistance acknowledgement
6. 
7. Initial drafts of the Member C files (validators and tests, JSP views, Android client and documentation) were generated with AI assistance (Claude, by Anthropic). The validator tests were run by Member C on 12 November 2026; see docs/evidence/validators-test-output.txt.

