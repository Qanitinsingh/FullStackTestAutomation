# FullStackTestAutomation

A comprehensive **Java-based test automation framework** using **Cucumber BDD** and **Selenium WebDriver** for automated testing of web applications with multi-browser support.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Scenarios](#test-scenarios)
- [Project Architecture](#project-architecture)
- [Contributing](#contributing)
- [License](#license)

---

## 🎯 Overview

**FullStackTestAutomation** is a robust test automation framework designed for **BDD (Behavior-Driven Development)** testing. It leverages **Cucumber** for writing human-readable test scenarios and **Selenium WebDriver** for browser automation. The framework supports testing across multiple browsers (Chrome, Firefox, Edge) and provides comprehensive reporting through **ChainTest**.

### Language Composition
- **Java**: 96.7%
- **Gherkin**: 3.3%

---

## ✨ Features

- ✅ **BDD Framework**: Written in Gherkin for readable test scenarios
- ✅ **Multi-Browser Support**: Chrome, Firefox, and Edge drivers
- ✅ **Selenium WebDriver Integration**: Latest version (4.28.0)
- ✅ **Cucumber TestNG Integration**: Seamless test execution and reporting
- ✅ **ChainTest Reporting**: Advanced test reporting and analytics
- ✅ **Logging Framework**: SLF4J with Logback for comprehensive logging
- ✅ **Screenshot Capture**: Automatic screenshots on test failure
- ✅ **Database Support**: MySQL connector for data-driven testing
- ✅ **Playwright Support**: Modern browser automation library (1.55.0)
- ✅ **Page Object Model**: Well-organized page objects and methods
- ✅ **Dynamic Tag Filtering**: Run specific tests using tags (@SmokeTest, @chrome, @firefox)

---

## 🛠️ Tech Stack

| Component | Version | Purpose |
|-----------|---------|---------|
| **Java** | 17 | Programming language |
| **Maven** | Latest | Build and dependency management |
| **Selenium WebDriver** | 4.28.0 | Web browser automation |
| **Cucumber** | 7.21.x | BDD test framework |
| **TestNG** | 7.11.0 | Test runner and assertions |
| **Playwright** | 1.55.0 | Alternative browser automation |
| **SLF4J/Logback** | 1.5.18 | Logging framework |
| **MySQL Connector** | 8.0.33 | Database connectivity |
| **ChainTest** | 1.0.12 | Test reporting and analytics |

---

## 📁 Project Structure

```
FullStackTestAutomation/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── runner/
│       │   │   └── ExecutionManager.java          # Cucumber test runner
│       │   ├── steps/
│       │   │   ├── DemoSteps.java                # Step definitions for login scenarios
│       │   │   ├── ExampleSteps.java             # Step definitions for logo testing
│       │   │   ├── FormSteps.java                # Step definitions for form automation
│       │   │   ├── Hooks.java                    # Before/After hooks for test setup/teardown
│       │   │   └── ...                           # Additional step definition classes
│       │   ├── page/
│       │   │   ├── objects/
│       │   │   │   ├── DemoObjects.java          # Page object locators for login page
│       │   │   │   ├── FormObjects.java          # Page object locators for form page
│       │   │   │   └── ...                       # Additional page object classes
│       │   │   └── methods/
│       │   │       ├── DemoMethods.java          # Page interaction methods
│       │   │       ├── FormMethods.java          # Form interaction methods
│       │   │       └── ...                       # Additional page method classes
│       │   └── utill/
│       │       ├── DriverFactory.java            # WebDriver factory for multi-browser support
│       │       ├── DatabaseUtil.java             # Database utility methods
│       │       └── ...                           # Additional utility classes
│       └── resources/
│           └── Features/
│               ├── Demo.feature                  # Login functionality scenarios
│               ├── Form.feature                  # Form automation scenarios
│               ├── Example.feature               # Logo click scenarios
│               └── ...                           # Additional feature files
│
├── pom.xml                                        # Maven configuration
├── README.md                                      # This file
└── ScreenShots/                                   # Auto-generated test failure screenshots

```

---

## 📦 Prerequisites

Before setting up the project, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 17 or higher
- **Maven**: Version 3.6.0 or higher
- **Git**: For version control
- **Web Browsers**:
  - Google Chrome (latest version)
  - Mozilla Firefox (latest version)
  - Microsoft Edge (optional)

### Verify Installation

```bash
# Check Java version
java -version

# Check Maven version
mvn -version

# Check Git version
git --version
```

---

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/Qanitinsingh/FullStackTestAutomation.git
cd FullStackTestAutomation
```

### 2. Install Dependencies

```bash
# Download all project dependencies
mvn clean install
```

### 3. Verify Setup

```bash
# Compile the project
mvn compile

# Check if all dependencies are resolved
mvn dependency:tree
```

---

## ⚙️ Configuration

### Browser Configuration

The framework automatically selects browsers based on **Scenario Tags** or **System Properties**.

#### Browser Selection Priority

1. **System Property**: `java -Dbrowser=chrome mvn test`
2. **Scenario Tag**: `@chrome`, `@firefox`, `@edge`, `@safari`
3. **Default**: Chrome

### Example: Running with Firefox

```bash
mvn test -Dbrowser=firefox
```

### Test Tag Filtering

The `ExecutionManager.java` runner uses tags to filter tests:

```java
@CucumberOptions(
    features = "src/test/resources/Features/Demo.feature",
    glue = {"steps"},
    tags = "@SmokeTest or @firefox or @chrome"
)
```

---

## 🧪 Running Tests

### Run All Tests

```bash
mvn test
```

### Run Specific Feature File

```bash
mvn test -Dcucumber.features="src/test/resources/Features/Demo.feature"
```

### Run with Specific Tags

```bash
# Run only smoke tests
mvn test -Dcucumber.filter.tags="@SmokeTest"

# Run only Firefox tests
mvn test -Dcucumber.filter.tags="@firefox"

# Run with multiple tags (OR)
mvn test -Dcucumber.filter.tags="@SmokeTest or @chrome"
```

### Run with Specific Browser

```bash
# Chrome (default)
mvn test -Dbrowser=chrome

# Firefox
mvn test -Dbrowser=firefox

# Edge
mvn test -Dbrowser=edge
```

### Clean and Run Fresh

```bash
mvn clean test
```

### Generate Test Reports

```bash
# Run tests with report generation
mvn test

# Reports are generated in:
# target/cucumber-reports/
```

---

## 📝 Test Scenarios

### 1. Demo.feature - Login Functionality

Tests login functionality for the OrangeHRM application:

- **Scenario 1**: Successful login with valid credentials (Firefox)
- **Scenario 2**: Successful login with valid credentials (Chrome)

**Application Under Test**: https://opensource-demo.orangehrmlive.com

```gherkin
@SmokeTest @firefox
Scenario: Successful Login with Valid Credentials in firefox
  Given I navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  When I enter the Username as "Admin" and Password as "admin123"
  And Click on Login Button
  Then I should see the dashboard page
```

### 2. Form.feature - Form Submission

Tests automated form filling and submission across multiple browsers:

- **Scenario Outline**: Fills user form with different data sets
- **Browser Coverage**: Chrome and Firefox
- **Data Examples**: Multiple user profiles

```gherkin
@SmokeTest
Scenario Outline: Fill user form and submit in different browsers
  Given I open the browser "<browser>"
  And I navigate to the form page "https://testing.qaautomationlabs.com/form.php"
  When I fill the form with following details
  And I submit the form
  Then I should see the form submitted successfully
```

### 3. Example.feature - Logo Interaction

Tests logo click functionality and homepage redirection:

```gherkin
@SmokeTest
Scenario: User click on logo
  Given User is on the "https://testing.qaautomationlabs.com/index.php" in chrome
  When User clicks on the logo
  Then User should be redirected to the homepage
```

---

## 🏗️ Project Architecture

### 1. **Test Runner (ExecutionManager.java)**
- Cucumber test runner class
- Configures features, glue code, and plugins
- Handles tag filtering

### 2. **Step Definitions (steps/ package)**
- **DemoSteps.java**: Login-related step implementations
- **ExampleSteps.java**: Logo interaction steps
- **FormSteps.java**: Form automation steps
- **Hooks.java**: Setup and teardown logic, screenshot capture

### 3. **Page Objects (page/ package)**

**page/objects/**:
- Stores locators for UI elements
- Example: `DemoObjects.java` contains XPath/CSS selectors

**page/methods/**:
- Contains business logic methods
- Interacts with WebDriver to perform actions
- Example: `DemoMethods.java` with login methods

### 4. **Utilities (utill/ package)**

- **DriverFactory.java**: Creates and manages WebDriver instances
- **DatabaseUtil.java**: Handles database operations
- Other utility methods for common operations

### 5. **Feature Files (resources/Features/)**
- Written in Gherkin syntax
- Human-readable test scenarios
- Supports Scenario Outlines for data-driven testing

### Test Execution Flow

```
Feature File (Gherkin)
    ↓
Scenario Tags (@SmokeTest, @chrome, etc.)
    ↓
Hooks.java - @Before
    ↓
Step Definitions (Steps.java)
    ↓
Page Methods (page/methods/)
    ↓
Page Objects (page/objects/)
    ↓
Selenium WebDriver
    ↓
Browser Automation
    ↓
Hooks.java - @After (Screenshot capture)
    ↓
ChainTest Reporting
```

---

## 📊 Key Components

### Hooks.java

Handles test lifecycle events:

```java
@Before
public void setup(Scenario scenario) {
    // Launches browser based on scenario tags
    String browser = decideBrowser(scenario);
    DriverFactory.setDriver(browser);
}

@After
public void tearDown(Scenario scenario) {
    // Captures screenshots on failure
    if (scenario.isFailed()) {
        captureScreenshot(scenario);
    }
    // Closes browser
    DriverFactory.quitDriver();
}
```

### DriverFactory.java

Manages WebDriver instances:

- Creates Chrome, Firefox, or Edge drivers
- Provides thread-safe driver management
- Handles driver cleanup

### DemoMethods.java

Contains page interaction logic:

- `enterUrl()`: Navigate to URL
- `performLogin()`: Fill login credentials
- `verifyDashboardPage()`: Assert dashboard visibility

---

## 📸 Screenshots and Logs

### Auto-Generated Artifacts

- **Screenshots**: Saved in `ScreenShots/` directory on test failure
- **Logs**: Captured using SLF4J/Logback in `target/logs/`
- **Reports**: Generated in `target/cucumber-reports/`

### Accessing Screenshots

```
ScreenShots/
├── Successful_Login_with_Valid_Credentials_20250115_143022.png
├── Form_Submission_Success_20250115_143515.png
└── ...
```

---

## 🔧 Troubleshooting

### Common Issues

| Issue | Solution |
|-------|----------|
| **WebDriver not found** | Ensure browser drivers are in PATH or use WebDriverManager |
| **Port already in use** | Kill existing browser processes or change port in config |
| **Timeout on element wait** | Increase wait duration in ExpectedConditions |
| **Test execution hangs** | Check internet connection, reduce wait times |
| **Maven build fails** | Run `mvn clean install -U` to update dependencies |

### Enable Debug Logging

Add to `logback.xml`:

```xml
<logger name="steps" level="DEBUG"/>
<logger name="page.methods" level="DEBUG"/>
```

---

## 🤝 Contributing

We welcome contributions! Please follow these guidelines:

1. **Fork** the repository
2. **Create** a feature branch: `git checkout -b feature/new-tests`
3. **Commit** your changes: `git commit -m "Add new test scenarios"`
4. **Push** to the branch: `git push origin feature/new-tests`
5. **Submit** a Pull Request

### Coding Standards

- Follow Java naming conventions
- Keep step definitions simple and readable
- Use meaningful variable names
- Add comments for complex logic
- Maintain Page Object Model structure

---

## 📄 License

This project is open source and available under the **MIT License**. See LICENSE file for details.

---

## 📧 Contact & Support

- **Author**: Qanitinsingh
- **GitHub**: [@Qanitinsingh](https://github.com/Qanitinsingh)
- **Repository**: [FullStackTestAutomation](https://github.com/Qanitinsingh/FullStackTestAutomation)

For issues, questions, or suggestions, please open a [GitHub Issue](https://github.com/Qanitinsingh/FullStackTestAutomation/issues).

---

## 🎓 Learning Resources

### Cucumber Documentation
- https://cucumber.io/docs/cucumber/

### Selenium WebDriver
- https://www.selenium.dev/documentation/

### TestNG Framework
- https://testng.org/doc/

### Maven Build Tool
- https://maven.apache.org/guides/

---

## 📈 Future Enhancements

- [ ] Add API testing capabilities
- [ ] Implement parallel test execution
- [ ] Add performance testing metrics
- [ ] Integrate with CI/CD pipelines (GitHub Actions, Jenkins)
- [ ] Create data-driven test templates
- [ ] Add visual regression testing
- [ ] Implement test result analytics dashboard

---

**Last Updated**: January 15, 2025 | **Repository**: Qanitinsingh/FullStackTestAutomation
