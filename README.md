# Insider QA Test Automation Project

This project contains automated UI tests for the Insider website (useinsider.com) using Selenium WebDriver, Java, and TestNG. The tests are designed following the Page Object Model (POM) design pattern for maintainability and scalability.

## 🚀 Project Overview

The main goal of this project is to automate a specific test scenario on the Insider website, focusing on the Careers page and job application process.

### Test Scenario Steps:

1.  **Visit Insider Website:** Navigate to `https://useinsider.com/`.
2.  **Verify Career Page:** Click on "Company" -> "Careers" and verify that the Careers page, Locations, Teams, and Life at Insider sections are visible.
3.  **Filter Job Positions:** Filter job positions by "Quality Assurance" department and "Istanbul, Turkiye" location.
4.  **Verify Job Listings:** Verify that all listed job positions contain "Quality Assurance" in their title/department and are located in "Istanbul, Turkiye".
5.  **Verify Application Redirection:** Click on the "View Role" button for one of the listed jobs and verify that it redirects to the Lever application form page (`jobs.lever.co`).

## 🛠️ Technologies Used

*   **Java 17+**: Programming Language
*   **Selenium WebDriver 4.x**: For browser automation
*   **TestNG 7.x**: Test Automation Framework
*   **Maven**: Build Automation Tool
*   **WebDriverManager 5.x**: To automatically manage browser drivers (ChromeDriver, etc.)

## 📂 Project Structure

yavuz-insider-test-automation/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── com/insider/
│ │ └── Main.java # (Optional) Main class if any utility is needed
│ └── test/
│ └── java/
│ └── com/insider/
│ ├── base/ # Base classes for common functionalities
│ │ └── DriverManager.java # Manages WebDriver setup and teardown
│ ├── pages/ # Page Object Model classes
│ │ ├── CareersPage.java
│ │ ├── HomePage.java
│ │ ├── LeverPage.java
│ │ └── QAJobsPage.java
│ └── tests/ # Test classes
│ └── InsiderTest.java # Contains all test methods
├── pom.xml # Maven Project Object Model file
├── .gitignore # Specifies intentionally untracked files to ignore
└── README.md # This file


## ⚙️ Setup and Installation

### Prerequisites

*   **Java Development Kit (JDK) 17 or higher** installed.
    *   You can check your Java version by running `java -version` in your terminal.
*   **Maven** installed (usually comes with IDEs like IntelliJ, or can be installed separately).
    *   You can check your Maven version by running `mvn -v` in your terminal.
*   **Google Chrome Browser** installed.

### Steps

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/YOUR_GITHUB_USERNAME/yavuz-insider-test-automation.git
    cd yavuz-insider-test-automation
    ```
    *(Replace `YOUR_GITHUB_USERNAME` with your actual GitHub username and `yavuz-insider-test-automation` with your repository name if different.)*

2.  **Open in IntelliJ IDEA (Recommended IDE):**
    *   Open IntelliJ IDEA.
    *   Select `File` -> `Open...` and navigate to the cloned project directory.
    *   IntelliJ should automatically detect the `pom.xml` and import Maven dependencies. If not, right-click `pom.xml` -> `Maven` -> `Reload Project`.

3.  **Build the Project (Optional, Maven will handle dependencies):**
    ```bash
    mvn clean install
    ```

## ▶️ How to Run Tests

Tests are configured to run using TestNG.

### From IntelliJ IDEA:

1.  Navigate to `src/test/java/com/insider/tests/InsiderTest.java`.
2.  Right-click anywhere in the `InsiderTest.java` file.
3.  Select `Run 'InsiderTest'`.

### From Command Line (using Maven):

1.  Open your terminal in the project root directory (`yavuz-insider-test-automation`).
2.  Run the following command:
    ```bash
    mvn test
    ```

## 📝 Test Results

Test results will be displayed in the console output and also generated in the `target/surefire-reports/` directory.

## 🤝 Contributing

Feel free to fork this repository, make improvements, and submit pull requests.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details (if you choose to add one).

---