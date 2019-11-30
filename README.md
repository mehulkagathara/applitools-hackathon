### Overview
This is Maven based Java project to demonstrate the Applitools Visual AI capabilities over traditional automation approach. The implementation is using some of the [QAF](https://github.com/qmetry/qaf) open source framework features and I am one of the key contributer to this open source selenium based automation framework (it is available under MIT license).

### Setup

#### Option-1
Clone repository
`https://github.com/mehulkagathara/applitools-hackathon.git`

#### Option-2
Download Zip and import as Maven project to your in Eclipse or IntelliJ.

### Intructions
#### Resolve Maven Dependencies
Before running tests, please make sure your resolved project dependencies. After importing project to Eclipse right click on project and navigate to `Maven -> Update Project`.

#### Project Folder Structure
#### resources
`application.properties` - This file is key holder to keep all driver related properties & configurations. Set chrome driver executable path to `webdriver.chrome.driver` properties before execution (by default set to my local path). If you want to execute with other browsers please change `driver.name` properties.

`applitools.properties` - This file contains properties for Applitools like API Key etc.

`data` - this folder contains test data in xml file for data driven test and .properties file for standard user login.

`locators` - this folder contains all application locators in key/value format.

`env1` - Version 1 application urls properties.

`env2` - Version 2 application urls properties.

#### config
`hackathon_suite.xml` is TestNG xml config file and configured tests for both Traditional and Applitools Visual AI tests. Please enable/disabled tests based on what all tests or environment you want to test.

#### driver
This folder is placeholder for browser drivers. Currently it contains for Chrome & Firefox. Code is test on Mac machine and if you want to run test on Windows OS then need to put corresponding driver executables under this folder and set path to `application.properties`.

#### dashboard
This is for reporting and traditional reports can be seen by `dashboard.htm` file. report will only work on Firefox browser.

#### Source Code
`src/main/java` package contains all common page and application level implementation. There are 3 main sub packages
* `com.applitools.hackathon.comp` - created a component to handle table operations
* `com.applitools.hackathon.pages` - POM pages to handle page specific operations
* `com.applitools.hackathon.util` - created listener and useful classes for Eyes