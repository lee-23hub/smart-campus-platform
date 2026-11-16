# Traceability Matrix (Stage 11, item 6)

Fill the evidence column with real file paths and commit/tag names. Leave blank until it exists.

|Unit|Stage|Requirement|Implemented in|Tests|Evidence|
|-|-|-|-|-|-|
|1 Collections|1|FR3-FR8|core-domain|ValidatorsTest (31 tests passing)|docs/evidence/validators-test-output.txt|
|2 Multithreading|2|NFR1|concurrent-processing|latch/barrier tests|thread dump, race log|
|3 Networking|3|FR10|network-gateway|network tests|packet trace|
|4 EJB|4|FR4, FR7|enterprise-services|deployment test|deployment log|
|5 JDBC|5|FR11, FR12, NFR2|persistence-jdbc|rollback tests|schema, data dictionary|
|6 Servlets|6|FR1, FR2, NFR3|web-application (servlets, filter)|W1-W12|HTTP evidence|
|7 JSP|7|NFR4-NFR6|web-application (JSP)|W10, W14, W15|screenshots, usability test|
|8 RMI|8|FR14|rmi-administration|failure tests|demo recording|
|9 CORBA|9|-|docs/corba-migration|-|dossier|
|10 Android|10|FR13|android-client|A1-A10|APK, screenshots|



