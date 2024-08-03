# Bank Database Query

This project is a simple Java application that connects to a MySQL database and retrieves account details (age, account number, balance) for a given name from the `accdetails` table in the `bank` database.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- MySQL Connector/J (JDBC Driver)

## Setup

1. **Clone the repository:**

   ```sh
   git clone https://github.com/yourusername/bank-database-query.git
   cd bank-database-query
2.**Add MySQL Connector/J to your project:**

If you're using Maven, add the following dependency to your pom.xml:

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.26</version> <!-- Update to the latest version if needed -->
</dependency>
If you're not using Maven, download the JAR file from the MySQL Connector/J official website and add it to your project's build path.
Configure Database Connection:

3.**Update the database URL, username, and password in the BankDatabaseQuery.java file:**

private static final String DB_URL = "jdbc:mysql://localhost:3306/bank?useSSL=false&allowPublicKeyRetrieval=true"; // Update with your DB URL
private static final String USER = "yourUsername"; // Update with your DB username
private static final String PASS = "yourPassword"; // Update with your DB password

4.**Reconfigure MySQL User (if necessary):**

If you encounter the CLIENT_PLUGIN_AUTH is required error, run the following command in your MySQL server to change the authentication plugin for your user:

ALTER USER 'yourUsername'@'localhost' IDENTIFIED WITH mysql_native_password BY 'yourPassword'

5.**Running the Application**

Compile the Java Code:
javac BankDatabaseQuery.java

Run the Java Application:

java BankDatabaseQuery
The application will print the age, account number, and balance for the specified name.

6.**Contributing**
Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

**License**
This project is licensed under the MIT License - see the LICENSE file for details.
