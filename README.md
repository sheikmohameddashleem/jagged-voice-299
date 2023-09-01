# SparkFlow

# Customer Relationship Management Software

This project is a Customer Relationship Management (CRM) software application that helps manage interactions and relationships between customers and customer support representatives. It is built using Java, JPA, Hibernate, and SQL as the technology stack.

## Key Features

- **Customer Role:**
  - Register a new account.
  - Log in to the system.
  - Raise issues and provide necessary details.
  - View the status of the raised issues.
  - Provide feedback on closed issues.
  - Change account password.
  - Delete the account.

- **Customer Support Representative Role:**
  - Log in to the system.
  - Register a new account.
  - Delete the account.
  - Change account password.
  - View and reply to customer issues.
  - View customer feedback.
## Database Schema
<p> <img src="SparkFlow Database Schema.png" alt="Project Diagram" width="150"> </p>

## Tech Stack

The CRM software is developed using the following technologies:

- Java: The programming language used for the backend development.
- JPA (Java Persistence API): A Java specification for object-relational mapping.
- Hibernate: A popular ORM (Object-Relational Mapping) framework.
- SQL: The standard language for managing and querying databases.

## Installation

To run the CRM software locally, please ensure you have the following prerequisites installed:

- Java Development Kit (JDK)
- MySQL or any other compatible relational database management system
- Apache Maven

Follow these steps to set up and run the project:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/crm-software.git
   ```

2. Navigate to the project directory:

   ```bash
   cd crm-software
   ```

3. Configure the database settings:

   - Open the `application.properties` file.
   - Update the database URL, username, and password according to your local database configuration.

4. Build the project using Maven:

   ```bash
   mvn clean install
   ```

5. Run the application:

   ```bash
   mvn spring-boot:run
   ```

6. Access the CRM software in your web browser at: `http://localhost:8080`

## Usage

1. Register a new account as a customer or customer support representative.
2. Log in using your credentials.
3. Explore the features based on your role (customer or customer support representative).
4. Follow the intuitive user interface to raise issues, provide feedback, view and reply to issues, etc.
5. Remember to securely manage your account, change your password, or delete the account if needed.

## Contributing

Contributions to this project are welcome. If you have any ideas, suggestions, or bug reports, please create an issue or submit a pull request.


