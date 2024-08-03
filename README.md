
# JDBC Project with DAO and User Input

This is a simple JDBC project demonstrating CRUD operations using a Data Access Object (DAO) pattern and user input from the console. The project performs basic operations on a `users` table, including adding, updating, deleting, and displaying user records.

## Project Structure

```
jdbc-project/
|-- src/
|   |-- main/
|       |-- java/
|           |-- com/
|               |-- example/
|                   |-- dao/
|                       |-- UserDao.java
|                   |-- model/
|                       |-- User.java
|                   |-- util/
|                       |-- DbConnection.java
|                   |-- Main.java
|-- lib/
|-- resources/
|-- build.gradle (if using Gradle)
|-- pom.xml (if using Maven)
```

## Setup

### Prerequisites

- JDK 8 or higher
- Maven or Gradle
- MySQL database

### Database Setup

1. Create a MySQL database and execute the following SQL script to create the `users` table:

    ```sql
    CREATE TABLE users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        username VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        last_login TIMESTAMP
    );
    ```

2. Update the database connection details in `DbConnection.java`:

    ```java
    // src/main/java/com/example/util/DbConnection.java
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    ```

### Project Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/jdbc-project.git
    cd jdbc-project
    ```

2. Add the JDBC library to your project.

    - **Maven**: Add the following dependency to `pom.xml`:

        ```xml
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.25</version>
        </dependency>
        ```

    - **Gradle**: Add the following to `build.gradle`:

        ```groovy
        dependencies {
            implementation 'mysql:mysql-connector-java:8.0.25'
        }
        ```

3. Compile and run the project:

    - **Maven**:

        ```bash
        mvn compile
        mvn exec:java -Dexec.mainClass="com.example.Main"
        ```

    - **Gradle**:

        ```bash
        gradle build
        gradle run
        ```

## Usage

Upon running the project, you will be presented with a menu to perform the following operations:

1. Add User
2. Update User
3. Delete User
4. Display User
5. Display All Users
6. Exit

Follow the prompts to input user details and perform the desired operations.

## Classes

### `User`

Represents the user entity with fields for ID, name, email, username, password, and last login.

### `UserDao`

Contains CRUD operations for the `users` table.

### `DbConnection`

Handles the database connection.

### `Main`

Contains the main method with a menu to perform CRUD operations using the `UserDao`.

## License

This project is licensed under the MIT License.
