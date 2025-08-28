# VocApp
Test User:

Username: TestUser

Password: abc123


Statitics and Test are still in making

Im application.yml braucht man auf seinem eigenem Rechner SQL installieren. Da es so eingestellt ist:

  datasource:
    url: jdbc:sqlserver://localhost:1433;databaseName=VocTrain;trustServerCertificate=false;encrypt=false;encrypth=false;sendStringParametersAsUnicode=false
    username: testUser
    password: ABCDabcd_123


1. SQL Server 2019 Developer Edition installieren (ideal Einstellung auf English)
2. SQL Server Management Studio installieren
3. <img width="735" height="639" alt="image" src="https://github.com/user-attachments/assets/a22de5bd-3c6b-4d4b-b5d1-e0e2455190d0" />
4. <img width="733" height="657" alt="image" src="https://github.com/user-attachments/assets/ea294675-8bb7-42a1-9f69-6db971230210" />
5. Erstellung einer neuen Anmeldung:
<img width="749" height="659" alt="image" src="https://github.com/user-attachments/assets/a6e682b4-68b1-4b13-990d-28a082794996" />
6. Achtet darauf, dass bei Servereigenschaften unter Security Serverauthentifizierung auf SQL Server- und Windows Authentifizierungsmodus ist.
<img width="731" height="635" alt="image" src="https://github.com/user-attachments/assets/7c43eaac-afd8-42d6-8a56-0c87594682a1" />
