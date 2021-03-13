# How to run the Test #

**Prerequisite**
1. Java environment 
2. Maven 

Project uses **WebDriverManager** (https://github.com/bonigarcia/webdrivermanager), so no driver needs to be manually downloaded. Chromedrived is used in this project.
- It checks the version of the browser installed in your machine (e.g. Chrome, Firefox).
- It matches the version of the driver (e.g. chromedriver, geckodriver). If unknown, it uses the latest version of the driver. - It downloads the driver if it is not present on the WebDriverManager cache (~/.cache/selenium by default).
- It exports the proper WebDriver Java environment variables required by Selenium (not done when using WebDriverManager from the CLI or as a Server).


Project is ready to run. Execute following commands and enjoy the automatic web-driver test.
- Go to project path in terminal. 
- Run `mvn clean`
- Run `mvn compile`
- Run `mvn test`


Project uses **ExtentReport** framework for generating reports. You can find the test reports in project target. When running `mvn clean` before `mvn test`, old test reports will be deleted. Otherwise, the new test results will be added to the test report.
