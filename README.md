# Yavuzcan Çiçek - QA Automation Case Study

This repository contains my solution for a QA automation case study.  
It includes automated UI tests for the **Insider website (useinsider.com)** using Selenium WebDriver, Java, and TestNG.  
The tests are implemented using the **Page Object Model (POM)** design pattern for better maintainability and scalability.

---

## 🚀 Project Overview

The main goal of this project is to automate a specific end‑to‑end test scenario on the Insider website, focusing on the Careers page and job application process.

### Test Scenario Steps

1. **Visit Insider Website**  
   Navigate to `https://useinsider.com/`.

2. **Verify Careers Page**  
   - Open the "Company" menu.  
   - Click on **"Careers"**.  
   - Verify that the **Careers** page is loaded.  
   - Check that **Locations**, **Teams**, and **Life at Insider** sections are visible.

3. **Navigate to QA Careers**  
   - From the Careers page, go to the **Quality Assurance** careers section.  
   - Click on **“See all QA jobs”**.

4. **Filter Job Positions**  
   - Filter job positions by:
     - **Department:** `Quality Assurance`
     - **Location:** `Istanbul, Turkiye`

5. **Verify Job Listings**  
   - Verify that all listed job positions:
     - Are related to **Quality Assurance** (position/department),
     - Have location **“Istanbul, Turkiye”** (or contain `"Istanbul"`).

6. **Verify Application Redirection**  
   - Click on the **“View Role”** button for one of the listed jobs.  
   - Verify that the click opens the **Lever application form page** in a new tab/window (`jobs.lever.co`).  
   - Check that the Lever application page is displayed.

---

## 🛠️ Technologies Used

- **Java 17+** – Programming language  
- **Selenium WebDriver 4.x** – Browser automation  
- **TestNG 7.x** – Test framework  
- **Maven** – Build and dependency management  
- **WebDriverManager 6.x** – Automatic driver management (ChromeDriver, etc.)  
- **IntelliJ IDEA** – Recommended IDE (not mandatory)

---

## 📂 Project Structure

```text
yavuzcan_cicek_in-test-automation/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/insider/
│   │           └── Main.java                # (Optional utility/main entry, not required for tests)
│   └── test/
│       └── java/
│           └── com/insider/
│               ├── base/                   # Base classes and WebDriver management
│               │   └── DriverManager.java  # Sets up and tears down WebDriver
│               ├── pages/                  # Page Object Model classes
│               │   ├── HomePage.java       # Represents useinsider.com home page
│               │   ├── CareersPage.java    # Represents Careers page
│               │   ├── QAJobsPage.java     # Represents QA jobs listing and filters
│               │   └── LeverPage.java      # Represents Lever application form page
│               └── tests/
│                   └── InsiderTest.java    # Contains all TestNG test methods
├── src/
│   └── test/
│       └── resources/
│           └── testng.xml                  # TestNG suite configuration
├── pom.xml                                 # Maven configuration (dependencies, plugins, Java 17)
├── .gitignore                              # Ignored files and folders (target/, .idea/, etc.)
└── README.md                               # Project documentation (this file)


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
