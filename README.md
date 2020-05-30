# Headspin Hackathon Challenge

## Overview
We as **Infostretch** team has built a Maven based Java project for MMT mobile app automation hackathon challenge organized by the Headspin. Source code has some dependency on third party open source libraries like TestNG, Appium etc. and details are mentioned in **Dependencies** section.

## Team - Infostretch
* Mehul Kagathara (Lead)
* Amit Bhoraniya
* Nishith Shah
* Shivam Gohel

## Our Approach
In our implementation, we have tried to demonstrate the idea how we can abstract the technical implementation away from the operational components to support shift-left development and easy maintenance of automation project.
### Below are the key considerations to solve given MMT problem:
* **Structure Approach** - abstract the technical implementation away from the operational components like configurations, locators & test data for easy maintenance.
* **Behaviour Driven Support** - integration with Cucumber for behaviour-driven test authoring make it easier to work together.
* **Unified Scripting Approach** - test or scenario should be unified and it should run across the platform (both Android, iOS & Web).
* **Parallel Support** - integration with TestNG + Cucumber to run feature file scenarios parallel at scale.
* **Reusable Test Assets** - highly maintainable and repeatable tests utilize reusable test assets, proper modularity and semantic structure.
* **Test Data Management** - test data should be abstracted from the technical implementation so it is easier to update the data in future and avoid harding of data in implementation.
* **Reporting** - integrate third party reporting engine which ensures access to all relevant execution data which provide insights desired.
* **Scalability** - solution should be scalable on cloud like Headspin for Continous Testing and tests should run parallel at scale.
## Setup & Usage
Following below steps in order to setup project and execute the test(s).
* Clone https://github.com/mehulkagathara/headspin-hackathon.git repo or Download Zip and import as Maven project in Eclipse or IntelliJ.
* After importing project to Eclipse right click on project and navigate to Maven -> Update Project to resolve the dependencies.
* Make sure you've maven configured in your machine and then run below maven command to run.
* **mvn clean test**
## Dependencies
Below are the maven dependencies used to build this project.
* [org.seleniumhq.selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium)
* [io.appium](https://mvnrepository.com/artifact/io.appium/java-client)
* [com.qmetry](https://mvnrepository.com/artifact/com.qmetry)
* [org.slf4j](https://mvnrepository.com/artifact/org.slf4j)
* [io.github.bonigarcia](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager)

## Framework Design
This automation framework has below core components which helps to drive the automated code execution and structured the code for easy maintenance.
* **Driver Manager** - this component is useful to initialize the Selenium/Appium driver and it's derived from the QAF library.
* **Configuration Manager** - this component is useful to abstract the technical implementation away from the operational components and helps to manage the locators & test data separately.
* **Reporting** - this component is useful to generate the execution report by collecting selenium & appium commands log.
### Folder Structure
* `config` - folder consists all TestNG run configuration xml files in which user can specify what to run. User can also override the any of the properties from the configuration file as well through Parameter.
* `resources` - under this folder there are two sub folders & application.properties file.
    * `locators` - folder consists all application pages locators in separate individual page wise .properties file. A locator can be defined in key-value pair and through out implementation we can use key to refer the elements. So if tomorrow there will be any change in locator we just need to update the properties file and no changes will be required at implementation level. 
    * `testdata` - test data can be provided in .xml format and to consume the data at step level, user just need to provide the xml key to get the value. 
    * `application.properties` - consists all global application & driver related properties. like AUT url and desire capabilities etc.
* `scenarios` -
* `src` -
    * `main/java`
        * `com.infostretch.hs`
    * `test/java`
        * `com.infostretch.hs.components`
        * `com.infostretch.hs.steps`
* `test-results`
* `dashboard.htm`
## Reporting
## Headspin Integration
## CI Integration
## Top Challenges
