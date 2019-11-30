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

#### Project Structure
#### resources folder
`application.properties` - This file is key holder to keep all driver related properties & configurations. Set chrome driver executable path to `webdriver.chrome.driver` properties before execution (by default set to my local path). If you want to execute with other browsers please change `driver.name` properties.

`applitools.properties` - This
