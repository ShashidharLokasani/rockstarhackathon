## Hackathon Test
### Prior condition
1) Java 8 and above to be installed
2) Chrome browser to be downloaded and installed
3) chromedriver to be downloaded and placed in the project folder `src/test/resources/driver`.


### Steps to execute/run
1) Download project and unzip it in safe location
2) Run the below command in project root folder<br>
**On Mac/Linus OS**<br>
`./gradlew test`<br>
**On Windows OS**<br>
`gradlew.bat test`

**Note:** *By default tests will run on version 2 of the app, if you want to run it against version 1, execute the below command*<br>
**On Mac/Linus OS**<br>
`./gradlew test -Dversion=1`<br>
**On Windows OS**<br>
`gradlew.bat test -Dversion=1`

Once after execution the gradle report is generated in build reports folder