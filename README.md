# Vonage sample game
Example java app

Verify docker installation
```
PS C:\Projects\vonage> docker --version
Docker version 19.03.8, build afacb8b
```
Build the package and unit test:
```
docker run -it --rm -v VONAGE_GAME_PATH_ABSOLUTE:/vonage-game -w /vonage-game maven:3.6.3-openjdk-11 mvn clean install
```
Build the application image and run it:
```
docker run -it --rm -v VONAGE_GAME_PATH_ABSOLUTE/target:/vonage-game -w /vonage-game maven:3.6.3-openjdk-11 java -jar vonage-game-1.0-SNAPSHOT.jar MMLMM
```
To clean the workspace of all artifacts just delete the *target* folder.